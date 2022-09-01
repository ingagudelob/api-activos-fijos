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
import com.serinz.activos.app.entitys.Asset;

@Service
public class AssetServiceImpl implements IAssetService {

	@Autowired
	private AssetDAO assetDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Asset> getAsset() {
		return (List<Asset>) assetDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Asset findById(Long assetNumber) {

		if (!assetDAO.existsById(assetNumber)) {
			throw new NotFoundException("Asset does not Exist");
		}
		return assetDAO.findById(assetNumber).orElse(null);
	}

	@Override
	@Transactional
	public Asset newAsset(Asset addAsset) {
		if (addAsset.getDescription() == null || addAsset.getDescription().isEmpty()) {
			throw new BadRequestException("La descripción no puede ser nula o vacía");
		}
		if (addAsset.getSerial() == null || addAsset.getSerial().isEmpty()) {
			throw new BadRequestException("El serial no puede ser nulo o vacío");
		}
		if (addAsset.getName() == null || addAsset.getName().isEmpty()) {
			throw new BadRequestException("El nombre no puede ser nulo o vacío");
		}
		if (addAsset.getType() == null || addAsset.getType().isEmpty()) {
			throw new BadRequestException("El tipo no puede ser nulo o vacío");
		}
		if (addAsset.getDependency() == null || addAsset.getDependency().isEmpty()) {
			throw new BadRequestException("La dependencia no puede ser nula o vacía");
		}
		if (addAsset.getPurchasePrice() == null) {
			throw new BadRequestException("El precio de compra no puede ser nulo o vacío");
		}
		return assetDAO.save(addAsset);
	}

	@Override
	@Transactional
	public Asset updateAsset(Asset putAsset) {
		if (putAsset.getAssetNumber() == null) {
			throw new InternalServerError("El numero de activo no puede ser nulo", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!assetDAO.existsById(putAsset.getAssetNumber())) {
			throw new NotFoundException("Asset does not Exist");
		}
		if (putAsset.getDescription() == null || putAsset.getDescription().isEmpty()) {
			throw new BadRequestException("La descripción no puede ser nula o vacía");
		}
		if (putAsset.getName() == null || putAsset.getName().isEmpty()) {
			throw new BadRequestException("El nombre no puede ser nulo o vacío");
		}
		if (putAsset.getPurchasePrice() == null) {
			throw new BadRequestException("El precio no puede ser nulo o vacío");
		}
		if (putAsset.getSerial() == null || putAsset.getSerial().isEmpty()) {
			throw new BadRequestException("El serial no puede ser nulo o vacío");
		}
		if (putAsset.getType() == null || putAsset.getType().isEmpty()) {
			throw new BadRequestException("El tipo no puede ser nulo o vacío");
		}
		return assetDAO.save(putAsset);
	}

	@Override
	@Transactional
	public String deleteAssetById(Long assetNumber) {
		if (!assetDAO.existsById(assetNumber)) {
			throw new NotFoundException("Asset does not Exist");
		}
		assetDAO.deleteById(assetNumber);
		return "Eliminado correctamente";
	}

	

	

	

}
