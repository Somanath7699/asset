package com.sprint1.assets.service;

import java.util.List;

import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Shipment;


public interface ShipmentService {
	public Shipment createShipment(Shipment shipment);
	public List<Shipment> viewShipment();
	public Shipment getShipmentById(int id) throws NotFoundException;
	public void updateShipment(Shipment shipment) throws NotFoundException;
	
}