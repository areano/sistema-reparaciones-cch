package com.uade.seminario.tpo.view;

import javax.swing.WindowConstants;


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
public class AltaTareaReparacionView extends javax.swing.JInternalFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				AltaTareaReparacionView inst = new AltaTareaReparacionView("");
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public AltaTareaReparacionView(String nroOrdenReparacion) {
		super();
		initGUI();		
	}
	
	private void initGUI() {
		try {
			setTitle("Alta Tarea de Reparacion");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
