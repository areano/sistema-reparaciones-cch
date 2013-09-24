package com.uade.seminario.tpo.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.persistence.*;

import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.TareaReparacionView;

@Entity
@Table(name="orden_reparacion")
public class OrdenReparacion implements Comparable<OrdenReparacion>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nro_orden_reparacion")
	private int nroOrden;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nro_orden_reparacion",referencedColumnName="nro_orden_reparacion")
	private List<TareaReparacion> itemsReparacion;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="nro_serie", referencedColumnName="nro_serie", nullable=false)
	private Equipo equipo;
	
	@Column(name="or_fecha", nullable=false)
	private Date fecha;
	
	@Column(name="or_estado", columnDefinition="varchar(20)", nullable=false)
	private String estado;
	
	@Column(name="or_descripcion_fallas", columnDefinition="varchar(2000)", nullable=false)
	private String descripcionFallas;
	
	@Column(name="or_en_garantia", nullable=false)
	private boolean estaEnGarantiaFisica;
	
	@Column(name="or_reparar_de_todos_modos", nullable=false)
	private boolean repararDeTodosModos;
	
	@Column(name="or_prioridad")
	private int prioridad;
	
	public OrdenReparacion(){
		
		String patron = "dd/MM/yyyy";
	    SimpleDateFormat formato = new SimpleDateFormat(patron);
	    formato.format(new java.util.Date());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        java.sql.Date sqlDate;
		try {
			date = sdf.parse(formato.format(new java.util.Date()));
			sqlDate = new Date(date.getTime());	
			this.fecha=sqlDate;//new Date());
		} catch (ParseException e) {
			e.printStackTrace();
		}	    
		this.itemsReparacion=new ArrayList<TareaReparacion>();
//		java.util.Date date;
//		java.sql.Date sqlDate;
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
//		try {
//			date = sdf.parse(timeStamp);
//			sqlDate = new Date(date.getTime());	
//			this.fecha=sqlDate;//new Date());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
	}
	
	public OrdenReparacion(int nroOrden2) {
		this.nroOrden=nroOrden2;
		this.itemsReparacion=new Vector<TareaReparacion>();
		this.equipo=null;
		this.fecha=null;
		this.estado=null;
	}
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public List<TareaReparacion> getItemsReparacion() {
		return itemsReparacion;
	}
	public void setItemsReparacion(List<TareaReparacion> itemsReparacion) {
		this.itemsReparacion = itemsReparacion;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean esTuEquipo(int nroSerieEquipo) {
		return this.equipo.getNroSerie()==nroSerieEquipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean estadoAReparar() {
		return estado.equals("A reparar");
	}
	public OrdenReparacionView getView() {
		List<TareaReparacionView> tareasView =  new ArrayList<TareaReparacionView>();
		for (TareaReparacion tarea : itemsReparacion) {
			tareasView.add(tarea.getView());
		}
		return new OrdenReparacionView(  nroOrden,descripcionFallas,equipo.getView(),
				getEstado(),getFecha(),tareasView,getPrioridad(),repararDeTodosModos,estaEnGarantiaFisica);
	}
	public Vector<TareaReparacionView> listarTareasView() {
		Vector<TareaReparacionView> tareas=new Vector<TareaReparacionView>();
		
		for (TareaReparacion tarea : itemsReparacion) {
			if(tarea.estaActiva())
			tareas.add(tarea.getView());
		}
		return tareas;
	}
	public List<TareaReparacion> listarTareas() {
		return this.itemsReparacion;
	}
	public List<String> listaPiezas() {
		List<TareaReparacion> tareas=listarTareas();
		Vector<String> nombrePiezas= new Vector<String>();
		for (TareaReparacion tareaReparacion : tareas) {
			//List<String> nombrePiezasTarea=tareaReparacion.listaPiezas();
			List<String> nombrePiezasTarea =  new ArrayList<String>();
			for(ItemReparacion item:tareaReparacion.getItemsReparacion()){
				nombrePiezas.add(item.getPieza().getDescripcion());
			}
			
//			for (String nombre : nombrePiezasTarea) {
//				nombrePiezas.add(nombre);
//			}
		}
		return nombrePiezas;
	}
	public void agregarItemReparacion(TareaReparacion tarea) {
		this.itemsReparacion.add(tarea);
		
	}
	public TareaReparacion obtenerTarea(int nroTarea) {
		for (TareaReparacion tarea : itemsReparacion) {
			if(tarea.getNroItemReparacion()==nroTarea)
				return tarea;
		}
		return null;
	}
	public void setDescripcionFallas(String fallas) {
		this.descripcionFallas=fallas;
		
	}
	public String getDescripcionFallas() {
		return this.descripcionFallas;
		
	}
	public boolean isEstaEnGarantiaFisica() {
		return estaEnGarantiaFisica;
	}
	public void setEstaEnGarantiaFisica(boolean estaEnGarantiaFisica) {
		this.estaEnGarantiaFisica = estaEnGarantiaFisica;
	}
	public boolean isRepararDeTodosModos() {
		return repararDeTodosModos;
	}
	public void setRepararDeTodosModos(boolean repararDeTodosModos) {
		this.repararDeTodosModos = repararDeTodosModos;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public TareaReparacionView obtenerTareaView(int nroTarea) {
		for (TareaReparacion tarea : itemsReparacion) {
			if(tarea.getNroItemReparacion()==nroTarea)
				return tarea.getView();
		}
		return null;
	}
	public boolean estadoAConfirmar() {
		
		return this.estado.equals("A Confirmar");
	}

	
	public int compareTo(OrdenReparacion o) {
		
		return (new Integer(prioridad)).compareTo(o.getNroOrden());
	}
 
}
