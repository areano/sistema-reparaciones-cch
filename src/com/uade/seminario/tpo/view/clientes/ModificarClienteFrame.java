package com.uade.seminario.tpo.view.clientes;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ModificarClienteFrame extends javax.swing.JInternalFrame {

	/**
	* Auto-generated main method to display this 
	* JInternalFrame inside a new JFrame.
	*/
		
	public ModificarClienteFrame() {
		super();
		setTitle("Modicicar Cliente");
		setClosable(true);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(null, "Codigo Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelBuscar);
		panelBuscar.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		panelBuscar.add(lblNewLabel, "2, 2");
		
//		J lblNewLabel = new JLabel("New label");
//		panelBuscar.add(lblNewLabel, "2, 2");
		
		JTextField a = new JTextField(); 
		panelBuscar.add(a, "2, 2");
		
		JPanel panelEditar = new JPanel();
		panelEditar.setBorder(new TitledBorder(null, "Cliente Encontrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelEditar);
		panelEditar.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		initGUI();
	}
	
	private void initGUI() {
		try {
//			setPreferredSize(new Dimension(400, 300));
//			setBounds(new Rectangle(0, 0, 400, 300));
			setVisible(true);
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
