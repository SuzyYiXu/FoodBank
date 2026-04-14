package com.primaryfeed.repository;
import com.primaryfeed.entity.DonationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DonationItemRepository extends JpaRepository<DonationItem, Integer> {
    List<DonationItem> findByDonation_DonationId(Integer donationId);
}