package com.sprint1.assets.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Asset;
import com.sprint1.assets.repository.AssetManagementRepository;

@Service("assetImplementation")
public class AssetServiceImpl implements AssetService {
	@Autowired
	AssetManagementRepository assetRepository;
	
	@Transactional
	@Override
	public Asset addAsset(Asset asset)
	{
	return assetRepository.save(asset);
	}
	
	@Transactional
	@Override
	public boolean deleteAsset(int id) throws NotFoundException
	{
	if(assetRepository.existsById(id)) {
	assetRepository.deleteById(id);
	return true;
	}
	return false;
	}
		
	@Override
	public Asset searchAsset(int id) throws NotFoundException
	{
		
		if(assetRepository.existsById(id)) {
			assetRepository.findById(id);
			return assetRepository.findById(id).get();
		}
		return null;
	}
	
	@Transactional
	@Override
	public Asset modifyAsset(Asset asset)  throws NotFoundException
	{	
		Asset a1= null;
		if(assetRepository.existsById(asset.getAsset_id())) {
			a1=assetRepository.save(asset);
		}
		return a1;
	}
	
	@Override
	public List<Asset> viewAsset() 
	{
		return assetRepository.findAll();
	}
	
	
}
