package com.serinz.activos.app.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.serinz.activos.app.configs.exceptions.BadRequestException;
import com.serinz.activos.app.configs.exceptions.InternalServerError;
import com.serinz.activos.app.configs.exceptions.NotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> batRequestException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<?> internalServerError(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	
}
