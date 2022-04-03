package com.sprint1.assets.controller;

import java.util.List;
//import java.util.Optional;

import javax.validation.Valid;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Asset;
import com.sprint1.assets.service.AssetServiceImpl;

@RestController
@RequestMapping(path="/api/asset")
public class AssetManagementController {
	// Creating logger Object
	Logger logger = org.slf4j.LoggerFactory.getLogger(AssetManagementController.class);
	@Autowired
	AssetServiceImpl assetImplementation;

	// Creating and saving Asset
	@PostMapping(path = "/create")
	public ResponseEntity<String> createAsset(@Valid @RequestBody Asset asset){
		Asset saved_asset = assetImplementation.addAsset(asset);
		logger.info("Asset Created");
		ResponseEntity<String> response = new ResponseEntity<>(
				"Asset with the ID" + saved_asset.getAsset_id() + "is created", HttpStatus.CREATED);
		return response;
	}

	// Displaying Assets
	@GetMapping(path = "/viewall")
	public ResponseEntity<List<Asset>> viewAsset() {
		List<Asset> listOfAsset = assetImplementation.viewAsset();
		if(listOfAsset.isEmpty()) {
			return new ResponseEntity("List no asset found", HttpStatus.NOT_FOUND);
		}
		System.out.println("-----------------------------------------");
		System.out.println(listOfAsset);
		//ResponseEntity<List<Asset>> response = new ResponseEntity<>(listOfAsset, HttpStatus.OK);
		return new ResponseEntity<List<Asset>>(listOfAsset, HttpStatus.OK);
	}

	// Removing Assets
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteAsset(@PathVariable int id) throws NotFoundException {
		boolean asset_removed = assetImplementation.deleteAsset(id);
		logger.info("Asset Deleted");
		ResponseEntity<String> response = new ResponseEntity<>("Asset with the ID" + id + "is deleted", HttpStatus.OK);
		if (asset_removed) {
			return response;
		}
		return null;
	}

	// Updating Assets
	@PutMapping(path = "/update")
	public ResponseEntity<Asset> updateAsset(@RequestBody Asset asset) throws NotFoundException{
		Asset asset_updated = assetImplementation.modifyAsset(asset);
		logger.info("Asset Updated");

		if (!(asset_updated==null)) {
			return new ResponseEntity<Asset>(asset_updated, HttpStatus.OK);
		}
		return null;
	}

	// Finding Assets
	@GetMapping(path = "/get/{id}")
	public Asset getAssetById(@PathVariable int id) throws NotFoundException {

		Asset asset = assetImplementation.searchAsset(id);
		return asset;
	}

}
