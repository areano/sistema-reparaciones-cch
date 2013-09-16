package com.uade.seminario.tpo.exceptions;

public class EmpleadoNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String legajo;
	public EmpleadoNoExisteException(String legajo){
		super("El empleado cuyo numero de legajo  es: "+legajo+" no existe");
		this.legajo=legajo;
	}
	public String getCodigo(){
		return this.legajo;
	}
}
