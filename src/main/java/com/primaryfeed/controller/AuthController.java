package com.primaryfeed.controller;

import com.primaryfeed.auth.JwtUtil;
import com.primaryfeed.entity.User;
import com.primaryfeed.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    // POST /api/auth/login
    // Body: { "email": "...", "password": "..." }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email    = body.get("email");
        String password = body.get("password");

        User user = userRepo.findByEmail(email).orElse(null);
        System.out.println("=== LOGIN DEBUG ===");
        System.out.println("User found: " + (user != null));
        if (user != null) System.out.println("Match: " + passwordEncoder.matches(password, user.getPasswordHash()));
        System.out.println("User found: " + (user != null));
        if (user != null) {
            System.out.println("Hash in DB: " + user.getPasswordHash());
            System.out.println("Match: " + passwordEncoder.matches(password, user.getPasswordHash()));
        }


        if (user.getStatus() == 0) {
            return ResponseEntity.status(403).body(Map.of("error", "Account inactive"));
        }

        String token = jwtUtil.generateToken(email, user.getRoleName());

        return ResponseEntity.ok(Map.of(
                "token", token,
                "role",  user.getRoleName(),
                "userId", user.getUserId(),
                "name",  user.getFirstName() + " " + user.getLastName()
        ));
    }

    // GET /api/auth/me  (requires Bearer token)
    @GetMapping("/me")
    public ResponseEntity<?> me(@RequestHeader("Authorization") String header) {
        String token = header.substring(7);
        String email = jwtUtil.extractEmail(token);
        User user = userRepo.findByEmail(email).orElse(null);
        if (user == null) return ResponseEntity.status(404).body("Not found");
        return ResponseEntity.ok(user);
    }
}