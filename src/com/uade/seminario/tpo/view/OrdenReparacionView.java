package view;

import java.sql.Date;
import java.util.Vector;

import negocio.Equipo;
import negocio.TareaReparacion;

public class OrdenReparacionView {
	private int nroOrden;
	private Vector<TareaReparacion> itemsReparacion;
	private Equipo equipo;
	private Date fecha;
	private String estado;
}
