package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.ModeloDAOImpl;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.model.Modelo;
import com.uade.seminario.tpo.model.Pieza;

import java.util.List;
public class ModeloDataService {
	private static ModeloDAOImpl dao;
	private static ModeloDataService cs=null;
	static {
		dao = ModeloDAOImpl.getInstancia();
	}
	private ModeloDataService(){
		
	}
	public static ModeloDataService getInstance(){
		if (cs==null){
			cs =  new ModeloDataService();
		}
		return cs;
	}
	public Modelo findByNroSerie(int nroSerie){
		return dao.findByNroSerie(nroSerie);
	}
	public List<Modelo> todosLosModelos(){
		return dao.findAll();
	}
	public void save(Modelo entidad){
		dao.save(entidad);
	}
	public void update(Modelo entidad){
		dao.update(entidad);
	}
	public List<Modelo> hayModelosConPieza(Pieza pieza){
		return dao.hayModelosConPieza(pieza);
	}
	public void merge(Modelo entidad) {
		dao.merge(entidad);
		
	}
}
