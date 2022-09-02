package com.serinz.activos.app.services;

import java.util.List;

import com.serinz.activos.app.entitys.Asset;

public interface IAssetService {

	public List<Asset> getAsset();
	public Asset findById(Long id);
	public Asset newAsset(Asset addAsset);
	public Asset updateAsset(Asset putAsset);
	public String deleteAssetById(Long id);
	public List<Asset> findByType(String type);
	public Asset findAssetBySerial(String serial);
	public List<Asset> findAssetByDate(String purchase_date);

}
