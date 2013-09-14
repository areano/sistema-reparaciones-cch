package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.view.objectView.TareaReparacionView;


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
public class ListarTareaReparacionView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField nroOrden;
	private JButton buscarTareas;
	private JList lista;
	private JButton mostrarTarea;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ListarTareaReparacionView inst = new ListarTareaReparacionView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ListarTareaReparacionView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Listar Tareas de Reparacion");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Numero de Orden: ");
				jLabel1.setBounds(12, 12, 118, 16);
			}
			{
				nroOrden = new JTextField();
				getContentPane().add(nroOrden);
				nroOrden.setBounds(136, 9, 152, 23);
			}
			{
				buscarTareas = new JButton();
				getContentPane().add(buscarTareas);
				buscarTareas.setText("Buscar Tareas");
				buscarTareas.setBounds(123, 44, 128, 23);
				buscarTareas.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!nroOrden.getText().equals("")){
							Vector<Integer> numeros=new Vector<Integer>();
							List<TareaReparacionView> tareas=SistemadeReparaciones.getInstancia().listarTareasReparacion(Integer.parseInt(nroOrden.getText()));
							for (TareaReparacionView tareaReparacionView : tareas) {
								numeros.add(tareaReparacionView.getNroItemReparacion());
							}
							lista.setListData(numeros);
						}						
						
					}
				});
			}
			{
				ListModel listaModel = 
						new DefaultComboBoxModel(
								new String[] { });
				lista = new JList();
				getContentPane().add(lista);
				lista.setModel(listaModel);
				lista.setBounds(18, 78, 78, 197);
			}
			{
				mostrarTarea = new JButton();
				getContentPane().add(mostrarTarea);
				mostrarTarea.setText("Mostrar Tarea");
				mostrarTarea.setBounds(123, 161, 120, 24);
				mostrarTarea.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						MostrarTareaReparacionView view = new MostrarTareaReparacionView(nroOrden.getText(),lista.getSelectedValue().toString());
						view.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(323, 325);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
