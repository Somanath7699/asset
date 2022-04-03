package com.sprint1.assets.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assets.model.Asset;
import com.sprint1.assets.model.Status;
import com.sprint1.assets.repository.AssetManagementRepository;

@Service
public class ReportServiceImpl implements ReportService {
	

	@Autowired
	private AssetManagementRepository assetRepo;
	@Override
	public List<Asset> GenerateReportByStatus(Status status) {
		System.out.println(status);
		return assetRepo.getReportStatus(status);
		
	}
	@Override
	public List<Asset> generateMonthlyReport(Date fromDate, Date toDate, Status status) {
		return assetRepo.generateMonthlyReport(fromDate, toDate, status);
	}

	

}
