package com.uade.seminario.tpo.exceptions;

public class GarantiaNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String nroDoc;
	public GarantiaNoExisteException(int nroGarantia){
		super("La Garantia  : "+nroGarantia+" no existe");
		this.nroDoc=String.valueOf(nroGarantia);
		
	}
	public String getCodigo(){
		return this.nroDoc;
	}
}
