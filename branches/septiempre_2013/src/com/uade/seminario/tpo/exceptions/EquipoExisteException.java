package com.uade.seminario.tpo.exceptions;

public class EquipoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String nroSerieEquipo;
	public EquipoExisteException(String nroSerieEquipo){
		super("El equipo con numero de serie : "+nroSerieEquipo+" ya  existe");
		this.nroSerieEquipo=nroSerieEquipo;
	}
	public String getCodigo(){
		return this.nroSerieEquipo;
	}
}
