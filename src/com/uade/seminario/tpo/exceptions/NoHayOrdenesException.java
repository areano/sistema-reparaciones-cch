package com.uade.seminario.tpo.exceptions;

public class NoHayOrdenesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String mensaje;
	public NoHayOrdenesException(String mensaje){
		super(mensaje);
		this.mensaje=mensaje;
		
	}
	public String getMensaje(){
		return this.mensaje;
	}
}
