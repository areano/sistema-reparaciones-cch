package com.uade.seminario.tpo.view.objectView;

import java.util.ArrayList;
import java.util.List;

import com.uade.seminario.tpo.model.Pieza;

public class TareaReparacionView {
	private int nroItemReparacion;
	private String detalle;
	//private List<PiezaView> piezas;
	private List<ItemReparacionView> itemReparacion;
	private String estado;
	
//	public TareaReparacionView(int nroItem,String descripcion, List<PiezaView> piezas2, String estado2) {
//		this.nroItemReparacion=nroItem;
//		this.piezas=piezas2;
//		this.detalle=descripcion;
//		this.estado=estado2;
//		
//	}
	public TareaReparacionView() {
		//piezas = new ArrayList<PiezaView>();
		itemReparacion = new ArrayList<ItemReparacionView>();
	}
	public TareaReparacionView(int nroItem, String descripcion,
			List<ItemReparacionView> itemsReparacionView, String estado2) {
		this.nroItemReparacion=nroItem;
		//this.piezas=piezas2;
		this.detalle=descripcion;
		this.estado=estado2;
		this.itemReparacion = itemsReparacionView;
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
	
//	public List<PiezaView> getPiezas() {
//		return piezas;
//	}
//	public void setPiezas(List<PiezaView> piezas) {
//		this.piezas = piezas;
//	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
//	public void addPieza(PiezaView pieza){
//		piezas.add(pieza);
//	}
	public void addItem (ItemReparacionView item){
		itemReparacion.add(item);
	}
//	public List<String> listaPiezas() {
//		List<String> nombrePiezas=new ArrayList<String>();
//		for (PiezaView pieza : piezas) {
//			nombrePiezas.add(String.valueOf(pieza.getNroPieza()));
//		}
//		return nombrePiezas;
//	}
	
	public List<ItemReparacionView> getItemReparacion() {
		return itemReparacion;
	}
	public void setItemReparacion(List<ItemReparacionView> itemReparacion) {
		this.itemReparacion = itemReparacion;
	}

	

}
