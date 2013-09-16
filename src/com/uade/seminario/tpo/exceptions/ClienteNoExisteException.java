package com.uade.seminario.tpo.exceptions;

public class ClienteNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String nroDoc;
	public ClienteNoExisteException(String nroDoc, String tipoDoc){
		super("El Cliente con documento : "+tipoDoc+" "+nroDoc+" no existe");
		this.nroDoc=tipoDoc+" "+nroDoc;
		
	}
	public String getCodigo(){
		return this.nroDoc;
	}
}
