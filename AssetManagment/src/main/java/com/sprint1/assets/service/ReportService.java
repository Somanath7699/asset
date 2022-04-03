package com.sprint1.assets.service;

import java.util.Date;
import java.util.List;

import com.sprint1.assets.model.Asset;
import com.sprint1.assets.model.Status;

public interface ReportService {
	public List<Asset> GenerateReportByStatus(Status status);
	public List<Asset> generateMonthlyReport(Date fromDate, Date toDate, Status status);
}
