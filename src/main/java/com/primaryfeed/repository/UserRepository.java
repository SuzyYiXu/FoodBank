package com.primaryfeed.repository;
import com.primaryfeed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);           // used by auth
    List<User> findByRole(Byte role);                   // filter by Staff/Volunteer
    List<User> findByBranch_BranchId(Integer branchId);
    boolean existsByEmail(String email);
}