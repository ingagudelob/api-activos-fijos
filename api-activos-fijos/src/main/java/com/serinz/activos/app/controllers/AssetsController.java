package com.serinz.activos.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serinz.activos.app.entitys.Asset;
import com.serinz.activos.app.services.IAssetService;


/**
 * Controlador de para el modelo de Asset
 * @author ing_j
 *
 */
@RestController
@RequestMapping("api/asset")
@CrossOrigin(origins = "*")
public class AssetsController {
	
	@Autowired
	private IAssetService assetService;

	
	/**
	 * Peticion GET para obtener el listado de lo Activos fijos
	 * @return Devuelve una lista con todos lo Activos
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Asset>> getAsset() {
		List<Asset> listAsset = assetService.getAsset();
		return ResponseEntity.ok(listAsset);
	}
	
	/**
	 * Peticion GET para obtener el listado de lo Activos fijos segun su numero de activo fijo
	 * @param assetNumber Recibe como parametro para la obtencion del activo en particular
	 * @return Retorna un status y el objeto con la información solicitada en caso de ser positivo, en el caso de 
	 * no encontrar algun registro devuelve el status BAD_REQUES y un mensaje al body
	 */
	@GetMapping(value={"/{assetNumber:[0-9]}"})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> findAssetByID(@PathVariable(value = "assetNumber", required= true) Long assetNumber){
		try {
			Asset assetFind = assetService.findById(assetNumber); 
			return ResponseEntity.status(HttpStatus.OK).body(assetFind);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("/Error/ - El Activo no existe en la base de datos");
			// TODO: handle exception
		}
		
	}
	
	/**
	 * Peticion POST para agregar o crear un activo fijo
	 * @param request recibe como parametro un objeto JSON con la información a traves del body.
	 * @return Devuelve el HttpStatu CREATED en caso de ser positivo y un mensaje a traves del body.
	 */
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> agregarAsset(@Valid @RequestBody Asset request) {
		assetService.newAsset(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Activo creado correctamente");
	}

	/**
	 * Peticion PUT para la actualización de la información que puede ser editada de un activo fijo
	 * @param request Recibe como parametro un Objeto JSON con la información a actualizar
	 * @return Devuelve HttpStatus y un mensaje a traves del body
	 */
	@PutMapping("/update")
	public ResponseEntity<String> updateAsset(@RequestBody Asset request) {
		
		Asset assetEditar = assetService.findById(request.getAssetNumber());
		assetEditar.setDescription(request.getDescription());
		assetEditar.setName(request.getName());
		assetEditar.setPurchasePrice(request.getPurchasePrice());
		assetEditar.setSerial(request.getSerial());
		assetEditar.setType(request.getType());
		//assetEditar.setCity(request.getCity());
		
		assetService.updateAsset(assetEditar);
		return ResponseEntity.status(HttpStatus.OK).body("Activo " + request.getName() + " ha sido actualizado");
	}
	
	
	/**
	 * Peticion GET  y Metodo para eliminar un Activo Fijo a partir de un id o assetNumber
	 * @param asset_number Recibe un parametro para realiza consulta y la eliminación
	 * @return devuelve un HttpStatus.NO_CONTENT y un texto en el body
	 */
	@GetMapping("/del/{asset_number}")
	@ResponseStatus(HttpStatus.OK)
	public String del(@PathVariable Long asset_number) {
		
		try {
			Asset delClient = assetService.findById(asset_number);
			if (delClient.getAssetNumber() == asset_number) {
				assetService.deleteAssetById(asset_number);
				return "Eliminado correctamente activo con id: "+ asset_number;
				
			}
		} catch (Exception e) {
			return "No econtrado";
		}
		return null;
	}
	
	/**
	 * Peticion GET para realizar consulta de u activo fijo a partir de un parametro recibido (serial)
	 * @param serial Recibe un parametro para realizar la consulta
	 * @return Devuelve un HttpStatus.OK y el activo fijo consultado en caso de ser afirmativo.
	 */
	@GetMapping("/serial")
	@ResponseStatus(HttpStatus.OK)
	public Asset getAssetSerial(@RequestParam String serial){
		Asset assetSerial = assetService.findAssetBySerial(serial);
		return assetSerial;
	}
	
	/**
	 * Peticion GET para realizar consulta de u activo fijo a partir de un parametro recibido (fecha de compra)
	 * @param purchase_date Recibe un parametro para realizar la consulta
	 * @return Devuelve un HttpStatus.OK y el activo fijo consultado en caso de ser afirmativo.
	 */
	@GetMapping("/date")
	@ResponseStatus(HttpStatus.OK)
	public List<Asset> getAssetDate(@RequestParam String purchase_date){
			return assetService.findAssetByDate(purchase_date);
	}
	
	/**
	 * Peticion GET para realizar consulta de u activo fijo a partir de un parametro recibido (tipo de activo)
	 * @param type Recibe un parametro para realizar la consulta
	 * @return Devuelve un HttpStatus.OK y el activo fijo consultado en caso de ser afirmativo.
	 */
	@GetMapping("/type")
	@ResponseStatus(HttpStatus.OK)
	public List<Asset> getAssetType(@RequestParam String type){
			return assetService.findByType(type);
	}
	
	
	
}
