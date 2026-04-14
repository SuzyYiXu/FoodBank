package com.primaryfeed.repository;
import com.primaryfeed.entity.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminPermissionRepository extends JpaRepository<AdminPermission, Integer> {}