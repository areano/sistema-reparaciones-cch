package com.uade.seminario.tpo.exceptions;

public class GarantiaExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String mensaje;
	public GarantiaExisteException(String mensaje){
		super(mensaje);
		this.mensaje=String.valueOf(mensaje);
		
	}
	public String getMensaje(){
		return this.mensaje;
	}
}
