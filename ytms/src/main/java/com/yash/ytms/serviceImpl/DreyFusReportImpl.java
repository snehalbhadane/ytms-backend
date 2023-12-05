package com.yash.ytms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.model.DreyFusReport;
import com.yash.ytms.repo.DreyFusReportRepository;
import com.yash.ytms.service.DreyFusReportService;

@Service
public class DreyFusReportImpl implements DreyFusReportService {

	@Autowired
	DreyFusReportRepository dreyFusRepo;

	@Override
	public DreyFusReport addReport(DreyFusReport dfr) {
		return this.dreyFusRepo.save(dfr);
	}

	@Override
	public List<DreyFusReport> viewDreyfusReport() {
		return this.dreyFusRepo.findAll();
	}
}
