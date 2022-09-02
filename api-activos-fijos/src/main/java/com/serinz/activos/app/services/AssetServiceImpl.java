package com.serinz.activos.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serinz.activos.app.configs.exceptions.BadRequestException;
import com.serinz.activos.app.configs.exceptions.InternalServerError;
import com.serinz.activos.app.configs.exceptions.NotFoundException;
import com.serinz.activos.app.dao.AssetDAO;
import com.serinz.activos.app.dao.assetDaoQuery;
import com.serinz.activos.app.entitys.Asset;

@Service
public class AssetServiceImpl implements IAssetService {

	@Autowired
	private AssetDAO assetDAO;

	@Autowired
	private assetDaoQuery assetDaoQuery;

	@Override
	@Transactional(readOnly = true)
	public List<Asset> getAsset() {
		return (List<Asset>) assetDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Asset findById(Long assetNumber) {
		
		if(isNumeric(assetNumber)) {
			throw new NotFoundException("/Error/ - Formato incorrecto para la consulta");
		}		
		if (!assetDAO.existsById(assetNumber)) {
			throw new NotFoundException("/Error/ - Activo fijo no existente");
		}
		return assetDAO.findById(assetNumber).orElse(null);
	}

	@Override
	@Transactional
	public Asset newAsset(Asset addAsset) {
		if (addAsset.getDescription() == null || addAsset.getDescription().isEmpty()) {
			throw new BadRequestException("/Error/ - La descripción no puede ser nula o vacía");
		}
		if (addAsset.getSerial() == null || addAsset.getSerial().isEmpty()) {
			throw new BadRequestException("/Error/ - El serial no puede ser nulo o vacío");
		}
		if (addAsset.getName() == null || addAsset.getName().isEmpty()) {
			throw new BadRequestException("/Error/ - El nombre no puede ser nulo o vacío");
		}
		if (addAsset.getType() == null || addAsset.getType().isEmpty()) {
			throw new BadRequestException("/Error/ - El tipo no puede ser nulo o vacío");
		}
		if (addAsset.getDependency() == null || addAsset.getDependency().isEmpty()) {
			throw new BadRequestException("/Error/ - La dependencia no puede ser nula o vacía");
		}
		if (addAsset.getPurchasePrice() == null) {
			throw new BadRequestException("/Error/ - El precio de compra no puede ser nulo o vacío");
		}
		return assetDAO.save(addAsset);
	}

	@Override
	@Transactional
	public Asset updateAsset(Asset putAsset) {
		if (putAsset.getAssetNumber() == null) {
			throw new InternalServerError("/Error/ - El numero de activo no puede ser nulo", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!assetDAO.existsById(putAsset.getAssetNumber())) {
			throw new NotFoundException("/Error/ - Activo fijo no existente");
		}
		if (putAsset.getDescription() == null || putAsset.getDescription().isEmpty()) {
			throw new BadRequestException("/Error/ - La descripción no puede ser nula o vacía");
		}
		if (putAsset.getName() == null || putAsset.getName().isEmpty()) {
			throw new BadRequestException("/Error/ - El nombre no puede ser nulo o vacío");
		}
		if (putAsset.getPurchasePrice() == null) {
			throw new BadRequestException("/Error/ - El precio no puede ser nulo o vacío");
		}
		if (putAsset.getSerial() == null || putAsset.getSerial().isEmpty()) {
			throw new BadRequestException("/Error/ - El serial no puede ser nulo o vacío");
		}
		if (putAsset.getType() == null || putAsset.getType().isEmpty()) {
			throw new BadRequestException("/Error/ - El tipo no puede ser nulo o vacío");
		}
		return assetDAO.save(putAsset);
	}

	@Override
	@Transactional
	public String deleteAssetById(Long assetNumber) {
		if (!assetDAO.existsById(assetNumber)) {
			throw new NotFoundException("/Error/ - Activo no existente");
		}
		assetDAO.deleteById(assetNumber);
		return "Eliminado correctamente";
	}

	@Override
	@Transactional
	public List<Asset> findByType(String type) {
		if (type == null || type.isEmpty()) {
			throw new InternalServerError("/Error/ - El Tipo de activo no puede ser nulo o vacio", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		List<Asset> data =  assetDaoQuery.searchByType(type);
		if(data.isEmpty()) {
			throw new BadRequestException("/Error/ - NO existe este tipo de activos en la Base de datos");
		}
		return data;
	}

	@Override
	@Transactional
	public Asset findAssetBySerial(String serial) {
		if (serial == null || serial.isEmpty()) {
			throw new InternalServerError("El serial de activo no puede ser nulo o vacio", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Asset data = assetDaoQuery.searchBySerial(serial);
		if(data == null) {
			throw new BadRequestException("/Error/ - NO existe este serial en la Base de datos");
		}
		return data;

	}

	@Override
	@Transactional
	public List<Asset> findAssetByDate(String purchase_date) {
		if (purchase_date == null || purchase_date.isEmpty()) {
			throw new InternalServerError("El Tipo de activo no puede ser nulo o vacio", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		List<Asset> data = assetDaoQuery.searchByDate(purchase_date);
		if(data.isEmpty()) {
			throw new BadRequestException("/Error/ - NO existen activos para esta fecha en la Base de datos");
		}
		return data;
	}
	
	private static boolean isNumeric(Long assetNumber){
		try {
			String formatOut = assetNumber.getClass().getSimpleName();
			if(formatOut != "Long") {
				return false;
			} else return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	


}


	


