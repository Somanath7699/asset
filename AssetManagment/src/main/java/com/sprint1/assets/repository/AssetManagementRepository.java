package com.sprint1.assets.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint1.assets.model.Asset;
import com.sprint1.assets.model.Status;

@Repository
public interface AssetManagementRepository extends JpaRepository<Asset,Integer> {

	//Optional<Asset> getAssetbyShipment_id(int id);
	
	@Query ("select a from Asset a where a.asset_status=?1")
	public List<Asset> getReportStatus(Status status);

	@Query ("select a from Asset a where a.asset_Movement_date >=?1 and a.asset_Movement_date<=?2 and a.asset_status=?3")
	public List<Asset> generateMonthlyReport(Date fromDate, Date toDate, Status status);


	
	
}