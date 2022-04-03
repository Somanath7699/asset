package com.sprint1.assets.controller;

import java.util.Date;
import java.util.List;

//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assets.model.Asset;
import com.sprint1.assets.model.Status;
import com.sprint1.assets.service.ReportService;

@RestController
public class ReportController {
	@Autowired
	ReportService reportService;

	// Generating Weekly Report
	@GetMapping(path = "/GenerateReport/{status}")

	public ResponseEntity<List<Asset>> GenerateReportByStatus(@PathVariable("status") Status status) {
//		Status s1;	
//		s1=Enum.valueOf(Status.class, status);
		
//		System.out.println("controller s1 =" +s1);
		  List<Asset> rep = reportService.GenerateReportByStatus(status);
		return new ResponseEntity<List<Asset>>(rep,HttpStatus.OK);
	}
	@GetMapping(path = "/GenerateReport/{fromDate}/{toDate}/{status}")
	public List<Asset> GenerateReportByMonthStatus(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate, @PathVariable("status") Status status ) {
		Date d1 = new Date(fromDate);
		Date d2 = new Date(toDate);
		return reportService.generateMonthlyReport(d1, d2, status);	
		
	}
}

//	//Generating Monthly Report
//	@GetMapping(path="/GenerateMonthlyReport/{month}")
//	public String generateMonthlyReport(@PathVariable String month) throws IOException, NotFoundException {
//		
//	reportImplementation.generateMonthlyReport(month);
//		return "Monthly report generated successfully. The downloaded file has been stored in the D drive in the name of MonthlyReport";
//		
//	}
//	@GetMapping(path="/viewMaintain")
//	public List<Maintain> viewMaintainRecords(){
//		return reportImplementation.viewMaintain();
//	}
//}

//GenerateReportByStatus(String Status) - custom query in AssetRepository
//GenerateReportByMonthStatus(Fromdate,Todate Status) - custom query in AssetRepository
