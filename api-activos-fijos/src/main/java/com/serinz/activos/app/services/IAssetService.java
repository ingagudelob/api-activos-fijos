package com.serinz.activos.app.services;

import java.util.List;

import com.serinz.activos.app.entitys.Asset;

public interface IAssetService {

	public List<Asset> getAsset();
	public Asset findById(Long id);
	public Asset newAsset(Asset addAsset);
	public Asset updateAsset(Asset putAsset);
	public String deleteAssetById(Long id);

}
