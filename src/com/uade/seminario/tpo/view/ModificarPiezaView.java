package com.uade.seminario.tpo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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
public class ModificarPiezaView extends javax.swing.JInternalFrame {

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton buscar;
	private JButton ok;
	private JTextArea descripcion;
	private JTextField codigo;
	private JTextField nombre;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				ModificarPiezaView inst = new ModificarPiezaView();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public ModificarPiezaView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("Modificar Pieza");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre Pieza : ");
				jLabel1.setBounds(20, 95, 115, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Codigo Pieza : ");
				jLabel2.setBounds(26, 17, 115, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Descripcion : ");
				jLabel4.setBounds(20, 127, 115, 16);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(141, 92, 224, 23);
			}
			{
				codigo = new JTextField();
				getContentPane().add(codigo);
				codigo.setBounds(141, 14, 224, 23);
			}
			{
				descripcion = new JTextArea();
				getContentPane().add(descripcion);
				descripcion.setBounds(141, 127, 224, 87);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("Agregar Pieza");
				ok.setBounds(141, 241, 122, 23);
				ok.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						SistemadeReparaciones.getInstancia().modificarPieza(nombre.getText(),Integer.parseInt(codigo.getText()),descripcion.getText());
					}
				});
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("Buscar Pieza");
				buscar.setBounds(244, 49, 121, 23);
				buscar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						PiezaView pieza=SistemadeReparaciones.getInstancia().buscarPiezaView(Integer.parseInt(codigo.getText()));
						nombre.setText(pieza.getNombrePieza());
						descripcion.setText(pieza.getDescripcion());
						
					}
				});
			}
			pack();
			this.setSize(400, 314);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
