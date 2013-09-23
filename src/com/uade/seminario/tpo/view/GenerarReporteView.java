package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.view.objectView.ReporteView;


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
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				GenerarReporteView inst = new GenerarReporteView();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
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
				desde.setToolTipText("dd/mm/aaaa");
				getContentPane().add(desde);
				desde.setBounds(98, 16, 176, 23);
			}
			{
				hasta = new JTextField();
				hasta.setToolTipText("dd/mm/aaaa");
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
							SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
							Date fechaDesde=null, fechaHasta=null;
							try {
								fechaDesde = new Date(formatoDeFecha.parse(desde.getText()).getTime());
								fechaHasta = new Date(formatoDeFecha.parse(hasta.getText()).getTime());								
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							generar.setEnabled(false);
							ReporteView reporte=SistemadeReparaciones.getInstancia().emitirReportePiezas(fechaDesde, fechaHasta);
							generar.setEnabled(true);
							//ReporteDePiezasView view = new ReporteDePiezasView(reporte);
							
							//view.setVisible(true);
						}
						
						
					}
				});
			}
			pack();
			this.setSize(400, 200);
			this.setPreferredSize(new java.awt.Dimension(400, 200));
			this.setBounds(0, 0, 400, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
