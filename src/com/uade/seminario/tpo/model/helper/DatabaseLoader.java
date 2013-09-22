package com.uade.seminario.tpo.model.helper;

import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.persistence.dao.generic.impl.PiezaDAOImpl;

public class DatabaseLoader {

	private DatabaseLoader(){
	}
	
	public static void init(){
		DatabaseLoader loader = new DatabaseLoader();
		
		loader.cargarPiezas();
		loader.cargarModelos();
		loader.cargarEmpleados();
	}

	private void cargarEmpleados() {
		// TODO Auto-generated method stub
		
	}

	private void cargarModelos() {
		// TODO Auto-generated method stub
		
	}

	private void cargarPiezas() {
		crearPieza(1000,"Pantalla 5\'");
		crearPieza(1001,"Pantalla 3\'");
		crearPieza(1002,"Pantalla 3\' LED");
		crearPieza(1003,"Parlante int. 12V");
		crearPieza(1004,"Parlante int. 24V");
		crearPieza(1005,"Parlante ext. 24V");
		crearPieza(1006,"Fuente int. 12V2A");
		crearPieza(1007,"Fuente int. 12V5A");
		crearPieza(1008,"Fuente int. 12V10A");
		crearPieza(1009,"Fuente int. 12V20A");
		crearPieza(1010,"Fuente int. 12V30A");
		crearPieza(1011,"Fuente int. 24V5A");
		crearPieza(1012,"Fuente int. 24V10A");
		crearPieza(1013,"Fuente int. 8V10A");
	}

	private void crearPieza(int codigo, String descripcion) {
		Pieza pieza = new Pieza(codigo, descripcion);
		PiezaDAOImpl.getInstancia().save(pieza);
	}
}
