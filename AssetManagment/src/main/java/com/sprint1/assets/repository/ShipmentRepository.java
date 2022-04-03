package com.sprint1.assets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.assets.model.Shipment;


@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

	
		
}
