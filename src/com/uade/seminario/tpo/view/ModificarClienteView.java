package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.view.objectView.ClienteView;


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
public class ModificarClienteView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JLabel jLabel8;
	private JTextField tipoDoc;
	private JButton ok;
	private JTextField email;
	private JTextField telefono;
	private JTextField direccion;
	private JTextField nombre;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel3;
	private JButton jButton1;
	private JTextField nroDoc;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ModificarClienteView inst = new ModificarClienteView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificarClienteView() {
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
				jLabel1.setBounds(23, 12, 100, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Numero Documento: ");
				jLabel2.setBounds(23, 40, 138, 16);
			}
			{
				nroDoc = new JTextField();
				getContentPane().add(nroDoc);
				nroDoc.setBounds(167, 37, 232, 23);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Buscar");
				jButton1.setBounds(248, 97, 98, 23);
				jButton1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						ClienteView cliente=SistemadeReparaciones.getInstancia().obtenerClienteView(nroDoc.getText(),tipoDoc.getText());
						if(cliente!=null){
							nombre.setText(cliente.getNombre());
							direccion.setText(cliente.getDireccion());
							telefono.setText(cliente.getTelefono());
							email.setText(cliente.getEmail());
						}
						else
							nroDoc.setText("");
						
					}
				});
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Datos Cliente Encontrado :");
				jLabel3.setBounds(23, 120, 183, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Nombre : ");
				jLabel4.setBounds(23, 156, 88, 16);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Direccion : ");
				jLabel5.setBounds(23, 185, 88, 16);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Telefono : ");
				jLabel6.setBounds(23, 214, 88, 16);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Email : ");
				jLabel7.setBounds(23, 243, 88, 16);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(123, 153, 232, 23);
			}
			{
				direccion = new JTextField();
				getContentPane().add(direccion);
				direccion.setBounds(123, 182, 232, 23);
			}
			{
				telefono = new JTextField();
				getContentPane().add(telefono);
				telefono.setBounds(123, 211, 232, 23);
			}
			{
				email = new JTextField();
				getContentPane().add(email);
				email.setBounds(123, 240, 232, 23);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("Modificar Cliente");
				ok.setBounds(211, 282, 144, 23);
				ok.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String nombre1=nombre.getText();
						String dir=direccion.getText();
						String tel=telefono.getText();
						String mail=email.getText();
						if(nombre1!=null && dir!=null && tel!=null && mail!=null){
							SistemadeReparaciones.getInstancia().modificarCliente(nroDoc.getText(),tipoDoc.getText(),nombre1,dir,tel,mail);
						}
						else
						{
							nombre.setText("");
							direccion.setText("");
							telefono.setText("");
							email.setText("");
						}
						
					}
				});
			}
			{
				tipoDoc = new JTextField();
				getContentPane().add(tipoDoc);
				tipoDoc.setBounds(167, 66, 232, 23);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("Tipo Documento : ");
				jLabel8.setBounds(23, 69, 132, 16);
			}
			pack();
			this.setSize(436, 374);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
