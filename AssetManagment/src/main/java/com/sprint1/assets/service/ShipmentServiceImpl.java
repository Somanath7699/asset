package com.sprint1.assets.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Shipment;
import com.sprint1.assets.repository.ShipmentRepository;

@Service("shipmentImplementation")
public class ShipmentServiceImpl implements ShipmentService  {
	@Autowired
	ShipmentRepository shipmentrepository;
	
	
	@Transactional
	@Override
	public Shipment createShipment(Shipment shipment) {
		return shipmentrepository.save(shipment);		
	}
	
	@Override
	public List<Shipment> viewShipment() {
		return shipmentrepository.findAll();		
	}
	
	@Override
	public Shipment getShipmentById(int id) throws NotFoundException
	{
		if(shipmentrepository.existsById(id)) {
			return shipmentrepository.findById(id).get();
		}
		return null;
	}	
	
	@Override
	public void updateShipment(Shipment shipment) throws NotFoundException {
		shipmentrepository.save(shipment);
		
	}


}