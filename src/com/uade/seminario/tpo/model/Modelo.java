package com.uade.seminario.tpo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.uade.seminario.tpo.view.objectView.ModeloView;
import com.uade.seminario.tpo.view.objectView.PiezaView;

@Entity
@Table(name="modelo")
public class Modelo {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nro_modelo")
	private int nroModelo;
	@Column(name="nombre_mod", columnDefinition="varchar(50)")
	private String nombre;
	@ManyToMany
	@JoinTable(name="pieza_modelo", 
		joinColumns={@JoinColumn(name="nro_modelo", referencedColumnName="nro_modelo")}, 
		inverseJoinColumns={@JoinColumn(name="nro_pieza", referencedColumnName="nro_pieza")},
		uniqueConstraints=@UniqueConstraint(columnNames={"nro_pieza","nro_modelo"}))
	private List<Pieza> piezas;
	@Column(name="m_estado", columnDefinition="varchar(20)")
	private String estado;
	@Column(name="m_descripcion", columnDefinition="varchar(200)")
	private String descripcion;	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Modelo(){
		this.piezas=new ArrayList<Pieza>();
	}
	public Modelo(String nombre2, String descripcion, int codigo) {
		this.nombre=nombre2;
		this.descripcion=descripcion;
		this.nroModelo=codigo;
		this.piezas=new ArrayList<Pieza>();
		this.estado="inactivo";
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
	public List<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean modeloActivo() {
		return this.getEstado()=="activo";
	}
	public void darBajaModelo() {
		this.estado="inactivo";
		
	}
	public void addPieza(Pieza pieza) {
		this.piezas.add(pieza);
		
	}
	public void activar() {
		setEstado("activo");
		
	}
	public ModeloView getView() {
		ModeloView mod=new ModeloView(getNombre(),getDescripcion(), getNroModelo());
		List<PiezaView> piezasView = new ArrayList<PiezaView>();
		for (Pieza p : piezas) {
			piezasView.add(p.getView());
		}
		mod.setEstado(estado);
		mod.setPiezas(piezasView);
		return mod;
	}
	public void eliminar() { //Borra de la base de datos
		// TODO Auto-generated method stub
		
	}
	public void quitarPieza(Pieza pieza) {
		this.piezas.remove(pieza);
		
	}
}
