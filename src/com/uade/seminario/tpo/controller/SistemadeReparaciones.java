package com.uade.seminario.tpo.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uade.seminario.tpo.exceptions.ClienteNoExisteException;
import com.uade.seminario.tpo.exceptions.EmpleadoNoExisteException;
import com.uade.seminario.tpo.exceptions.EquipoExisteException;
import com.uade.seminario.tpo.exceptions.EquipoNoExisteException;
import com.uade.seminario.tpo.exceptions.ExceptionExisteCliente;
import com.uade.seminario.tpo.exceptions.ExceptionModeloInactivo;
import com.uade.seminario.tpo.exceptions.ExceptionModeloPerteneceEquipo;
import com.uade.seminario.tpo.exceptions.ExceptionNoExisteModelo;
import com.uade.seminario.tpo.exceptions.GarantiaExisteException;
import com.uade.seminario.tpo.exceptions.GarantiaNoExisteException;
import com.uade.seminario.tpo.exceptions.ModeloExisteException;
import com.uade.seminario.tpo.exceptions.OrdenNoDisponibleException;
import com.uade.seminario.tpo.exceptions.OrdenNoExisteException;
import com.uade.seminario.tpo.exceptions.PiezaNoExisteException;
import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.model.Empleado;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.model.Modelo;
import com.uade.seminario.tpo.model.OrdenReparacion;
import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.model.Remito;
import com.uade.seminario.tpo.model.TareaReparacion;
import com.uade.seminario.tpo.view.objectView.ClienteView;
import com.uade.seminario.tpo.view.objectView.EquipoView;
import com.uade.seminario.tpo.view.objectView.GarantiaView;
import com.uade.seminario.tpo.view.objectView.ModeloView;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.PiezaView;
import com.uade.seminario.tpo.view.objectView.ReporteView;
import com.uade.seminario.tpo.view.objectView.TareaReparacionView;





public class SistemadeReparaciones {
	private static SistemadeReparaciones instancia;
	private List<Remito> remitos;
	private List<Garantia> garantias;
	private List<Modelo> modelos;
	private List<Pieza> piezas;
	private List<OrdenReparacion> ordReparacion;
	private List<Equipo> equipos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Empleado> empleados;
	private List<ReporteView> reportes;
	
	private SistemadeReparaciones(){

	}
	
	public static SistemadeReparaciones getInstancia(){
		if(instancia==null)
			instancia=new SistemadeReparaciones();
		return instancia;
	}
	
	public void altaModelo(ModeloView modeloView)throws ModeloExisteException{  
		try{
			buscarModelo(modeloView.getNroModelo());
			throw new ModeloExisteException(modeloView.getNroModelo());
		}catch (ExceptionNoExisteModelo e){
			AdministradorModelo.getInstancia().altaModelo(modeloView);
		}
	}
	public boolean verificarExistenciaModelo(ModeloView modeloView){
		try{
			buscarModelo(modeloView.getNroModelo());
			return true;
		}catch (ExceptionNoExisteModelo e){
			//AdministradorModelo.getInstancia().altaModelo(modeloView);
			return false;
		}
	}
	public void modificarModelo(ModeloView modelo){	
		AdministradorModelo.getInstancia().modificarModelo(modelo);	
	}
	
	public void bajaModelo(int codigo) throws ExceptionModeloInactivo{
		Modelo modelo =  AdministradorModelo.getInstancia().buscarModelo(codigo);
		
		if(modelo!=null && modelo.modeloActivo()){
			if(!AdministradorEquipo.getInstancia().existeElModeloEnUnEquipo(modelo)) modelo.darBajaModelo();
			else throw new ExceptionModeloPerteneceEquipo(codigo);
		}
		else{
			if(modelo==null) throw new ExceptionNoExisteModelo(codigo);
			else throw new ExceptionModeloInactivo(codigo);			
		}
		
	}
	
	public void eliminarModelo(int codigo) {
		Modelo modelo=this.buscarModelo(codigo);
		if(modelo!=null){
			modelo.eliminar();
			modelos.remove(modelo);
		}
		
	}

	private OrdenReparacion buscarEquipoxOrdenRepAConfirmar(int nroSerieEquipo) {
		Equipo equipo = AdministradorEquipo.getInstancia().buscarEquipo(nroSerieEquipo);
		return AdministradorOrdenReparacion.getInstancia().buscarEquipoxOrdenRepAConfirmar(equipo);
	}

	public void modificarOrdenReparacion(OrdenReparacionView orden){
			AdministradorOrdenReparacion.getInstancia().modificarOrdenReparacion(orden);		
	}
	

	

	private OrdenReparacion BuscarEquipoxOrdenRep(int nroSerieEquipo) {
		for (OrdenReparacion or : ordReparacion) {
			if(or.esTuEquipo(nroSerieEquipo) && or.estadoAReparar()){
				return or;
			}
		}
		return null;
	}



	public OrdenReparacionView misReparaciones(int legajo) throws EmpleadoNoExisteException,OrdenNoDisponibleException {
		Empleado empleado=AdministradorEmpleado.getInstancia().buscarEmpleado(legajo);
		if(empleado!=null){
			return AdministradorOrdenReparacion.getInstancia().asignarSiguienteOrdenReparacion(empleado);
		}
		else throw new EmpleadoNoExisteException(String.valueOf(legajo));		
	}
	public OrdenReparacionView asignarOrdenDeTrabajo(int legajo) throws EmpleadoNoExisteException {
		Empleado empleado=AdministradorEmpleado.getInstancia().buscarEmpleado(legajo);
		if(empleado!=null){
			return AdministradorOrdenReparacion.getInstancia().asignarSiguienteOrdenReparacion(empleado);
		}
		else throw new EmpleadoNoExisteException(String.valueOf(legajo));		
	}
	
//	private OrdenReparacion buscarOrdenReparacionPrioridad() { 
//		return AdministradorOrdenReparacion.getInstancia().buscarOrdenReparacionPrioridad();
//	}

	public List<TareaReparacionView> listarTareasReparacion(int nroReparacion){
		return AdministradorOrdenReparacion.getInstancia().listarTareas(nroReparacion);
		
	}
	
	public ReporteView emitirReportePiezas(Date desde,Date hasta){
		ReporteView rv = AdministradorReporte.getInstancia().generarReportePiezas(desde,hasta);
		AdministradorReporte.getInstancia().GenerarDynamicReporte(rv, desde, hasta);
		return  rv; 
		
	}

//	public Reporte emitirReportePiezas(Date desde,Date hasta){
//		List<OrdenReparacionView> ordenes=buscarOrdenesReporte(desde,hasta);
//		return AdministradorReporte.getInstancia().generarReportePiezas(desde,hasta,ordenes);
//	}
//
//	public List<OrdenReparacionView> buscarOrdenesReporte(Date desde, Date hasta) {
//		return AdministradorOrdenReparacion.getInstancia().ordenesPorFecha(desde, hasta);
//	}

	
	public void altaCliente(ClienteView clienteView){
		try{
			Cliente cliente =  buscarCliente(clienteView.getNroDoc(), clienteView.getTipoDoc());
			throw new ExceptionExisteCliente(clienteView.getNroDoc());
		}catch (ClienteNoExisteException e){
			AdministradorCliente.getInstancia().AltaCliente(clienteView);
			
		}
	}
	
	protected Cliente buscarCliente(String nroDoc, String tipoDoc) throws ClienteNoExisteException{
		Cliente cliente = AdministradorCliente.getInstancia().buscarCliente(nroDoc, tipoDoc); 
		if (cliente != null) return cliente;
		throw new ClienteNoExisteException(nroDoc, tipoDoc);
	}
	private Empleado buscarEmpleado(int legajo) throws EmpleadoNoExisteException{
		Empleado empleado = AdministradorEmpleado.getInstancia().buscarEmpleado(legajo);
		if (empleado != null) return empleado;
		throw new EmpleadoNoExisteException(String.valueOf(legajo));
	}
	private Equipo buscarEquipo(int nroSerieEquipo) throws EquipoNoExisteException {
		Equipo	equipo = AdministradorEquipo.getInstancia().buscarEquipo(nroSerieEquipo);
		if (equipo!=null) return equipo;
		throw new EquipoNoExisteException(String.valueOf(nroSerieEquipo));
	}
	protected  Modelo buscarModelo(int codigo) throws ExceptionNoExisteModelo {
		Modelo modelo =  AdministradorModelo.getInstancia().buscarModelo(codigo);
		if (modelo!=null) return modelo;
		throw new ExceptionNoExisteModelo(codigo);		

	}
	private Pieza buscarPieza(int codPieza) {
		Pieza pieza = AdministradorPieza.getInstancia().buscarPieza(codPieza);
		if (pieza!=null) return pieza;
		throw new PiezaNoExisteException(codPieza);	
		
	}

	protected Garantia buscarGarantia(int nroGarantia) throws GarantiaNoExisteException{
		Garantia garantia = AdministradorGarantia.getInstancia().buscarGarantia(nroGarantia);
		if (garantia!=null) return garantia;
		throw new GarantiaNoExisteException(nroGarantia);
	}
	public GarantiaView buscarGarantiaView(int nroGarantia) throws GarantiaNoExisteException{
		return buscarGarantia(nroGarantia).getView();
	}
	private  OrdenReparacion buscarOrdenReparacion(int nroReparacion) {
		OrdenReparacion ordenReparacion = AdministradorOrdenReparacion.getInstancia().
				buscarOrdenReparacion(nroReparacion);
		if (ordenReparacion!=null) return ordenReparacion;
		throw new OrdenNoExisteException(nroReparacion);
	}
	public ClienteView obtenerClienteView(String nroDoc,String tipoDoc) {
		return buscarCliente(nroDoc, tipoDoc).getView();
	}

	public void modificarCliente(String nroDoc, String tipoDoc,String nombre1, String dir, String tel,
			String mail) {
		Cliente cliente=buscarCliente(nroDoc,tipoDoc);
		cliente.setNombre(nombre1);
		cliente.setDireccion(dir);
		cliente.setTelefono(tel);
		cliente.setEmail(mail);		
	}
	public void modificarCliente(ClienteView cliente){
		AdministradorCliente.getInstancia().modificarCliente(cliente);
	}
	public void altaPieza(String nombre, int codPieza, int codModelo, String descripcion) {
		Modelo modelo=buscarModelo(codModelo);
		Pieza pieza=buscarPieza(codPieza);
		if(modelo!=null && pieza==null){
			pieza=new Pieza(codPieza,descripcion);
			modelo.addPieza(pieza);
			piezas.add(pieza);
		}
		
	}
	public void altaPieza(PiezaView pieza){
		AdministradorPieza.getInstancia().altaPieza(pieza);
	}


	public PiezaView buscarPiezaView(int codigoPieza) throws PiezaNoExisteException{

		Pieza pieza = buscarPieza(codigoPieza); 
		return pieza.getView();
	}

	public void modificarPieza(PiezaView pieza) {
		AdministradorPieza.getInstancia().modificarPieza(pieza);
		
	}

	public void bajaPieza(int codigoPieza) {
		 if (!hayModelosConPieza(codigoPieza))
			 AdministradorPieza.getInstancia().bajaPieza(codigoPieza);
	}

	private boolean hayModelosConPieza(int codigoPieza) {
		Pieza pieza=AdministradorPieza.getInstancia().buscarPieza(codigoPieza);
		return AdministradorModelo.getInstancia().hayModelosConPieza(pieza);
	}

	public ModeloView buscarModeloView(int codModelo) throws ExceptionNoExisteModelo {
		ModeloView modeloView =  AdministradorModelo.getInstancia().buscarModeloView(codModelo);
		if (modeloView != null )	return modeloView;
		else throw new ExceptionNoExisteModelo(codModelo);
	}

	public List<PiezaView> buscarPiezaXModeloView(int codModelo) {
		ModeloView modelo = AdministradorModelo.getInstancia().buscarModeloView(codModelo);
		if (modelo != null)
			return modelo.getPiezas();
		return null;
	}

	public void confirmarModelo(ModeloView modeloView) {
		try{
			Modelo modelo= buscarModelo(modeloView.getNroModelo());
		}catch(ExceptionNoExisteModelo e){
			modeloView.setEstado("activo");
			AdministradorModelo.getInstancia().altaModelo(modeloView);
		}
	}
	public void altaEquipo(EquipoView equipoView)throws ExceptionNoExisteModelo, 
	EquipoExisteException, ClienteNoExisteException, GarantiaNoExisteException {
			try{
				buscarEquipo(equipoView.getNroSerie());
			}catch(EquipoNoExisteException e){
				AdministradorEquipo.getInstancia().altaEquipo(equipoView);
			}
	}


	public void altaGarantia(GarantiaView garantiaView) throws GarantiaExisteException {
		try{
			Garantia garantia = buscarGarantia(Integer.parseInt(garantiaView.getNroGarantia()));
			throw new GarantiaExisteException("Garantia ["+garantiaView.getNroGarantia()+"] ya existe");
		}catch (GarantiaNoExisteException e){
			AdministradorGarantia.getInstancia().altaGarantia(garantiaView);
		}
	}

	public void quitarPiezaModelo(int codigoModelo, int nroPieza) {
		Modelo modelo=buscarModelo(codigoModelo);
		Pieza pieza=buscarPieza(nroPieza);
		if(modelo!=null && pieza!=null){
			modelo.quitarPieza(pieza);
		}
		
	}

	public void agregarPiezaModelo(PiezaView piezaV, int codigoModelo) {
		Modelo modelo=buscarModelo(codigoModelo);
		Pieza pieza=buscarPieza(piezaV.getNroPieza());
		if(modelo!=null && pieza!=null){
			modelo.addPieza(pieza);
		}
		
	}

	public EquipoView buscarEquipoView(int nroSerie) {
		Equipo equipo=buscarEquipo(nroSerie);
		if(equipo!=null && equipo.estaActivo()){
			EquipoView equipoV=equipo.getView();
			return equipoV;
		}
		else
			return null;
	}

	public OrdenReparacionView buscarOrdenConEquipoARepararView(EquipoView equipoView) {
		Equipo equipo=AdministradorEquipo.getInstancia().buscarEquipo(equipoView.getNroSerie());
		return AdministradorOrdenReparacion.getInstancia().buscarOrdenConEquipoARepararView(equipo);
	}

	public int obtenerNroOrdenReparacion() {
		
		return (ordReparacion.size()+1);
	}

	public List<TareaReparacionView> buscarTareasXOrdenReparacionView(int nroOrdenReparacion) {
		List<TareaReparacionView> tareasview=new ArrayList<TareaReparacionView>();
		 OrdenReparacion orden=buscarOrdenReparacion(nroOrdenReparacion);
		 if(orden!=null){
			 List<TareaReparacion> tareas=orden.getItemsReparacion();
			 for (TareaReparacion t : tareas) {
				 if(t.estaActiva())
					 tareasview.add(t.getView());				
			}
		 }
		 return tareasview;
	}

	public OrdenReparacionView buscarOrdenReparacionView(int nroOrden) {
		OrdenReparacion orden=buscarOrdenReparacion(nroOrden);
		if(orden!=null){
			return orden.getView();			
		}
		return null;
	}

	public int crearTareaReparacion(String descripcion, int numeroOrden) {
		OrdenReparacion orden=buscarOrdenReparacion(numeroOrden);
		if(orden!=null && !orden.getEstado().equals("Reparado")){
			int numeroTarea=obtenerNumeroTarea(orden);
			TareaReparacion tarea=new TareaReparacion(numeroTarea, descripcion);
			orden.agregarItemReparacion(tarea);
			return numeroTarea;
		}
		return 0;
		
	}

	private int obtenerNumeroTarea(OrdenReparacion orden) {
		return orden.getItemsReparacion().size()+1;
	}

	public List<PiezaView> buscarPiezasXTareaView(int nroOrden, int nroTarea) {
		List<PiezaView> piezas=new ArrayList<PiezaView>();
		OrdenReparacion orden=buscarOrdenReparacion(nroOrden);
		if(orden!=null){
			TareaReparacion tarea=orden.obtenerTarea(nroTarea);
			if(tarea!=null){
//				for (Pieza pieza : tarea.getPiezas()) {
//					if(pieza.estaActiva())
//					piezas.add(pieza.getView());
//				}
			}
		}
		return piezas;
	}

	public void agregarPiezaTarea(int nroOrden, int nroTarea, int nroPieza) {
		OrdenReparacion orden=buscarOrdenReparacion(nroOrden);
		Pieza pieza=buscarPieza(nroPieza);
		if(orden!=null){
			TareaReparacion tarea= orden.obtenerTarea(nroTarea);
			if(tarea!=null){
				//tarea.agregarPieza(pieza);
			}
		}
		
		
	}

	public void quitarPiezaTarea(int nroOrden, int nroTarea, int nroPieza) {
		OrdenReparacion orden=buscarOrdenReparacion(nroOrden);
		Pieza pieza=buscarPieza(nroPieza);
		if(orden!=null){
			TareaReparacion tarea= orden.obtenerTarea(nroTarea);
			if(tarea!=null){
				pieza.setEstado("inactivo");
			}
		}
		
	}

	public void quitarTareaOrdenReparacion(int nroOrden, int nroTarea) {
		OrdenReparacion orden=buscarOrdenReparacion(nroOrden);
		if(orden!=null){
			TareaReparacion tarea=orden.obtenerTarea(nroTarea);
			if(tarea!=null && tarea.estaActiva()){
				tarea.setEstado("inactivo");
			}
		}
		
	}
	public void confirmarOrdenReparacion(OrdenReparacionView orden ){
		AdministradorOrdenReparacion.getInstancia().confirmarOrdenReparacion(orden);
	}


	
}