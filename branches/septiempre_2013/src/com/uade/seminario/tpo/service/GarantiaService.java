package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.GarantiaDAOImpl;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.Garantia;
import java.util.List;
public class GarantiaService {
	private static GarantiaDAOImpl dao;
	private static GarantiaService cs=null;
	static {
		dao = GarantiaDAOImpl.getInstancia();
	}
	private GarantiaService(){
		
	}
	public static GarantiaService getInstance(){
		if (cs==null){
			cs =  new GarantiaService();
		}
		return cs;
	}
	public Garantia findByNroSerie(int nroSerie){
		return dao.findByNroSerie(nroSerie);
	}
	public List<Garantia> todosLosEquipo(){
		return dao.findAll();
	}
	
}
