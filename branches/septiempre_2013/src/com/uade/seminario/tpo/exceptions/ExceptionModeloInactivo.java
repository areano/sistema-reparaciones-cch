package com.uade.seminario.tpo.exceptions;

public class ExceptionModeloInactivo extends Exception {
	private final int codigo;
	
	public int getCodigo(){
		return this.codigo;
	}
	public ExceptionModeloInactivo (int codigo){
		super("El modelo de codigo: " +codigo + "no se encuentra activo");
		this.codigo=codigo;		
	}	

}
