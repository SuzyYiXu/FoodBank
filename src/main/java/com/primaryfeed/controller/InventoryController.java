package com.primaryfeed.controller;
import com.primaryfeed.entity.Inventory;
import com.primaryfeed.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryRepository repo;

    @GetMapping public List<Inventory> getAll() { return repo.findAll(); }
    @GetMapping("/branch/{id}") public List<Inventory> byBranch(@PathVariable Integer id) {
        return repo.findByBranch_BranchId(id);
    }
    @GetMapping("/expiring") public List<Inventory> expiring() {
        return repo.findExpiringSoon(LocalDateTime.now().plusMonths(3));
    }
}