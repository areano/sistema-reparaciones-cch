package com.uade.seminario.tpo.service;

import java.sql.Date;
import java.util.List;

import com.uade.seminario.tpo.model.ItemReporte;
import com.uade.seminario.tpo.model.Reporte;
import com.uade.seminario.tpo.persistence.dao.generic.impl.ReporteDAOImpl;

public class ReporteDataService {
	private static ReporteDAOImpl dao;
	private static ReporteDataService cs=null;
	static {
		dao = ReporteDAOImpl.getInstancia();
	}

	private ReporteDataService(){
		
	}
	public static ReporteDataService getInstance(){
		if (cs==null){
			cs =  new ReporteDataService();
		}
		return cs;
	}
	
	public Reporte findByDate(Date FechaDesde, Date FechaHasta) {
		return dao.findByDate(FechaDesde, FechaHasta);
	}
	
}
