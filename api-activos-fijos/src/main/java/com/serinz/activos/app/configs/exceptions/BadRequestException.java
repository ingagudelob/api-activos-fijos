package com.serinz.activos.app.configs.exceptions;


/**
 * Clase  de contrucción para la configuración para las excepciones del tipo BAD_REQUEST_EXCEPTION
 * @author ing_j
 *
 */
public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		super();

	}

	public BadRequestException(String message) {
		super(message);

	}
	
}
