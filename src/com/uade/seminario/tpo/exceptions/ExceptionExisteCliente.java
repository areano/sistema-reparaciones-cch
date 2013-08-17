package com.uade.seminario.tpo.exceptions;

public class ExceptionExisteCliente extends RuntimeException {
	private final String nroDoc;
	public ExceptionExisteCliente(String nroDoc){
		super("El cliente cuyo numero de documento es: "+nroDoc+" ya existe");
		this.nroDoc=nroDoc;
	}
	public String getCodigo(){
		return this.nroDoc;
	}
}
