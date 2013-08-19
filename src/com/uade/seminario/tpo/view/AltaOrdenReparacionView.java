package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.model.OrdenReparacion;
import com.uade.seminario.tpo.view.objectView.EquipoView;
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
public class AltaOrdenReparacionView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JButton buscarEquipo;
	private JLabel jLabel2;
	private JCheckBox repararTodas;
	private JLabel jLabel4;
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
	private JTextField accesorios;
	private JLabel jLabel3;
	private JTextField nombreEquipo;
	private JTextField nroSerie;
	

	/**
	* Auto-generated main method to display this JFrame
	*/
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
		initGUI();
	}
	
	private void initGUI() {
		try {
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
							EquipoView equipov=SistemadeReparaciones.getInstancia().buscarEquipoView(Integer.parseInt(nroSerie.getText()));
							OrdenReparacionView ordenView= SistemadeReparaciones.getInstancia().buscarOrdenConEquipoARepararView(Integer.parseInt(nroSerie.getText()));
							if(ordenView==null){
								int nroOrden=SistemadeReparaciones.getInstancia().altaOrdenReparacion(Integer.parseInt(nroSerie.getText()));
								nroOrdenReparacion.setText(ordenView.toString());
							}
						}
						
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre Equipo : ");
				jLabel2.setBounds(12, 56, 156, 16);
			}
			{
				nombreEquipo = new JTextField();
				getContentPane().add(nombreEquipo);
				nombreEquipo.setBounds(174, 53, 201, 23);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Accesorios : ");
				jLabel3.setBounds(12, 84, 156, 16);
			}
			{
				accesorios = new JTextField();
				getContentPane().add(accesorios);
				accesorios.setBounds(174, 81, 201, 23);
			}
			{
				jCheckBox1 = new JCheckBox();
				getContentPane().add(jCheckBox1);
				jCheckBox1.setText("En Garantia");
				jCheckBox1.setBounds(12, 112, 113, 20);
			}
			{
				repararTodas = new JCheckBox();
				getContentPane().add(repararTodas);
				repararTodas.setText("Reparar de todas maneras");
				repararTodas.setBounds(174, 112, 182, 20);
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
				jLabel6.setBounds(12, 144, 162, 16);
			}
			
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Numero Orden Reparacion : ");
				jLabel7.setBounds(12, 172, 168, 16);
			}
			{
				nroOrdenReparacion = new JTextField();
				getContentPane().add(nroOrdenReparacion);
				nroOrdenReparacion.setBounds(192, 169, 183, 23);
				nroOrdenReparacion.setEditable(false);
			}
			{
				agregar = new JButton();
				getContentPane().add(agregar);
				agregar.setText("Agregar Tarea");
				agregar.setBounds(266, 204, 128, 23);
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
				quitarTarea.setBounds(266, 239, 128, 23);
			}
			{
				actualizar = new JButton();
				getContentPane().add(actualizar);
				actualizar.setText("Actualizar");
				actualizar.setBounds(266, 274, 128, 23);
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
				jScrollPane1.setBounds(12, 200, 242, 97);
				{			
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
			}
					
				
			
			pack();
			this.setSize(929, 363);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
