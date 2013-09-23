package com.uade.seminario.tpo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
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
public class MostrarTareaReparacionView extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton salir;
	private JButton actualizar;
	private JTextField nroTarea;
	private JTextArea detalle;
	private JTextField nroOrden;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JList<String> piezas;

	private class ActualizarListaListener implements  ActionListener {
		private TareaReparacionView tarea;
		
		public ActualizarListaListener(TareaReparacionView tarea){
			this.tarea = tarea;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(!nroOrden.getText().equals("") && !nroTarea.getText().equals("")){

			detalle.setText(tarea.getDetalle());
			
			actualizarLista();	
			}					
		}
		private void actualizarLista() {
		
			DefaultListModel<String> piezasModelo=new DefaultListModel<String>();
			if(!nroOrden.getText().equals("") && !nroTarea.getText().equals("")){
				for(PiezaView p: tarea.getPiezas()){
					piezasModelo.addElement(p.getDescripcion());
				}
			}				
			piezas = new JList<String>();
			jScrollPane1.setViewportView(piezas);
			piezas.setModel(piezasModelo);
			piezas.setBounds(12, 160, 225, 119);
			
		}
	}
	
	public MostrarTareaReparacionView(OrdenReparacionView orden, TareaReparacionView tarea) {
		super();
		initGUI(orden,tarea);
		actualizar.doClick();		

	}
	
	private void initGUI(OrdenReparacionView orden,  TareaReparacionView tarea) {
		try {
			setTitle("Mostrar Tarea de Reparacion");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			this.setSize(431, 405);
			this.setPreferredSize(new java.awt.Dimension(431, 405));
			this.setBounds(0, 0, 431, 405);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Numero de Orden: ");
				jLabel1.setBounds(12, 12, 128, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Detalle : ");
				jLabel2.setBounds(12, 45, 128, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Lista de piezas : ");
				jLabel3.setBounds(12, 169, 128, 16);
			}
			{
				nroOrden = new JTextField();
				getContentPane().add(nroOrden);
				nroOrden.setBounds(146, 9, 240, 23);
				nroOrden.setText(String.valueOf(orden.getNroOrden()));
				nroOrden.setEditable(false);
			}
			{
				detalle = new JTextArea();
				getContentPane().add(detalle);
				detalle.setBounds(146, 43, 240, 64);
				detalle.setEditable(false);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Numero Tarea : ");
				jLabel4.setBounds(12, 132, 132, 16);
			}
			{
				nroTarea = new JTextField();
				nroTarea.setEditable(false);
				getContentPane().add(nroTarea);
				nroTarea.setBounds(144, 129, 141, 23);
				nroTarea.setText(String.valueOf(tarea.getNroItemReparacion()));
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 197, 225, 119);
				{
					DefaultListModel<String> piezasModelo=new DefaultListModel<String> ();
					if(!nroOrden.getText().equals("") && !nroTarea.getText().equals("")){
						for(PiezaView p: tarea.getPiezas()){
							piezasModelo.addElement(p.getDescripcion());
						}
					}				
					piezas = new JList<String> ();
					jScrollPane1.setViewportView(piezas);
					piezas.setModel(piezasModelo);
					piezas.setBounds(12, 160, 225, 119);
				}
			}
			
			{
				actualizar = new JButton();
				getContentPane().add(actualizar);
				actualizar.setText("Actualizar Tabla");
				actualizar.setBounds(254, 281, 132, 23);
				actualizar.setVisible(false);
				actualizar.addActionListener(new ActualizarListaListener(tarea));
			}
			{
				salir = new JButton();
				getContentPane().add(salir);
				salir.setText("Salir");
				salir.setBounds(157, 332, 97, 23);
				salir.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
