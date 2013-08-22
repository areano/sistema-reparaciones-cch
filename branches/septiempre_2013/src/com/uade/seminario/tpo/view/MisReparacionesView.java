package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.model.OrdenReparacion;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;


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
public class MisReparacionesView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField legajo;
	private JLabel jLabel2;
	private JButton mostrarOrden;
	private JTextField nroOrden;
	private JButton obtenerReparacion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MisReparacionesView inst = new MisReparacionesView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MisReparacionesView() {
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
				jLabel1.setText("Legajo : ");
				jLabel1.setBounds(12, 29, 70, 16);
			}
			{
				legajo = new JTextField();
				getContentPane().add(legajo);
				legajo.setBounds(129, 26, 210, 23);
			}
			{
				obtenerReparacion = new JButton();
				getContentPane().add(obtenerReparacion);
				obtenerReparacion.setText("Obtener Reparacion");
				obtenerReparacion.setBounds(129, 106, 149, 23);
				obtenerReparacion.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!legajo.getText().equals("")){
							OrdenReparacionView orden=SistemadeReparaciones.getInstancia().misReparaciones(legajo.getText());
							nroOrden.setText(String.valueOf(orden.getNroOrden()));
							mostrarOrden.setVisible(true);
						}
						
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Numero de Orden : ");
				jLabel2.setBounds(12, 64, 105, 16);
			}
			{
				nroOrden = new JTextField();
				getContentPane().add(nroOrden);
				nroOrden.setBounds(129, 61, 210, 23);
				nroOrden.setEditable(false);
			}
			{
				mostrarOrden = new JButton();
				getContentPane().add(mostrarOrden);
				mostrarOrden.setText("Mostrar Orden");
				mostrarOrden.setBounds(360, 61, 91, 23);
				mostrarOrden.setVisible(false);
				mostrarOrden.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						MostrarOrdenReparacionView view = new MostrarOrdenReparacionView(nroOrden.getText());
						view.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(485, 179);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
