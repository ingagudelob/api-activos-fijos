package com.serinz.activos.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serinz.activos.app.entitys.Asset;
import com.serinz.activos.app.services.IAssetService;

@RestController
@RequestMapping("api/asset")
@CrossOrigin(origins = "*")
public class AssetsController {
	
	@Autowired
	private IAssetService assetService;

	@GetMapping
	public ResponseEntity<List<Asset>> getAsset() {
		List<Asset> listAsset = assetService.getAsset();
		return ResponseEntity.ok(listAsset);
	}
	
	@GetMapping("/{assetNumber}")
	public ResponseEntity<Asset> findAssetByID(@PathVariable Long assetNumber){
		Asset assetFind = assetService.findById(assetNumber); 
		return ResponseEntity.ok(assetFind);
	}
	
	@PostMapping("/agregar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> agregarAsset(@Valid @RequestBody Asset request) {
		assetService.newAsset(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Activo creado correctamente");
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateAsset(@RequestBody Asset request) {
		
		Asset assetEditar = assetService.findById(request.getAssetNumber());
		assetEditar.setDescription(request.getDescription());
		assetEditar.setName(request.getName());
		assetEditar.setPurchasePrice(request.getPurchasePrice());
		assetEditar.setSerial(request.getSerial());
		assetEditar.setType(request.getType());
		assetEditar.setDependency(request.getDependency());
		
		assetService.updateAsset(assetEditar);
		return ResponseEntity.status(HttpStatus.OK).body("Activo " + request.getName() + " ha sido actualizado");
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String assetsDelete(@PathVariable Long id) {
		assetService.deleteAssetById(id);
		return "Eliminado correctamente activo con id: "+ id;
	}
	
	@GetMapping("/del/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String del(@PathVariable Long id) {
		
		try {
			Asset delClient = assetService.findById(id);
			if (delClient.getAssetNumber() == id) {
				assetService.deleteAssetById(id);
				return "Eliminado correctamente activo con id: "+ id;
				
			}
		} catch (Exception e) {
			return "No econtrado";
		}
		return null;
	}
	
	
	
}
