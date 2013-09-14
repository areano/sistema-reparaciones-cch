package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.ModeloDAOImpl;
import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.model.Modelo;
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
}