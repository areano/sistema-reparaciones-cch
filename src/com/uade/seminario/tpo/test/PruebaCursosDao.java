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
		Cliente c = new Cliente();
		c.setApellido("Tabares");
		c.setNombre("Jair");
		c.setTipoDoc("dni");
		c.setNroDoc("29392405");
		c.setFechaNac("24/01/1982");

		
		Pieza pieza= new Pieza();
//		pieza.setNombrePieza("tornillo");
		pieza.setNroPieza(0);
		pieza.setDescripcion("es un tornillo");
		pieza.setEstado("activo");
		

		Pieza pieza2= new Pieza();
//		pieza2.setNombrePieza("tuerca");
		pieza.setNroPieza(1);
		pieza2.setDescripcion("es una turca");		
		pieza2.setEstado("activo");
		
		
		
		Modelo modelo= new Modelo();
		modelo.setDescripcion("sistema operativo");
		modelo.setNombre("XP");
		modelo.setEstado("activo");
		modelo.addPieza(pieza);
		modelo.addPieza(pieza2);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        java.util.Date date;
        java.sql.Date sqlDate;
        Garantia garantia = null;
        Garantia garantia2 = null;
		try {
			date = sdf.parse("10/10/1800");
			sqlDate = new Date(date.getTime());	
			
			garantia=new Garantia();
			garantia.setFechaVencimiento(sqlDate);
			garantia.setNroGarantia(1);
			
			garantia2 = new Garantia();
			garantia2.setFechaVencimiento(sqlDate);
			garantia2.setNroGarantia(2);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
			

		Equipo equipo=new Equipo(1, modelo, c, garantia);		
		Equipo equipo2=new Equipo(2, modelo, c, garantia2);
		equipo.setEstado("activo");
		equipo2.setEstado("activo");
		
		
		TareaReparacion tarea=new TareaReparacion( );
		TareaReparacion tarea1=new TareaReparacion();
		TareaReparacion tarea3=new TareaReparacion();
		
		tarea.setDetalle("Le falta un tornillo");		
		tarea.agregarPieza(pieza);
		tarea.setEstado("activo");
		
		tarea1.setDetalle( "Le faltan dos tornillos");
		tarea1.agregarPieza(pieza);
		tarea1.setEstado("activo");
		tarea3.setDetalle( "Le faltan dos tuercas");
		tarea3.agregarPieza(pieza2);
		tarea3.setEstado("activo");
		
		OrdenReparacion or = new OrdenReparacion();
		or.setEquipo(equipo2);
		or.setDescripcionFallas("falla blabla");		
		or.setEquipo(equipo);
		or.setEstado("A reparar");
		or.setEstaEnGarantiaFisica(true);
		or.setPrioridad(10);
		or.setRepararDeTodosModos(true);
		or.agregarItemReparacion(tarea);
		or.agregarItemReparacion(tarea1);
		
		ClienteDataService.getInstance().save(c);
		PiezaDataService.getInstance().save(pieza);
		PiezaDataService.getInstance().save(pieza2);
		ModeloDataService.getInstance().save(modelo);
		//GarantiaDataService.getInstance().save(garantia);
		EquipoService.getInstance().save(equipo);	
		EquipoService.getInstance().save(equipo2);
		//TareaReparacionDataService.getInstance().save(tarea);
		//TareaReparacionDataService.getInstance().save(tarea1);
		OrdenDeReparacionDataService.getInstance().save(or);
		
		or.agregarItemReparacion(tarea3);
		OrdenDeReparacionDataService.getInstance().update(or);
		
	}
	public void test(){

	}

}
