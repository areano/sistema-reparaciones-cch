package com.uade.seminario.tpo.service;

import java.util.List;

import com.uade.seminario.tpo.persistence.dao.generic.impl.TareaReparacionDAOImpl;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.TareaReparacion;

public class TareaReparacionDataService {
	private static TareaReparacionDAOImpl dao;
	private static TareaReparacionDataService cs=null;
	static {
		dao = TareaReparacionDAOImpl.getInstancia();
	}
	private TareaReparacionDataService(){
		
	}
	public static TareaReparacionDataService getInstance(){
		if (cs==null){
			cs =  new TareaReparacionDataService();
		}
		return cs;
	}
	public void save(TareaReparacion entity){
		dao.save(entity);
	}
	public TareaReparacion findByNroSerie(int nroItemReparacion){
		return dao.findByNroSerie(nroItemReparacion);
	}
	public List<TareaReparacion> todosLasTareas(){
		return dao.findAll();
	}
	public void update(TareaReparacion entidad){
		dao.update(entidad);
	}
}
