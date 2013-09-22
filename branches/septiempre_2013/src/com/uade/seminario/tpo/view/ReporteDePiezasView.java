package com.uade.seminario.tpo.view;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.view.objectView.ItemReporteView;
import com.uade.seminario.tpo.view.objectView.PiezaView;
import com.uade.seminario.tpo.view.objectView.ReporteView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListModel;

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
public class ReporteDePiezasView extends javax.swing.JFrame {
	private JList piezas;
	private JList cantidades;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReporteDePiezasView inst = new ReporteDePiezasView(null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ReporteDePiezasView(ReporteView reporte) {
		super();
		initGUI(reporte);
	}
	
	private void initGUI(ReporteView reporte) {
		try {
			setTitle("Reporte piezas/tareas");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(21, 30, 112, 193);
				{	if(reporte!=null){
					DefaultListModel piezasModelo=new DefaultListModel();
					for (ItemReporteView item : reporte.getItemsReporte()) {
						piezasModelo.addElement(item.getDescripcionPieza());
					}			
					piezas = new JList();
					jScrollPane1.setViewportView(piezas);
					piezas.setModel(piezasModelo);
					piezas.setBounds(149, 30, 118, 190);
					piezas.setPreferredSize(new java.awt.Dimension(96, 190));
					}
				}
				
				jScrollPane2 = new JScrollPane();
				getContentPane().add(jScrollPane2);
				jScrollPane2.setBounds(145, 30, 77, 193);
				{	
					if(reporte!=null){
					DefaultListModel piezasModelo1=new DefaultListModel();
					for (ItemReporteView item : reporte.getItemsReporte()) {
						piezasModelo1.addElement(item.getCantidadPieza());
					}			
					cantidades = new JList();
					jScrollPane2.setViewportView(cantidades);
					cantidades.setModel(piezasModelo1);
					cantidades.setBounds(239, 18, 74, 190);
					}

				}
		}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre Pieza y en cuantas tareas se usaron ");
				jLabel1.setBounds(12, 8, 317, 16);
			}
			pack();
			this.setSize(305, 297);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
