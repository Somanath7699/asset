package com.sprint1.assets.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assets.exception.NoAccessException;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Shipment;
import com.sprint1.assets.service.ShipmentServiceImpl;

@RestController
@RequestMapping("api/shipment")
public class ShipmentController {
	// Creating Logger Object
	Logger logger = org.slf4j.LoggerFactory.getLogger(ShipmentController.class);
	@Autowired
	ShipmentServiceImpl shipmentImplementation;

	// Creating and Saving Shipments
	@PostMapping(path = "/create")
	public ResponseEntity<String> createShipment(@RequestBody Shipment shipment){
		Shipment shipment_obj = shipmentImplementation.createShipment(shipment);
		logger.info("Shipment Created");
		ResponseEntity<String> response = new ResponseEntity<>(
				shipment_obj.getShipment_company_name() + " is registered with the Id " + shipment_obj.getShipment_id(),
				HttpStatus.CREATED);
		return response;
	}

	// Updating Shipments
	@PutMapping(path = "/Update")
	public String updateShipment(@RequestBody Shipment shipment) throws NotFoundException {
		shipmentImplementation.updateShipment(shipment);
		return "Updated Successfully";
	}

	// Displaying Shipments
	@GetMapping(path = "/viewAll")
	public List<Shipment> viewShipment() {
		List<Shipment> listOfShipment = shipmentImplementation.viewShipment();
		for (Shipment shipment : listOfShipment) {
			logger.info(shipment.getShipment_id() + " " + shipment.getShipment_company_name() + " "
					+ shipment.getShipment_state() + " " + shipment.getShipment_country() + " "
					+ shipment.getSubLocation());
		}
		return listOfShipment;
	}

	// Finding Shipments
	@GetMapping(path = "/get/{id}")
	public Shipment getShipmentById(@PathVariable int id) throws NotFoundException {

		return shipmentImplementation.getShipmentById(id);
	}

//	@DeleteMapping(path = "/delete/{id}")
//	public boolean deleteShipmentbyId(@PathVariable int id) throws NotFoundException {
//		return shipmentImplementation.deleteShipment(id);
//	}
	
	
}
