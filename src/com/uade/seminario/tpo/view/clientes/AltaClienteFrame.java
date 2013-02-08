package com.uade.seminario.tpo.view.clientes;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class AltaClienteFrame extends javax.swing.JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6666701907455719402L;
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
			FormLayout thisLayout = new FormLayout(new ColumnSpec[] {
					FormFactory.UNRELATED_GAP_COLSPEC,
					ColumnSpec.decode("47dlu"),
					ColumnSpec.decode("5dlu"),
					ColumnSpec.decode("max(78dlu;pref):grow"),
					FormFactory.BUTTON_COLSPEC,
					FormFactory.UNRELATED_GAP_COLSPEC,},
				new RowSpec[] {
					FormFactory.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("max(9dlu;pref)"),
					RowSpec.decode("5dlu"),
					RowSpec.decode("max(9dlu;pref)"),
					RowSpec.decode("5dlu"),
					RowSpec.decode("max(9dlu;pref)"),
					RowSpec.decode("5dlu"),
					RowSpec.decode("max(9dlu;pref)"),
					RowSpec.decode("5dlu"),
					RowSpec.decode("fill:max(9dlu;pref)"),
					FormFactory.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("max(15dlu;pref)"),
					FormFactory.UNRELATED_GAP_ROWSPEC,});
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
				jButton1.setEnabled(false);
				getContentPane().add(jButton1, new CellConstraints("5, 12, 1, 1, default, default"));
				jButton1.setText("Crear");
			}
			pack();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
