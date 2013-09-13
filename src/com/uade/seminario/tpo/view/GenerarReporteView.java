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
import com.uade.seminario.tpo.model.Reporte;


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
public class GenerarReporteView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton generar;
	private JTextField hasta;
	private JTextField desde;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GenerarReporteView inst = new GenerarReporteView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GenerarReporteView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("Generar Reporte de Piezas usadas");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Desde: ");
				jLabel1.setBounds(12, 19, 57, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Hasta: ");
				jLabel2.setBounds(12, 58, 57, 16);
			}
			{
				desde = new JTextField();
				getContentPane().add(desde);
				desde.setBounds(98, 16, 176, 23);
			}
			{
				hasta = new JTextField();
				getContentPane().add(hasta);
				hasta.setBounds(98, 55, 176, 23);
			}
			{
				generar = new JButton();
				getContentPane().add(generar);
				generar.setText("Generar");
				generar.setBounds(147, 105, 95, 23);
				generar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!desde.getText().equals("") && !hasta.getText().equals("")){
							Date fechaDesde=new Date(Date.parse(desde.getText()));
							Date fechaHasta=new Date(Date.parse(hasta.getText()));
							Reporte reporte=SistemadeReparaciones.getInstancia().emitirReportePiezas(fechaDesde, fechaHasta);
							ReporteDePiezasView view = new ReporteDePiezasView(reporte);
							view.setVisible(true);
						}
						
						
					}
				});
			}
			pack();
			this.setSize(400, 189);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
