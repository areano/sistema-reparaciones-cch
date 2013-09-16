package com.uade.seminario.tpo.exceptions;

public class PiezaNoExisteException extends RuntimeException {
	private final int codigo;
	
	public int getCodigo(){
		return this.codigo;
	}
	public PiezaNoExisteException (int codigo){
		super("La  pieza de codigo: " +codigo + " no existe y debe ser creado" );
		this.codigo=codigo;		
	}	

}
