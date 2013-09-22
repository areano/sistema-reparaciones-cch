package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
import com.uade.seminario.tpo.model.Pieza;
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
public class AgregarPiezaTareaView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton agregar;
	private JLabel jLabel3;
	private JTextField nroTarea;
	private JTextField nroOrden;
	private JScrollPane jScrollPane1;
	private JList piezas;
	private TareaReparacionView tarea;
	private Map< String, PiezaView> piezasTarea;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//AgregarPiezaTareaView inst = new AgregarPiezaTareaView("", "");
				//inst.setLocationRelativeTo(null);
				//inst.setVisible(true);
			}
		});
	}
	
	public class AgregarPiezaTareaListener2 implements ActionListener {
		javax.swing.JFrame frame;
		public AgregarPiezaTareaListener2(javax.swing.JFrame frame){
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			PiezaView piezaATarea = (PiezaView)piezasTarea.get((String)piezas.getSelectedValue());			
			tarea.addPieza(piezaATarea);	
			frame.dispose();
		}

	}

	public AgregarPiezaTareaView(OrdenReparacionView orden, TareaReparacionView tarea) {
		super();
		this.tarea = tarea;
		piezasTarea = new HashMap<String, PiezaView>();
		initGUI(orden, this.tarea);
		
	}
	//private void initGUI(String numeroOrden, String numeroTarea) {
	private void initGUI(OrdenReparacionView orden, TareaReparacionView tarea) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Agregar Piezas a la Tarea de Reparacion");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Numero Orden : ");
				jLabel1.setBounds(12, 12, 120, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Numero Tarea: ");
				jLabel2.setBounds(12, 46, 120, 16);
			}
			{
				nroOrden = new JTextField();
				getContentPane().add(nroOrden);
				nroOrden.setBounds(132, 9, 198, 23);
				//nroOrden.setText(numeroOrden);
				nroOrden.setEditable(false);
			}
			{
				nroTarea = new JTextField();
				getContentPane().add(nroTarea);
				nroTarea.setBounds(132, 43, 198, 23);
				//nroTarea.setText(numeroTarea);
				nroTarea.setEditable(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Lista de Piezas del Modelo : ");
				jLabel3.setBounds(12, 81, 197, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setVisible(true);
				jScrollPane1.setBounds(12, 109, 346, 132);
				{
					
					SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
					
					DefaultListModel piezasModelo=new DefaultListModel();
					int nroModelo= orden.getEquipo().getModelo().getNroModelo();
						for(PiezaView p:  orden.getEquipo().getModelo().getPiezas()){
							piezasModelo.addElement(p.getDescripcion());
							piezasTarea.put(p.getDescripcion(), p);
						}
		
					piezas = new JList();
					jScrollPane1.setViewportView(piezas);
					piezas.setModel(piezasModelo);
					piezas.setBounds(12, 109, 346, 132);
					piezas.setVisible(true);
					
					
				}
			}
			{
				agregar = new JButton();
				getContentPane().add(agregar);
				agregar.setText("Agregar Pieza");
				agregar.setBounds(123, 247, 116, 23);
				agregar.addActionListener(new AgregarPiezaTareaListener2(this));

//				agregar.addActionListener(new ActionListener() {
//					
//					public void actionPerformed(ActionEvent arg0) {
//						PiezaView pieza=((PiezaView)piezas.getSelectedValue());
//						if(pieza!=null){
//							//SistemadeReparaciones.getInstancia().agregarPiezaTarea(Integer.parseInt(nroOrden.getText()),Integer.parseInt(nroTarea.getText()),pieza.getNroPieza());
//							//tarea.addPieza(pieza);
//						}
//						
//						
//					}
//					
//				});

				
			}
			pack();
			this.setSize(400, 320);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
