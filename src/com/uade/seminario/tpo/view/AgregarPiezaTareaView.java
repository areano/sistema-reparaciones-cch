package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.model.OrdenReparacion;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.PiezaView;


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
public class AgregarPiezaTareaView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton agregar;
	private JLabel jLabel3;
	private JTextField nroTarea;
	private JTextField nroOrden;
	private JScrollPane jScrollPane1;
	private JList piezas;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AgregarPiezaTareaView inst = new AgregarPiezaTareaView("", "");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AgregarPiezaTareaView(String numeroTarea, String numeroOrden) {
		super();
		initGUI();
		nroOrden.setText(numeroOrden);
		nroTarea.setText(numeroTarea);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
			getContentPane().add(jLabel1);
				jLabel1.setText("Numero Orden : ");
				jLabel1.setBounds(12, 12, 89, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Numero Tarea: ");
				jLabel2.setBounds(12, 46, 82, 16);
			}
			{
				nroOrden = new JTextField();
				getContentPane().add(nroOrden);
				nroOrden.setBounds(132, 9, 198, 23);
			}
			{
				nroTarea = new JTextField();
				getContentPane().add(nroTarea);
				nroTarea.setBounds(132, 43, 198, 23);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Lista de Piezas del Modelo : ");
				jLabel3.setBounds(12, 81, 147, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 109, 225, 119);
				{
					
					SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
					
					DefaultListModel piezasModelo=new DefaultListModel();
					OrdenReparacionView ordenv= SistemadeReparaciones.getInstancia().buscarOrdenReparacionView(Integer.parseInt(nroOrden.getText()));
					int nroModelo=ordenv.getEquipo().getModelo().getNroModelo();
					if(!nroOrden.getText().equals("") && !nroTarea.getText().equals("")){
						for(PiezaView p: sist.buscarPiezaXModeloView(nroModelo)){
							piezasModelo.addElement(p);
						}
					}				
					piezas = new JList();
					jScrollPane1.setViewportView(piezas);
					piezas.setModel(piezasModelo);
					piezas.setBounds(12, 160, 225, 119);
					piezas.setVisible(false);
					
					
				}
			}
			{
				agregar = new JButton();
				getContentPane().add(agregar);
				agregar.setText("Agregar Pieza");
				agregar.setBounds(138, 247, 86, 23);
				agregar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						String nroPieza=(String) piezas.getSelectedValue().toString();
						SistemadeReparaciones.getInstancia().agregarPiezaTarea(Integer.parseInt(nroOrden.getText()),Integer.parseInt(nroTarea.getText()),Integer.parseInt(nroPieza));
						
					}
				});
			}
			pack();
			this.setSize(400, 320);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
