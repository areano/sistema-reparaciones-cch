package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.GatheringByteChannel;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.view.objectView.GarantiaView;


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
	private GarantiaView garantiaView;
	private JTextField nrogarantia2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private class AltaGrantia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			if(!nroGarantia.getText().equals(""))
			garantiaView.setNroGarantia(nroGarantia.getText());
			garantiaView.setFechaVencimiento(fecha.getText());
			nrogarantia2.setText(nroGarantia.getText());
			nrogarantia2.updateUI();
			//SistemadeReparaciones.getInstancia().altaGarantia(garantiaView);
			dispose();
		}
		
	}
	public AltaGarantiaView() {
		super();
		this.garantiaView = new GarantiaView();
		initGUI();
	}
	
	public AltaGarantiaView(GarantiaView garantiaView, JTextField nrogarantia2) {
		super();
		this.garantiaView = garantiaView;
		this.nrogarantia2 = nrogarantia2;
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
				ok.addActionListener(new AltaGrantia());
			}
			pack();
			this.setSize(400, 193);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
