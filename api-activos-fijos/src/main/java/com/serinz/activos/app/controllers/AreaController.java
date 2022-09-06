package com.serinz.activos.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serinz.activos.app.entitys.Area;
import com.serinz.activos.app.services.areas.IAreaService;

@RestController
@RequestMapping("/api/area")
@CrossOrigin(origins = "*")
public class AreaController {
	
	@Autowired
	private IAreaService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Area>> getAreas() {
		List<Area> listArea = service.getAreas();
		return ResponseEntity.ok(listArea);
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addArea(@Valid @RequestBody Area request) {
		service.addArea(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Área creada correctamente");
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateArea(@RequestBody Area request) {
		
		Area areaEditar = service.findAreaById(request.getCodArea());
		areaEditar.setNameArea(request.getNameArea());
		
		return ResponseEntity.status(HttpStatus.OK).body("Area " + request.getNameArea() + " ha sido actualizada");
	}
	
}
