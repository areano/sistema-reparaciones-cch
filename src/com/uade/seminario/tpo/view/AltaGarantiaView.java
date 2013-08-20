package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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
public class AltaGarantiaView extends javax.swing.JInternalFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField fecha;
	private JButton ok;
	private JTextField nroGarantia;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				AltaGarantiaView inst = new AltaGarantiaView();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public AltaGarantiaView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("Alta Garantia");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Numero Garantia : ");
				jLabel1.setBounds(12, 26, 136, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Fecha Vencimiento : ");
				jLabel2.setBounds(12, 60, 137, 16);
			}
			{
				nroGarantia = new JTextField();
				getContentPane().add(nroGarantia);
				nroGarantia.setBounds(148, 23, 201, 23);
			}
			{
				fecha = new JTextField();
				getContentPane().add(fecha);
				fecha.setBounds(148, 57, 201, 23);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("Alta Garantia");
				ok.setBounds(122, 109, 124, 23);
				ok.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Date fecha1=new Date(Date.parse(fecha.getText()));
						if(!nroGarantia.getText().equals(""))
						SistemadeReparaciones.getInstancia().altaGarantia(Integer.parseInt(nroGarantia.getText()),fecha1);
						dispose();
					}
				});
			}
			pack();
			this.setSize(400, 193);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
