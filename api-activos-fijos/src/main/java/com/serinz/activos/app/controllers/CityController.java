package com.serinz.activos.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serinz.activos.app.dao.CityDAO;
import com.serinz.activos.app.entitys.City;
import com.serinz.activos.app.services.cities.ICityService;

/**
 * Etapa de controlador para las peticiones Htpp para el Modelo City
 * @author ing_j
 *
 */
@RestController
@RequestMapping("/api/city")
@CrossOrigin(origins = "*")
public class CityController {
	
	@Autowired
	private ICityService service;
	
	@Autowired
	private CityDAO cityDAO;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<City>> getCities() {
		return ResponseEntity.ok(service.getCities());
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addCity(@Valid @RequestBody City city) {
		service.addCity(city);
		return ResponseEntity.status(HttpStatus.CREATED).body("Ciudad creada correctamente");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<City> updateCity(@PathVariable Integer id, @Valid @RequestBody City city) {
		Optional<City> cityOptional = cityDAO.findById(id) ;
		
		if(!cityOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		city.setId(cityOptional.get().getId());
		service.updateCity(city);
		
		return ResponseEntity.noContent().build();
		
	}
	
}
