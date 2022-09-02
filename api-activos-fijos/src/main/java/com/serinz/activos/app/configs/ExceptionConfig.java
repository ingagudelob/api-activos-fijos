package com.serinz.activos.app.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.serinz.activos.app.configs.exceptions.BadRequestException;
import com.serinz.activos.app.configs.exceptions.InternalServerError;
import com.serinz.activos.app.configs.exceptions.NotFoundException;


/**
 * Clase de configuración para las excepciones
 * @author ing_j
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
	
	/**
	 * Metodo que captura las excelciones de tipo NOT_FOUN
	 * @param e del tipo Exception
	 * @return Devuelve el HttpStatus y el mensaje en el Body de acuerdo al status.
	 */
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	/**
	 * Metodo que captura las excelciones de tipo BAD_REQUEST
	 * @param e del tipo Exception
	 * @return Devuelve el HttpStatus y el mensaje en el Body de acuerdo al status.
	 */
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> batRequestException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	/**
	 * Metodo que captura las excelciones de tipo INTERNAL_SERVER_ERROR
	 * @param e del tipo Exception
	 * @return Devuelve el HttpStatus y el mensaje en el Body de acuerdo al status.
	 */
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<?> internalServerError(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	
}
