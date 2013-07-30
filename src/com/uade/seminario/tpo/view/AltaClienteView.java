package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;


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
public class AltaClienteView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JTextField tel;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JTextField fechaNac;
	private JTextField tipoDoc;
	private JLabel jLabel7;
	private JButton ok;
	private JTextField mail;
	private JTextField direccion;
	private JTextField apellido;
	private JTextField nombre;
	private JTextField nroDoc;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel3;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaClienteView inst = new AltaClienteView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaClienteView() {
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
				jLabel1.setText("Datos Cliente");
				jLabel1.setBounds(27, 5, 120, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Numero Documento : ");
				jLabel2.setBounds(12, 40, 134, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Nombre Cliente : ");
				jLabel3.setBounds(12, 97, 120, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Apellido Cliente : ");
				jLabel4.setBounds(12, 126, 120, 16);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Direccion Cliente :");
				jLabel5.setBounds(12, 155, 120, 16);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("E-Mail Cliente : ");
				jLabel6.setBounds(12, 183, 120, 16);
			}
			{
				nroDoc = new JTextField();
				getContentPane().add(nroDoc);
				nroDoc.setBounds(152, 37, 219, 23);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(153, 94, 219, 23);
			}
			{
				apellido = new JTextField();
				getContentPane().add(apellido);
				apellido.setBounds(153, 123, 219, 23);
			}
			{
				direccion = new JTextField();
				getContentPane().add(direccion);
				direccion.setBounds(153, 152, 219, 23);
			}
			{
				mail = new JTextField();
				getContentPane().add(mail);
				mail.setBounds(153, 180, 219, 23);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("Agregar Cliente");
				ok.setBounds(153, 274, 140, 23);
				ok.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(nroDoc.getText()!=null){
							SistemadeReparaciones.getInstancia().altaCliente(Integer.parseInt(nroDoc.getText()),tipoDoc.getText(),nombre.getText(),apellido.getText(),direccion.getText(),mail.getText(),fechaNac.getText(),tel.getText());
						}					
					}
				});
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Tipo Documento : ");
				jLabel7.setBounds(12, 69, 120, 16);
			}
			{
				tipoDoc = new JTextField();
				getContentPane().add(tipoDoc);
				tipoDoc.setBounds(153, 66, 218, 23);
			}
			{
				fechaNac = new JTextField();
				getContentPane().add(fechaNac);
				fechaNac.setBounds(153, 209, 219, 23);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("Fecha Nacimiento : ");
				jLabel8.setBounds(12, 212, 129, 16);
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("Telefono : ");
				jLabel9.setBounds(12, 240, 99, 16);
			}
			{
				tel = new JTextField();
				getContentPane().add(tel);
				tel.setBounds(153, 237, 219, 23);
			}
			pack();
			this.setSize(410, 352);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
