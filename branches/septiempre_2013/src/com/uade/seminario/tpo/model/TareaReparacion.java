package com.uade.seminario.tpo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.uade.seminario.tpo.view.objectView.ItemReparacionView;
import com.uade.seminario.tpo.view.objectView.PiezaView;
import com.uade.seminario.tpo.view.objectView.TareaReparacionView;

@Entity
@Table(name="tarea_reparacion")
public class TareaReparacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nro_tarea_reparacion")
	private int nroItemReparacion;
	@Column(name="nt_detalle", columnDefinition="varchar(200)")
	private String detalle;
//	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinTable(name="tarea_reparacion_pieza",
//		joinColumns={@JoinColumn(name="nro_tarea_reparacion")},
//		inverseJoinColumns={@JoinColumn(name="nro_pieza")},
//		uniqueConstraints=@UniqueConstraint(columnNames={"nro_tarea_reparacion","nro_pieza"}))
//	private List<Pieza> piezas;
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nro_tarea_reparacion", referencedColumnName="nro_tarea_reparacion")
	private List<ItemReparacion> itemsReparacion;
	@Column(name="nt_estado", columnDefinition="varchar(20)")
	private String estado;
	
	public TareaReparacion(int nroItem,String descripcion) {
		this.nroItemReparacion=nroItem;
//		this.piezas=new ArrayList<Pieza>();
		this.itemsReparacion =new ArrayList<ItemReparacion>();
		this.detalle=descripcion;
		estado="inactivo";
	}
	public TareaReparacion(){
		//this.piezas= new ArrayList<Pieza>();
		this.itemsReparacion =new ArrayList<ItemReparacion>();
	}
	public int getNroItemReparacion() {
		return nroItemReparacion;
	}
	public void setNroItemReparacion(int nroItemReparacion) {
		this.nroItemReparacion = nroItemReparacion;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
//	public List<Pieza> getPiezas() {
//		return piezas;
//	}
//	public void setPiezas(List<Pieza> piezas) {
//		this.piezas = piezas;
//	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean estaActiva() {
		return estado.equals("activo");
	}
	public TareaReparacionView getView() {
//		List<PiezaView> pView =  new ArrayList<PiezaView>();
//		for(Pieza p: piezas){
//			pView.add(p.getView());
//		}
//		
		 List<ItemReparacionView> itemsReparacionView = new ArrayList<ItemReparacionView>();
		 for(ItemReparacion item: itemsReparacion){
			 itemsReparacionView.add(item.getView());
		 }
		 
		//TareaReparacionView tareaView=new TareaReparacionView(nroItemReparacion,detalle,pView,estado);
		TareaReparacionView tareaView=new TareaReparacionView(nroItemReparacion,detalle,itemsReparacionView,estado);
		return tareaView;
	}
//	public List<String> listaPiezas() {
//		List<String> nombrePiezas=new ArrayList<String>();
//		for (Pieza pieza : piezas) {
//			nombrePiezas.add(String.valueOf(pieza.getNroPieza()));
//		}
//		return nombrePiezas;
//	}
//	public void agregarPieza(Pieza pieza) {
//		this.piezas.add(pieza);
//		
//	}
//	public void quitarPieza(Pieza pieza) {
//		this.piezas.remove(pieza);
//		
//	}
	public List<ItemReparacion> getItemsReparacion() {
		return itemsReparacion;
	}
	public void setItemsReparacion(List<ItemReparacion> itemsReparacion) {
		this.itemsReparacion = itemsReparacion;
	}
	public void agregarItemReparacion(ItemReparacion item){
		itemsReparacion.add(item);
	}
	public void quitarItemReparacion(ItemReparacion item){
		itemsReparacion.remove(item);
	}
}
