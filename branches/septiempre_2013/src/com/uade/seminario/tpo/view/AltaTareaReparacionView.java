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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.WindowConstants;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.view.objectView.ItemReparacionView;
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
public class AltaTareaReparacionView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton confirmar;
	private JButton actualizar;
	private JTextField nroTarea;
	private JButton quitarPieza;
	private JButton agregarPieza;
	private JButton crearTarea;
	private JTextArea detalle;
	private JTextField nroOrden;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JList<String> piezas;
	private TareaReparacionView  tarea;
	private SistemadeReparaciones sistema;
	private OrdenReparacionView orden;
	private Map<String, PiezaView> piezasTarea;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//AltaTareaReparacionView inst = new AltaTareaReparacionView("");
				//inst.setLocationRelativeTo(null);
				//inst.setVisible(true);
				
			}
		});
	}
	
	public class AgregarPiezaListener2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AgregarPiezaTareaView view =new AgregarPiezaTareaView(orden,tarea);
			view.setVisible(true);		
		}

	}

	public class ConfirmarTarea implements ActionListener {
		javax.swing.JFrame frame;
		public ConfirmarTarea(javax.swing.JFrame frame){
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			tarea.setEstado("activo");
			orden.addTareaReparacion(tarea);
			frame.dispose();
			
		}

	}	
	
	public AltaTareaReparacionView(OrdenReparacionView orden) {
		super();
		tarea = null;
		sistema = SistemadeReparaciones.getInstancia();
		this.orden = orden;
		piezasTarea = new HashMap<String, PiezaView>();
		initGUI(orden);
		//nroOrden.setText(orden);
		nroOrden.setEditable(false);

	}
	
	private void initGUI(OrdenReparacionView orden) {
		try {
			setTitle("Alta Tarea de Reparacion");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			this.setSize(449, 405);
			this.setPreferredSize(new java.awt.Dimension(449, 405));
			this.setBounds(0, 0, 449, 405);
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
				jLabel3.setVisible(false);
				jLabel3.setBounds(12, 169, 128, 16);
			}
			{
				nroOrden = new JTextField();
				getContentPane().add(nroOrden);
				nroOrden.setBounds(146, 9, 240, 23);
			}
			{
				detalle = new JTextArea();
				getContentPane().add(detalle);
				detalle.setBounds(146, 43, 240, 64);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setVisible(false);
				jScrollPane1.setBounds(12, 197, 225, 119);
				{
					
					SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
					
//					DefaultListModel piezasModelo=new DefaultListModel();
//					if(!nroOrden.getText().equals("") && !nroTarea.getText().equals("")){
//						for(PiezaView p: sist.buscarPiezasXTareaView(Integer.parseInt(nroOrden.getText()),Integer.parseInt(nroTarea.getText()))){
//							piezasModelo.addElement(p);
//						}
//						for (PiezaView p : orden.getItemsReparacion()){
//							
//						}
//						
//					}
					
//					piezas = new JList();
//					jScrollPane1.setViewportView(piezas);
//					piezas.setModel(piezasModelo);
//					piezas.setBounds(12, 160, 225, 119);
//					piezas.setVisible(false);
					
					
				}
			}
			{
				crearTarea = new JButton();
				getContentPane().add(crearTarea);
				crearTarea.setText("Crear Tarea");
				crearTarea.setBounds(266, 129, 120, 23);
				crearTarea.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!detalle.getText().isEmpty()){
							tarea = new TareaReparacionView(); 
							tarea.setDetalle(detalle.getText());
							jScrollPane1.setVisible(true);
							agregarPieza.setVisible(true);
							quitarPieza.setVisible(true);
							jLabel3.setVisible(true);
							actualizar.setVisible(true);
							detalle.setEnabled(false);
						}else{
							MensajeErrorFrame mensaje = new MensajeErrorFrame("Agregue un detalle Primero");
							mensaje.setVisible(true);
						}
					}
				});
			}
			{
				agregarPieza = new JButton();
				getContentPane().add(agregarPieza);
				agregarPieza.setText("Agregar Pieza");
				agregarPieza.setVisible(false);
				agregarPieza.setBounds(254, 211, 132, 23);
				
				agregarPieza.addActionListener(new AgregarPiezaListener2());
			}
			{
				quitarPieza = new JButton();
				getContentPane().add(quitarPieza);
				quitarPieza.setText("Quitar Pieza");
				quitarPieza.setVisible(false);
				quitarPieza.setBounds(254, 246, 132, 23);
				quitarPieza.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						PiezaView piezaRemover= piezasTarea.get((String)piezas.getSelectedValue());
						//tarea.getPiezas().remove(piezaRemover);					
					}
				});
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
				nroTarea.setBounds(113, 129, 141, 23);
			}
			{
				actualizar = new JButton();
				getContentPane().add(actualizar);
				actualizar.setText("Actualizar Tabla");
				actualizar.setBounds(254, 281, 132, 23);
				actualizar.setVisible(false);
				actualizar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						actualizarLista();						
					}
					private void actualizarLista() {
						SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
						
						DefaultListModel<String> piezasModelo=new DefaultListModel<String>();
						for(ItemReparacionView i: tarea.getItemReparacion())//tarea.getPiezas())
						{
								piezasModelo.addElement(i.getPieza().getDescripcion());
								piezasTarea.put(i.getPieza().getDescripcion(), i.getPieza());
						}
				
						piezas = new JList<String>();
						jScrollPane1.setViewportView(piezas);
						piezas.setModel(piezasModelo);
						piezas.setBounds(12, 160, 225, 119);
						
					}
				});
			}
			{
				confirmar = new JButton();
				getContentPane().add(confirmar);
				confirmar.setText("Confirmar");
				confirmar.setBounds(157, 332, 97, 23);
				confirmar.addActionListener(new ConfirmarTarea(this));
//				confirmar.addActionListener(new ActionListener() {
//					
//					public void actionPerformed(ActionEvent e) {
//						if(!nroTarea.getText().equals("") && !nroOrden.getText().equals("")){
//							SistemadeReparaciones.getInstancia().confirmarTarea(Integer.parseInt(nroTarea.getText()),Integer.parseInt(nroOrden.getText()));
//							
//						}
//						
//					}
//				});
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
