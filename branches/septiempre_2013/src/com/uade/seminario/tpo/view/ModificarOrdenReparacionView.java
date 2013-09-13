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
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.TareaReparacion;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.PiezaView;
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
public class ModificarOrdenReparacionView extends javax.swing.JFrame {
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JCheckBox repararTodas;
	private JLabel jLabel4;
	private JLabel jLabel8;
	private JComboBox prioridad;
	private JTextField estado;
	private JLabel jLabel3;
	private JCheckBox garantiaPapel;
	private JButton buscarOrden;
	private JButton modificarOrden;
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
	private JButton avanzar;
	private JButton retroceder;
	private JCheckBox jCheckBox1;
	private JTextField nombreEquipo;
	private JTextField nroSerie;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ModificarOrdenReparacionView inst = new ModificarOrdenReparacionView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificarOrdenReparacionView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("Modificar Orden de Reparacion");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Numero serie equipo : ");
				jLabel1.setBounds(12, 79, 156, 16);
			}
			{
				nroSerie = new JTextField();
				getContentPane().add(nroSerie);
				nroSerie.setEditable(false);
				nroSerie.setBounds(174, 76, 201, 23);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre Cliente : ");
				jLabel2.setBounds(12, 108, 156, 16);
			}
			{
				nombreEquipo = new JTextField();
				getContentPane().add(nombreEquipo);
				nombreEquipo.setBounds(174, 105, 201, 23);
				nombreEquipo.setEditable(false);
			}
			{
				jCheckBox1 = new JCheckBox();
				getContentPane().add(jCheckBox1);
				jCheckBox1.setText("En Garantia Fisica");
				jCheckBox1.setEnabled(false);
				jCheckBox1.setBounds(12, 160, 151, 20);
			}
			{
				repararTodas = new JCheckBox();
				getContentPane().add(repararTodas);
				repararTodas.setText("Reparar de todas maneras");
				repararTodas.setEnabled(false);
				repararTodas.setBounds(174, 160, 182, 20);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Datos Equipo");
				jLabel4.setBounds(12, 51, 119, 16);
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
				jLabel6.setBounds(12, 201, 162, 16);
			}
			
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Numero Orden Reparacion : ");
				jLabel7.setBounds(12, 25, 168, 16);
			}
			{
				nroOrdenReparacion = new JTextField();
				getContentPane().add(nroOrdenReparacion);
				nroOrdenReparacion.setBounds(179, 22, 183, 23);
			}
			{
				agregar = new JButton();
				getContentPane().add(agregar);
				agregar.setText("Agregar Tarea");
				agregar.setBounds(266, 227, 128, 23);
				agregar.setEnabled(false);
				agregar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						AltaTareaReparacionView view = new AltaTareaReparacionView(nroOrdenReparacion.getText());
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
						TareaReparacionView tarea= ((TareaReparacionView) tareas.getSelectedValue());
						if(tarea!=null)
							SistemadeReparaciones.getInstancia().quitarTareaOrdenReparacion(Integer.parseInt(nroOrdenReparacion.getText()),tarea.getNroItemReparacion());
						actualizar.doClick();
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
						if(!nroOrdenReparacion.getText().equals("")){
							for(TareaReparacionView p: sist.buscarTareasXOrdenReparacionView(Integer.parseInt(nroOrdenReparacion.getText()))){
								reparacionesModelo.addElement(p);
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
				modificarOrden = new JButton();
				getContentPane().add(modificarOrden);
				modificarOrden.setText("Modificar Orden");
				modificarOrden.setBounds(375, 339, 135, 23);
				modificarOrden.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(!nroOrdenReparacion.getText().equals(""))
							SistemadeReparaciones.getInstancia().modificarOrdenReparacion(Integer.parseInt(nroOrdenReparacion.getText()),fallas.getText(),Integer.parseInt(prioridad.getSelectedItem().toString()));						
						
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
				buscarOrden = new JButton();
				getContentPane().add(buscarOrden);
				buscarOrden.setText("Buscar Orden");
				buscarOrden.setBounds(375, 22, 139, 23);
				buscarOrden.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!nroOrdenReparacion.getText().equals("")){
							OrdenReparacionView ordenview=SistemadeReparaciones.getInstancia().buscarOrdenReparacionView(Integer.parseInt(nroOrdenReparacion.getText()));
							Equipo equipo=ordenview.getEquipo();
							if(equipo!=null && ordenview!=null){
								nombreEquipo.setText(equipo.getCliente().getNombre());
								if(equipo.getGarantia().estasEnGarantia())
									garantiaPapel.setSelected(true);
								nroSerie.setText(String.valueOf(equipo.getNroSerie()));
								if(ordenview.isEstaEnGarantiaFisica())
									jCheckBox1.setSelected(true);
								if(ordenview.isRepararDeTodosModos())
									repararTodas.setSelected(true);
								fallas.setText(ordenview.getDescripcionFallas());
								estado.setText(ordenview.getEstado());
								prioridad.setSelectedIndex(ordenview.getPrioridad()-1);
								actualizar.doClick();
								retroceder.setVisible(true);
								avanzar.setVisible(true);	
								agregar.setEnabled(true);
								quitarTarea.setEnabled(true);
								actualizar.setEnabled(true);
								
							}
						}
						
					}
				});
			}
			{
				garantiaPapel = new JCheckBox();
				getContentPane().add(garantiaPapel);
				garantiaPapel.setText("Esta en garantia de fabrica");
				garantiaPapel.setBounds(12, 130, 190, 20);
				garantiaPapel.setEnabled(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Etapa del proceso : ");
				jLabel3.setBounds(417, 132, 127, 16);
			}
			{
				estado = new JTextField();
				getContentPane().add(estado);
				estado.setEditable(false);
				estado.setBounds(543, 129, 309, 23);
			}
			{
				ComboBoxModel prioridadModel = 
						new DefaultComboBoxModel(
								new String[] { "1","2","3","4","5","6","7","8","9","10" });
				prioridad = new JComboBox();
				getContentPane().add(prioridad);
				prioridad.setModel(prioridadModel);
				prioridad.setBounds(444, 159, 43, 23);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("Prioridad : ");
				jLabel8.setBounds(362, 162, 82, 16);
			}
			{
				retroceder = new JButton();
				getContentPane().add(retroceder);
				retroceder.setText("Retroceder Etapa");
				retroceder.setBounds(543, 178, 140, 23);
				retroceder.setVisible(false);
				retroceder.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(!nroOrdenReparacion.equals("")){
						String etapa=SistemadeReparaciones.getInstancia().retrocederEtapaOrden(Integer.parseInt(nroOrdenReparacion.getText()));
						if (!etapa.equals(""))
						estado.setText(etapa);}
						
					}
				});
			}
			{
				avanzar = new JButton();
				getContentPane().add(avanzar);
				avanzar.setText("Avanzar Etapa");
				avanzar.setBounds(718, 178, 134, 23);
				avanzar.setVisible(false);
				avanzar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(!nroOrdenReparacion.equals("")){
						String etapa=SistemadeReparaciones.getInstancia().avanzarEtapaOrden((Integer.parseInt(nroOrdenReparacion.getText())));
						if (!etapa.equals(""))
						estado.setText(etapa);}
					}
				});
			}

			pack();
			this.setSize(929, 412);
			this.setPreferredSize(new java.awt.Dimension(929, 412));
			this.setBounds(0, 0, 929, 412);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
