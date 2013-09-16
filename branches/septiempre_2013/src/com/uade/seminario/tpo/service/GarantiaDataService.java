package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.GarantiaDAOImpl;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.Garantia;
import java.util.List;
public class GarantiaDataService {
	private static GarantiaDAOImpl dao;
	private static GarantiaDataService cs=null;
	static {
		dao = GarantiaDAOImpl.getInstancia();
	}
	private GarantiaDataService(){
		
	}
	public static GarantiaDataService getInstance(){
		if (cs==null){
			cs =  new GarantiaDataService();
		}
		return cs;
	}
	public Garantia findByNroGarantia(int nroGarantia){
		return dao.findByNroGarantia(nroGarantia);
	}
	public List<Garantia> todosLosEquipo(){
		return dao.findAll();
	}
	public void save(Garantia entidad){
		dao.save(entidad);
	}
	public void update(Garantia entidad){
		dao.update(entidad);
	}
	
}
