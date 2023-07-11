package com.yash.ytms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ytms.model.DailyProgressReport;

public interface DailyProgressReportRepository extends JpaRepository<DailyProgressReport, Integer>
{

}
