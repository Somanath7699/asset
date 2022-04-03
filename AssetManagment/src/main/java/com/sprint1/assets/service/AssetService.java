package com.sprint1.assets.service;
import java.util.List;

import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Asset;




public interface AssetService {

public Asset addAsset(Asset asset);
public boolean deleteAsset(int id) throws NotFoundException;
public Asset modifyAsset(Asset asset) throws NotFoundException;
public List<Asset> viewAsset();
public Asset searchAsset(int id) throws NotFoundException ;
	
}

