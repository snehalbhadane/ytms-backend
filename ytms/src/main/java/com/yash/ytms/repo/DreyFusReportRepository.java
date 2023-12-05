package com.yash.ytms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.DreyFusReport;

@Repository
public interface DreyFusReportRepository extends JpaRepository<DreyFusReport, Integer>
{

}
