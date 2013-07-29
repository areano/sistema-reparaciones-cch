package com.uade.seminario.tpo.view.clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class BajaClienteFrame extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	* Auto-generated main method to display this 
	* JInternalFrame inside a new JFrame.
	*/
		
	public BajaClienteFrame() {
		super();
		setTitle("Baja Cliente");
		setClosable(true);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelBuscar);
		panelBuscar.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.BUTTON_COLSPEC,
				FormFactory.UNRELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,}));
		
		JLabel lblCodigoCliente = new JLabel("Codigo Cliente");
		panelBuscar.add(lblCodigoCliente, "2, 2, right, default");
		
		textField = new JTextField();
		panelBuscar.add(textField, "4, 2, 3, 1, fill, default");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelBuscar.add(btnNewButton, "6, 4");
		
		JPanel panelEditar = new JPanel();
		panelEditar.setEnabled(false);
		panelEditar.setBorder(new TitledBorder(null, "Cliente Encontrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelEditar);
		panelEditar.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;min):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.BUTTON_COLSPEC,
				FormFactory.UNRELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,}));
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setEnabled(false);
		panelEditar.add(lblDireccion, "2, 2");
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		panelEditar.add(textField_1, "4, 2, 3, 1, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setEnabled(false);
		panelEditar.add(lblNombre, "2, 4");
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		panelEditar.add(textField_2, "4, 4, 3, 1, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setEnabled(false);
		panelEditar.add(lblTelefono, "2, 6");
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		panelEditar.add(textField_3, "4, 6, 3, 1, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setEnabled(false);
		panelEditar.add(lblNewLabel, "2, 8");
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		panelEditar.add(textField_4, "4, 8, 3, 1, fill, default");
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setEnabled(false);
		panelEditar.add(btnNewButton_1, "6, 10");
		initGUI();
	}
	
	private void initGUI() {
		try {
			setVisible(true);
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
