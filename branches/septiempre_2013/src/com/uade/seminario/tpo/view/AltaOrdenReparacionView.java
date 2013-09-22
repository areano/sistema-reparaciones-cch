package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.WindowConstants;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.view.objectView.EquipoView;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.TareaReparacionView;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AltaOrdenReparacionView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JButton buscarEquipo;
	private JLabel jLabel2;
	private JCheckBox repararTodas;
	private JLabel jLabel4;
	private JComboBox prioridad;
	private JLabel jLabel3;
	private JCheckBox garantiaPapel;
	private JButton crearOrden;
	private JButton confirmar;
	private JList tareas;
	private JScrollPane jScrollPane1;
	private JButton actualizar;
	private JButton quitarTarea;
	private JButton agregar;
	private JTextField nroOrdenReparacion;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JTextArea fallas;
	private JLabel jLabel5;
	private JCheckBox jCheckBox1;
	private JTextField nombreEquipo;
	private JTextField nroSerie;
	private OrdenReparacionView orden;
	private SistemadeReparaciones sistema;
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaOrdenReparacionView inst = new AltaOrdenReparacionView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaOrdenReparacionView() {
		super();
		sistema = SistemadeReparaciones.getInstancia();
		orden =  new OrdenReparacionView();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("Alta Orden de Reparacion");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Numero serie equipo : ");
				jLabel1.setBounds(12, 28, 156, 16);
			}
			{
				nroSerie = new JTextField();
				getContentPane().add(nroSerie);
				nroSerie.setBounds(174, 25, 201, 23);
			}
			{
				buscarEquipo = new JButton();
				getContentPane().add(buscarEquipo);
				buscarEquipo.setText("Buscar Equipo");
				buscarEquipo.setBounds(387, 25, 123, 23);
				buscarEquipo.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!nroSerie.getText().equals("")){
							//Equipo equipo=SistemadeReparaciones.getInstancia().buscarEquipo(Integer.parseInt(nroSerie.getText()));
							EquipoView equipo = sistema.buscarEquipoView(Integer.parseInt(nroSerie.getText()));
							if(equipo!=null ){
								nombreEquipo.setText(equipo.getCliente().getNombre());
								if(equipo.getGarantia().isEstasEnGarantia())
									garantiaPapel.setSelected(true);
								
							}
							else {
								MensajeErrorFrame mensaje = new MensajeErrorFrame("Equipo con numero de serie"+nroSerie.getText()+" no existe");
								mensaje.setVisible(true);
							}
						}
						
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre Cliente : ");
				jLabel2.setBounds(12, 56, 156, 16);
			}
			{
				nombreEquipo = new JTextField();
				getContentPane().add(nombreEquipo);
				nombreEquipo.setBounds(174, 53, 201, 23);
			}
			{
				jCheckBox1 = new JCheckBox();
				getContentPane().add(jCheckBox1);
				jCheckBox1.setText("En Garantia Fisica");
				jCheckBox1.setBounds(12, 150, 156, 20);
			}
			{
				repararTodas = new JCheckBox();
				getContentPane().add(repararTodas);
				repararTodas.setText("Reparar de todas maneras");
				repararTodas.setBounds(174, 150, 182, 20);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Datos Equipo");
				jLabel4.setBounds(12, 6, 119, 16);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Fallas Encontradas : ");
				jLabel5.setBounds(543, 6, 185, 16);
			}
			{
				fallas = new JTextArea();
				getContentPane().add(fallas);
				fallas.setBounds(543, 26, 309, 78);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Reparaciones a realizar : ");
				jLabel6.setBounds(12, 176, 162, 16);
			}
			
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Numero Orden Reparacion : ");
				jLabel7.setBounds(12, 198, 168, 16);
			}
			{
				nroOrdenReparacion = new JTextField();
				getContentPane().add(nroOrdenReparacion);
				nroOrdenReparacion.setBounds(192, 195, 183, 23);
				nroOrdenReparacion.setEditable(false);
			}
			{
				agregar = new JButton();
				getContentPane().add(agregar);
				agregar.setText("Agregar Tarea");
				agregar.setBounds(266, 227, 128, 23);
				agregar.setEnabled(false);
				agregar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						AltaTareaReparacionView view = new AltaTareaReparacionView(orden);
						view.setVisible(true);
						
					}
				});
			}
			{
				quitarTarea = new JButton();
				getContentPane().add(quitarTarea);
				quitarTarea.setText("Quitar Tarea");
				quitarTarea.setBounds(266, 262, 128, 23);
				quitarTarea.setEnabled(false);
				quitarTarea.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!tareas.isSelectionEmpty()){
							int nroTarea=((TareaReparacionView) tareas.getSelectedValue()).getNroItemReparacion();
							SistemadeReparaciones.getInstancia().quitarTareaOrdenReparacion(Integer.parseInt(nroOrdenReparacion.getText()),nroTarea);
						}
						
					}
				});
			}
			{
				actualizar = new JButton();
				getContentPane().add(actualizar);
				actualizar.setText("Actualizar");
				actualizar.setBounds(266, 297, 128, 23);
				actualizar.setEnabled(false);
				actualizar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						actualizarLista();						
					}

					private void actualizarLista() {
						SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
						
						DefaultListModel reparacionesModelo=new DefaultListModel();
						
						if(orden.getItemsReparacion().size()>0){
							for(TareaReparacionView p: orden.getItemsReparacion()){
								reparacionesModelo.addElement(p.getDetalle());
							}
						}
						tareas = new JList();
						jScrollPane1.setViewportView(tareas);
						tareas.setModel(reparacionesModelo);
						tareas.setVisible(true);
						
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setVisible(true);
				jScrollPane1.setBounds(12, 226, 242, 97);
			}
			{
				confirmar = new JButton();
				getContentPane().add(confirmar);
				confirmar.setText("Confirmar");
				confirmar.setBounds(394, 339, 116, 23);
				confirmar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						boolean estaEnGarantiaFisica=false;
						boolean repararDeTodosModos=false;
						if(jCheckBox1.isSelected())
							estaEnGarantiaFisica=true;
						if(repararTodas.isSelected())
							repararDeTodosModos=true;
						int prioridad1=Integer.parseInt(prioridad.getSelectedItem().toString()); 
						orden.setRepararDeTodosModos(repararDeTodosModos);
						orden.setEstaEnGarantiaFisica(estaEnGarantiaFisica);
						orden.setPrioridad(prioridad1);
						SistemadeReparaciones.getInstancia().confirmarOrdenReparacion(orden);

					}
				});
			}
			{			
				SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
				
				DefaultListModel reparacionesModelo=new DefaultListModel();
				if(!nroOrdenReparacion.getText().equals("")){
					for(TareaReparacionView p: sist.buscarTareasXOrdenReparacionView(Integer.parseInt(nroOrdenReparacion.getText()))){
						reparacionesModelo.addElement(p);
					}
				}				
				tareas = new JList();
				getContentPane().add(tareas);
				tareas.setModel(reparacionesModelo);
				tareas.setVisible(true);
				tareas.setBounds(15, 229, 239, 94);

			}
			{
				crearOrden = new JButton();
				getContentPane().add(crearOrden);
				crearOrden.setText("Crear Orden");
				crearOrden.setBounds(163, 115, 139, 23);
				crearOrden.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if (!fallas.getText().isEmpty()){
							if(!nroSerie.getText().equals("")){
								EquipoView equipo = sistema.buscarEquipoView(Integer.parseInt(nroSerie.getText()));
								OrdenReparacionView ordenView= SistemadeReparaciones.getInstancia().
										buscarOrdenConEquipoARepararView(equipo);
								
								if(equipo!=null && ordenView==null){
									orden.setEquipo(equipo);
									orden.setEstado("A Confirmar");
									orden.setDescripcionFallas(fallas.getText());
									agregar.setEnabled(true);
									quitarTarea.setEnabled(true);
									actualizar.setEnabled(true);
									fallas.setEnabled(false);
								}else{
									if(equipo==null){
										MensajeErrorFrame mensaje = new MensajeErrorFrame("Equipo con numero de serie "+nroSerie.getText()+" no existe");
										mensaje.setVisible(true);
									}
									else{
										MensajeErrorFrame mensaje = new MensajeErrorFrame("Equipo con numero de serie "+nroSerie.getText()+" ya se encuentra en una orden");
										mensaje.setVisible(true);
									}
									
								}
								
							}
						}else{
							MensajeErrorFrame mensaje  = new MensajeErrorFrame("Ingrese la descripcion de las fallas");
							mensaje.setVisible(true);
						}
						
					}
				});
			}
			{
				garantiaPapel = new JCheckBox();
				getContentPane().add(garantiaPapel);
				garantiaPapel.setText("Esta en garantia de fabrica");
				garantiaPapel.setBounds(12, 89, 190, 20);
				garantiaPapel.setEnabled(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Prioridad : ");
				jLabel3.setBounds(243, 91, 72, 16);
			}
			{
				ComboBoxModel prioridadModel = 
						new DefaultComboBoxModel(
								new String[] { "1","2","3","4","5","6","7","8","9","10" });
				prioridad = new JComboBox();
				getContentPane().add(prioridad);
				prioridad.setModel(prioridadModel);
				prioridad.setBounds(327, 88, 41, 23);
			}

			pack();
			this.setSize(929, 419);
			this.setPreferredSize(new java.awt.Dimension(929, 419));
			this.setBounds(0, 0, 929, 419);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
