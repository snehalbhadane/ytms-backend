
package com.yash.ytms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.ytms.model.DreyFusReport;

@Service
public interface DreyFusReportService {

	DreyFusReport addReport(DreyFusReport dfr);

	List<DreyFusReport> viewDreyfusReport();

}
