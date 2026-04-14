package com.primaryfeed.repository;
import com.primaryfeed.entity.TriggerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriggerLogRepository extends JpaRepository<TriggerLog, Integer> {}