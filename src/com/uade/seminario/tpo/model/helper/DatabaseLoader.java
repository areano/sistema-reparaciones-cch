package com.uade.seminario.tpo.model.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.uade.seminario.tpo.model.*;
import com.uade.seminario.tpo.persistence.dao.generic.impl.*;

public class DatabaseLoader {

	private DatabaseLoader() {
	}

	public static void init() {
		DatabaseLoader loader = new DatabaseLoader();

		loader.cargarPiezas();
		loader.cargarModelos();
		loader.cargarEmpleados();
	}

	private void cargarEmpleados() {
		crearEmpleado(3000, "Jair", "Tabares", "1/1/1984", "Reparaciones", "29000000", "DNI");
		crearEmpleado(3001, "Martin", "Flory", "2/1/1984", "Reparaciones", "29100100", "DNI");
		crearEmpleado(3002, "Mauro", "Gri", "1/10/1992", "Reparaciones", "39000000", "DNI");
		crearEmpleado(3003, "Ariel", "Reano", "12/2/1982", "Reparaciones", "29300000", "DNI");
	}
	
	private void crearEmpleado(int legajo,String nombre, String apellido, String nacimiento, String sector, String documento, String tipoDocumento){
		Empleado empleado = new Empleado();
		
				
		empleado.setLegajo(legajo);
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setFechaNac(parseDate(nacimiento));
		empleado.setIdSector(sector);
		empleado.setNroDoc(documento);
		empleado.setTipoDoc(tipoDocumento);		
		
		EmpleadoDAOImpl.getInstancia().save(empleado);
		
	}
	
	private Date parseDate(String date){

		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			result = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	private void cargarModelos() {

		crearModelo("PRO K77C", "Con audio", 2000, new Pieza[] { 
				new Pieza(1000, "Pantalla 5\'"), 
				new Pieza(1003,""),
				new Pieza(1006, "")});

		crearModelo("PRO K70C", "Sin audio", 2001, new Pieza[] { 
				new Pieza(1000, "Pantalla 5\'"), 
				new Pieza(1008, "")});
	}
	
	private void crearModelo(String nombre, String descripcion, int codigo, Pieza[] piezas){
		Modelo modelo = new Modelo(nombre, descripcion, codigo);

		for (Pieza pieza : piezas) {
			modelo.addPieza(pieza);
		}

		ModeloDAOImpl.getInstancia().save(modelo);		
	}

	private void cargarPiezas() {
		crearPieza(1000, "Pantalla 5\'");
		crearPieza(1001, "Pantalla 3\'");
		crearPieza(1002, "Pantalla 3\' LED");
		crearPieza(1003, "Parlante int. 12V");
		crearPieza(1004, "Parlante int. 24V");
		crearPieza(1005, "Parlante ext. 24V");
		crearPieza(1006, "Fuente int. 12V2A");
		crearPieza(1007, "Fuente int. 12V5A");
		crearPieza(1008, "Fuente int. 12V10A");
		crearPieza(1009, "Fuente int. 12V20A");
		crearPieza(1010, "Fuente int. 12V30A");
		crearPieza(1011, "Fuente int. 24V5A");
		crearPieza(1012, "Fuente int. 24V10A");
		crearPieza(1013, "Fuente int. 8V10A");
	}

	private Pieza crearPieza(int codigo, String descripcion) {
		Pieza pieza = new Pieza(codigo, descripcion);
		PiezaDAOImpl.getInstancia().save(pieza);
		return pieza;
	}
}
