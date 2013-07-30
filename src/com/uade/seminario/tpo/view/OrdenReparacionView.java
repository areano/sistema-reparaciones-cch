package com.uade.seminario.tpo.view;

import java.sql.Date;
import java.util.Vector;

import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.TareaReparacion;

public class OrdenReparacionView {
	private int nroOrden;
	private Vector<TareaReparacion> itemsReparacion;
	private Equipo equipo;
	private Date fecha;
	private String estado;
}
