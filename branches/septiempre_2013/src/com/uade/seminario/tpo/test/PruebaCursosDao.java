package com.uade.seminario.tpo.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.model.Modelo;
import com.uade.seminario.tpo.model.OrdenReparacion;
import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.model.TareaReparacion;
import com.uade.seminario.tpo.persistence.dao.generic.impl.OrdenDeReparacionDAOImpl;
import com.uade.seminario.tpo.persistence.dao.generic.impl.ReporteDAOImpl;
import com.uade.seminario.tpo.service.ClienteDataService;
import com.uade.seminario.tpo.service.EquipoService;
import com.uade.seminario.tpo.service.GarantiaDataService;
import com.uade.seminario.tpo.service.ModeloDataService;
import com.uade.seminario.tpo.service.OrdenDeReparacionDataService;
import com.uade.seminario.tpo.service.PiezaDataService;
import com.uade.seminario.tpo.service.TareaReparacionDataService;

public class PruebaCursosDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReporteDAOImpl.getInstancia().test();
		
	}
	public void test(){

	}

}
