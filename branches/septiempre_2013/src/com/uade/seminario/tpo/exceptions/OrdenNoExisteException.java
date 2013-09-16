package com.uade.seminario.tpo.exceptions;

public class OrdenNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String nroDoc;
	public OrdenNoExisteException(int nroOrden){
		super("La Garantia  : "+nroOrden+" no existe");
		this.nroDoc=String.valueOf(nroOrden);
		
	}
	public String getCodigo(){
		return this.nroDoc;
	}
}
