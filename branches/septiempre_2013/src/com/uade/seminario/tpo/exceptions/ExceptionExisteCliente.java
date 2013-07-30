package com.uade.seminario.tpo.exceptions;

public class ExceptionExisteCliente extends RuntimeException {
	private final int nroDoc;
	public ExceptionExisteCliente(int nroDoc){
		super("El cliente cuyo numero de documento es: "+nroDoc+" ya existe");
		this.nroDoc=nroDoc;
	}
	public int getCodigo(){
		return this.nroDoc;
	}
}
