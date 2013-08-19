package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
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
public class AltaPiezaView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton buscarPieza;
	private JButton ok;
	private JTextArea descripcion;
	private JTextField codModelo;
	private JTextField codigo;
	private JTextField nombre;
	private JLabel jLabel3;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaPiezaView inst = new AltaPiezaView("");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaPiezaView(String codigo) {
		super();
		initGUI();
		codModelo.setText(codigo);
		codModelo.setEditable(false);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre Pieza : ");
				jLabel1.setBounds(26, 39, 115, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Codigo Pieza : ");
				jLabel2.setBounds(26, 67, 115, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Codigo Modelo : ");
				jLabel3.setBounds(26, 95, 115, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Descripcion : ");
				jLabel4.setBounds(26, 123, 115, 16);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(141, 36, 224, 23);
			}
			{
				codigo = new JTextField();
				getContentPane().add(codigo);
				codigo.setBounds(141, 64, 224, 23);
			}
			{
				codModelo = new JTextField();
				getContentPane().add(codModelo);
				codModelo.setBounds(141, 92, 224, 23);
			}
			{
				descripcion = new JTextArea();
				getContentPane().add(descripcion);
				descripcion.setBounds(141, 121, 224, 87);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("Agregar Pieza");
				ok.setBounds(118, 227, 122, 23);
				ok.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						PiezaView piezaV=SistemadeReparaciones.getInstancia().buscarPiezaView(Integer.parseInt(codigo.getText()));
						if(piezaV!=null){
							SistemadeReparaciones.getInstancia().agregarPiezaModelo(piezaV,Integer.parseInt(codModelo.getText()));
							dispose();
						}
						else{
							if(!codigo.getText().equals("") && !codModelo.getText().equals("")){
								SistemadeReparaciones.getInstancia().altaPieza(nombre.getText(),Integer.parseInt(codigo.getText()),Integer.parseInt(codModelo.getText()),descripcion.getText());
								dispose();
							}
						}
						
						
					}
				});
			}
			{
				buscarPieza = new JButton();
				getContentPane().add(buscarPieza);
				buscarPieza.setText("Buscar Pieza");
				buscarPieza.setBounds(377, 64, 125, 23);
				buscarPieza.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						PiezaView piezaV=SistemadeReparaciones.getInstancia().buscarPiezaView(Integer.parseInt(codigo.getText()));
						if(piezaV!=null){
							nombre.setText(piezaV.getNombrePieza());
							descripcion.setText(piezaV.getDescripcion());
						}
					}
				});
			}
			pack();
			this.setSize(530, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
