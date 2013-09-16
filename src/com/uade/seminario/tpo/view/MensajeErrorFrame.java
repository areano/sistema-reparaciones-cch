package com.uade.seminario.tpo.view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class MensajeErrorFrame extends javax.swing.JFrame {
	private JLabel MensajeError;
	private JButton Okbutton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private class OkListener implements ActionListener{
		private javax.swing.JFrame  frame;
		public OkListener(javax.swing.JFrame frame){
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			
		}
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MensajeErrorFrame inst = new MensajeErrorFrame("Esto es un mensaje");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MensajeErrorFrame(String mensaje) {
		super();
		MensajeError = new JLabel();
		MensajeError.setText(mensaje);
		initGUI(mensaje);
	}
	
	private void initGUI(String mensaje) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				
				getContentPane().add(MensajeError, BorderLayout.NORTH);
				MensajeError.setPreferredSize(new java.awt.Dimension(384, 107));
			}
			{
				Okbutton = new JButton();
				getContentPane().add(Okbutton, BorderLayout.SOUTH);
				Okbutton.setText("Ok");
				Okbutton.setPreferredSize(new java.awt.Dimension(23, 23));
				Okbutton.setSize(20, 23);
				Okbutton.setOpaque(false);
				Okbutton.addActionListener(new OkListener(this));
			}
			pack();
			this.setSize(334, 183);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
