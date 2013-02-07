package com.uade.seminario.tpo.view.clientes;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
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
public class AltaClienteFrame extends javax.swing.JInternalFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton jButton1;
	private JTextField jTextField5;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;

	/**
	* Auto-generated main method to display this 
	* JInternalFrame inside a new JFrame.
	*/
		
	public AltaClienteFrame() {
		super("Alta Cliente",false,true,false,false);
		initGUI();
	}
	
	private void initGUI() {
		try {
			
			this.setPreferredSize(null);
			FormLayout thisLayout = new FormLayout(
					"5dlu, 47dlu, 5dlu, max(p;78dlu):grow, max(p;15dlu), 5dlu", 
					"6dlu, max(p;9dlu), 5dlu, max(p;9dlu), 5dlu, max(p;9dlu), 5dlu, max(p;9dlu), 5dlu, fill:max(p;9dlu), 5dlu, max(p;15dlu),6dlu");
			setVisible(true);
			getContentPane().setLayout(thisLayout);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, new CellConstraints("2, 2, 1, 1, default, default"));
				jLabel1.setText("Codigo Cliente");
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2, new CellConstraints("2, 4, 1, 1, default, default"));
				jLabel2.setText("Nombre");
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3, new CellConstraints("2, 6, 1, 1, default, default"));
				jLabel3.setText("Direccion");
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4, new CellConstraints("2, 8, 1, 1, default, default"));
				jLabel4.setText("Telefono");
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5, new CellConstraints("2, 10, 1, 1, default, default"));
				jLabel5.setText("Email");
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, new CellConstraints("4, 2, 2, 1, default, default"));
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2, new CellConstraints("4, 4, 2, 1, default, default"));
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3, new CellConstraints("4, 6, 2, 1, default, default"));
			}
			{
				jTextField4 = new JTextField();
				getContentPane().add(jTextField4, new CellConstraints("4, 8, 2, 1, default, default"));
			}
			{
				jTextField5 = new JTextField();
				getContentPane().add(jTextField5, new CellConstraints("4, 10, 2, 1, default, default"));
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, new CellConstraints("5, 12, 1, 1, default, default"));
				jButton1.setText("Agregar Cliente");
			}
			pack();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
