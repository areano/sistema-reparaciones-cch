package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.RemitoDAOImpl;
import com.uade.seminario.tpo.model.Remito;
import java.util.List;
public class RemitoDataService {
	private static RemitoDAOImpl dao;
	private static RemitoDataService cs=null;
	static {
		dao = RemitoDAOImpl.getInstancia();
	}
	private RemitoDataService(){
		
	}
	public static RemitoDataService getInstance(){
		if (cs==null){
			cs =  new RemitoDataService();
		}
		return cs;
	}
	public Remito findByNroRemito(int nroRemito) {
		return dao.findByNroRemito(nroRemito);
	}
	public List<Remito> todosLosRemitos(){
		return dao.findAll();
	}
}
