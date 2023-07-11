package com.yash.ytms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.TrainingPerformanceReport;

@Repository
public interface TrainingPerformanceReportRepository extends JpaRepository<TrainingPerformanceReport, Integer> {

}
