package com.example.exam9.repository;

import com.example.exam9.entity.WorkLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkLogRepository extends JpaRepository<WorkLogs, Long> {

}
