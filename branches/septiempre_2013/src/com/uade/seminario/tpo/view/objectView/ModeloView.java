package com.uade.seminario.tpo.view.objectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.uade.seminario.tpo.model.Pieza;

public class ModeloView {
	private int nroModelo;
	private String nombre;
	private List<PiezaView> piezas;
	private String estado;
	private String descripcion;
	
	
	public ModeloView(String nombre2, String descripcion, int codigo) {
		this.nombre=nombre2;
		this.descripcion=descripcion;
		this.nroModelo=codigo;
		this.piezas=new ArrayList<PiezaView>();
		this.estado="activo";
	}


	public int getNroModelo() {
		return nroModelo;
	}


	public void setNroModelo(int nroModelo) {
		this.nroModelo = nroModelo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<PiezaView> getPiezas() {
		return piezas;
	}


	public void setPiezas(List<PiezaView> piezas) {
		this.piezas = piezas;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void eliminarPieza(PiezaView piezaView){
		for (PiezaView pieza : piezas) {
			if (pieza.getNroPieza() == piezaView.getNroPieza()){
				piezas.remove(pieza);
				return ;
			}			
		}
	}
	
}
