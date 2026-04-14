package com.primaryfeed.controller;
import com.primaryfeed.entity.FoodBank;
import com.primaryfeed.repository.FoodBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/food-banks")
@RequiredArgsConstructor
public class FoodBankController {
    private final FoodBankRepository repo;

    @GetMapping public List<FoodBank> getAll() { return repo.findAll(); }
    @GetMapping("/{id}") public FoodBank getById(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found: " + id));
    }
    @PostMapping public FoodBank create(@RequestBody FoodBank fb) { return repo.save(fb); }
}