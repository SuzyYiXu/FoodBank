package com.primaryfeed.repository;
import com.primaryfeed.entity.FoodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FoodBankRepository extends JpaRepository<FoodBank, Integer> {
    Optional<FoodBank> findByEmail(String email);
}