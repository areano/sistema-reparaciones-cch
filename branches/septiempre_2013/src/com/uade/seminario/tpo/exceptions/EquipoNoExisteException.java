package com.uade.seminario.tpo.exceptions;

public class EquipoNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String nroSerieEquipo;
	public EquipoNoExisteException(String nroSerieEquipo){
		super("El equipo con numero de serie : "+nroSerieEquipo+" no existe");
		this.nroSerieEquipo=nroSerieEquipo;
	}
	public String getCodigo(){
		return this.nroSerieEquipo;
	}
}
