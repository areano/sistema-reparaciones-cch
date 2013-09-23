package com.uade.seminario.tpo.exceptions;

public class OrdenNoDisponibleException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OrdenNoDisponibleException(){
		super("No hay Ordenes Disponibles A Reparar");
		
	}
}
