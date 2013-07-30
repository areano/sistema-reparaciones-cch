package com.uade.seminario.tpo.exceptions;

public class ExceptionModeloPerteneceEquipo extends RuntimeException{
	private final int codigo;
	
	public int getCodigo(){
		return this.codigo;
	}
	public ExceptionModeloPerteneceEquipo (int codigo){
		super("El modelo de codigo: " +codigo + "que quiere eliminar tiene adjunto un Equipo");
		this.codigo=codigo;		
	}	
}
