package com.serinz.activos.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serinz.activos.app.entitys.Employe;
import com.serinz.activos.app.services.employes.IEmployeService;

/**
 * Controlador para el Modelo de Empleados
 * @author ing_j
 *
 */
@RestController
@RequestMapping("api/employe")
@CrossOrigin(origins="*")
public class EmployeController {
	
	@Autowired
	private IEmployeService service;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Employe>>  getEmploye(){
		List<Employe> listEmploye = service.getEmploye(); 
		return ResponseEntity.ok(listEmploye); 
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addEmploye(@Valid @RequestBody Employe employe){
		service.AddEmploye(employe);
		return ResponseEntity.status(HttpStatus.CREATED).body("Empleado creado correctamente");
	}
}
