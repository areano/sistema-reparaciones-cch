package com.uade.seminario.tpo.exceptions;

public class ModeloExisteException extends RuntimeException {
	private final int codigo;
	
	public int getCodigo(){
		return this.codigo;
	}
	public ModeloExisteException (int codigo){
		super("El modelo de codigo: " +codigo + " existe y no puede ser creado" );
		this.codigo=codigo;		
	}	

}
