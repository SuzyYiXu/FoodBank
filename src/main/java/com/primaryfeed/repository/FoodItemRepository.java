package com.primaryfeed.repository;
import com.primaryfeed.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, String> {
    List<FoodItem> findByCategory_CategoryId(Integer categoryId);
    List<FoodItem> findByFoodNameContainingIgnoreCase(String name);
}