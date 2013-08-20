package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.exceptions.ExceptionModeloInactivo;
import com.uade.seminario.tpo.view.objectView.ModeloView;
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
public class AltaModeloView extends javax.swing.JInternalFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton quitarPieza;
	private JButton cancelar;
	private JButton confirmar;
	private JButton actualizar;
	private JList piezas;
	private JButton agregar;
	private JButton verificar;
	private JTextField descri;
	private JTextField codigo;
	private JTextField nombre;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				AltaModeloView inst = new AltaModeloView();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public AltaModeloView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("Alta Modelo");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre Equipo : ");
				jLabel1.setBounds(12, 27, 105, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Codigo Modelo : ");
				jLabel2.setBounds(12, 55, 92, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Descripcion : ");
				jLabel3.setBounds(12, 83, 105, 16);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(129, 24, 243, 23);
			}
			{
				codigo = new JTextField();
				getContentPane().add(codigo);
				codigo.setBounds(129, 52, 243, 23);
			}
			{
				descri = new JTextField();
				getContentPane().add(descri);
				descri.setBounds(129, 80, 243, 23);
			}
			{
				verificar = new JButton();
				getContentPane().add(verificar);
				verificar.setText("Verificar Modelo");
				verificar.setBounds(143, 109, 133, 23);
				verificar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!codigo.getText().equals("")){
							ModeloView modelo=SistemadeReparaciones.getInstancia().buscarModeloView(Integer.parseInt(codigo.getText()));
							if(modelo!=null){
								codigo.setText("");
								nombre.setText("");
								descri.setText("");
							}
							else{
								SistemadeReparaciones.getInstancia().altaModelo(nombre.getText(), Integer.parseInt(codigo.getText()), descri.getText());
								jScrollPane1.setVisible(true);
								agregar.setVisible(true);
								actualizar.setVisible(true);
								confirmar.setVisible(true);
								cancelar.setVisible(true);
								jLabel4.setVisible(true);
								quitarPieza.setVisible(true);
							}								
								
							
						}
						
					}
				});
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Piezas del Modelo : ");
				jLabel4.setVisible(false);
				jLabel4.setBounds(12, 132, 131, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setVisible(false);
				jScrollPane1.setBounds(12, 160, 225, 119);
				{
					
					SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
					
					DefaultListModel piezasModelo=new DefaultListModel();
					if(!codigo.getText().equals("")){
						for(PiezaView p: sist.buscarPiezaXModeloView(Integer.parseInt(codigo.getText()))){
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
				agregar.setBounds(249, 181, 123, 23);
				agregar.setVisible(false);
				agregar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						AltaPiezaView view= new AltaPiezaView(codigo.getText());
						view.setVisible(true);							
					}

					
				});
			}
			{
				confirmar = new JButton();
				getContentPane().add(confirmar);
				confirmar.setText("Confirmar");
				confirmar.setBounds(32, 289, 111, 23);
				confirmar.setVisible(false);
				confirmar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!codigo.getText().equals("")){
							SistemadeReparaciones.getInstancia().confirmarModelo(Integer.parseInt(codigo.getText()));
							dispose();
						}							
					}
				});
			}
			{
				actualizar = new JButton();
				getContentPane().add(actualizar);
				actualizar.setText("Actualizar Lista");
				actualizar.setBounds(249, 251, 123, 23);
				actualizar.setVisible(false);
				actualizar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						actualizarLista();
					}

					private void actualizarLista() {
						SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
						
						DefaultListModel piezasModelo=new DefaultListModel();
						if(!codigo.getText().equals("")){
							for(PiezaView p: sist.buscarPiezaXModeloView(Integer.parseInt(codigo.getText()))){
								piezasModelo.addElement(p.getNombrePieza());
							}
						}				
						piezas = new JList();
						jScrollPane1.setViewportView(piezas);
						piezas.setModel(piezasModelo);
						piezas.setBounds(12, 160, 225, 119);
						
					}
				});
			}
			{
				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setVisible(false);
				cancelar.setBounds(223, 289, 125, 23);
				cancelar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						try {
							SistemadeReparaciones.getInstancia().eliminarModelo(Integer.parseInt(codigo.getText()));
							dispose();
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
			}
			{
				quitarPieza = new JButton();
				getContentPane().add(quitarPieza);
				quitarPieza.setText("Quitar Pieza");
				quitarPieza.setVisible(false);
				quitarPieza.setBounds(249, 216, 123, 23);
				quitarPieza.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String nroPieza=(String) piezas.getSelectedValue().toString();
						SistemadeReparaciones.getInstancia().quitarPiezaModelo(Integer.parseInt(codigo.getText()),Integer.parseInt(nroPieza));
						
					}
				});
			}
			pack();
			this.setSize(400, 362);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
