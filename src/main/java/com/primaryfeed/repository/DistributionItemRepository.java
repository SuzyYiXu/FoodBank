package com.primaryfeed.repository;
import com.primaryfeed.entity.DistributionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DistributionItemRepository extends JpaRepository<DistributionItem, Integer> {
    List<DistributionItem> findByDistribution_DistributionId(Integer distributionId);
}