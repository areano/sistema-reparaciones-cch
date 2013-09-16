package com.uade.seminario.tpo.controller;

import com.uade.seminario.tpo.model.Empleado;
import com.uade.seminario.tpo.service.EmpleadoDataService;
import com.uade.seminario.tpo.view.objectView.EmpleadoView;

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
	private Empleado fromDTOtoClassTransformer(EmpleadoView empleadoView){
		Empleado empleado = new Empleado();
		return empleado ;
		
	}
}
