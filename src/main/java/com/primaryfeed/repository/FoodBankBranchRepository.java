package com.primaryfeed.repository;
import com.primaryfeed.entity.FoodBankBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodBankBranchRepository extends JpaRepository<FoodBankBranch, Integer> {
    List<FoodBankBranch> findByFoodBank_FoodBankId(Integer foodBankId);
}