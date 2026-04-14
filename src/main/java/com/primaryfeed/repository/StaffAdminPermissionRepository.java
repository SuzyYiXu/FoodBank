package com.primaryfeed.repository;
import com.primaryfeed.entity.StaffAdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StaffAdminPermissionRepository extends JpaRepository<StaffAdminPermission, Integer> {
    List<StaffAdminPermission> findByStaff_StaffId(Integer staffId);
}