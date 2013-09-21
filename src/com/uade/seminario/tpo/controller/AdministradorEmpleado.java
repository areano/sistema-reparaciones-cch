package com.uade.seminario.tpo.controller;

import com.uade.seminario.tpo.model.Empleado;
import com.uade.seminario.tpo.service.EmpleadoDataService;
import com.uade.seminario.tpo.view.objectView.EmpleadoView;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;

public class AdministradorEmpleado {
	private static AdministradorEmpleado instancia;
	private EmpleadoDataService empleadoDataService; 
	private AdministradorEmpleado(){
		empleadoDataService = EmpleadoDataService.getInstance();
	}
	protected static AdministradorEmpleado getInstancia(){
		if(instancia==null)
			instancia=new AdministradorEmpleado();
		return instancia;
	}
	protected void AltaEmpleado(EmpleadoView empleadoView){
		Empleado empleado = fromDTOtoClassTransformer(empleadoView);
		empleadoDataService.save(empleado);
	}
	protected Empleado buscarEmpleado(int legajo) {
		EmpleadoDataService empleadoDataService = EmpleadoDataService.getInstance();
		return empleadoDataService.findByLegajo(legajo);
	}
	protected EmpleadoView obtenerEmpleadoView(int legajo) {
		Empleado empleado=buscarEmpleado(legajo);
		if(empleado!=null)
			return empleado.getView();
		else
			return null;
	}
	protected void modificarEmpleado(EmpleadoView empleadoView) {
		Empleado empleado = fromDTOtoClassTransformer(empleadoView);
		empleadoDataService.merge(empleado);
	}
	private Empleado fromDTOtoClassTransformer(EmpleadoView ev){
		Empleado e = new Empleado();
		e.setApellido(ev.getApellido());
		e.setFechaNac(ev.getFechaNac()); //COMO ES ESTO DE LA FECHA DE NACIMIENTO? EL VIEW ME DA STRING Y EL MODEL ME PIDE DATE
		e.setIdSector(ev.getIdSector());
		e.setLegajo(ev.getLegajo());
		e.setNombre(ev.getNombre());
		e.setNroDoc(ev.getNroDoc());
		e.setTipoDoc(ev.getTipoDoc());
		for (OrdenReparacionView ov : ev.getaReparar()) {
			e.addAReparar(AdministradorOrdenReparacion.getInstancia().fromDTOtoClassTransformer(ov));
		}
		return e ;
		
	}
}
