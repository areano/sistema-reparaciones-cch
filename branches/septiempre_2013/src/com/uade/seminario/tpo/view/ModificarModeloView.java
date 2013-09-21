package com.uade.seminario.tpo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.exceptions.ExceptionNoExisteModelo;
import com.uade.seminario.tpo.view.objectView.ModeloView;
import com.uade.seminario.tpo.view.objectView.PiezaView;


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
public class ModificarModeloView extends javax.swing.JInternalFrame {

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton quitarPieza;
	private JButton confirmar;
	private JButton actualizar;
	private JList piezas;
	private JButton agregar;
	private JButton verificar;
	private JTextField descri;
	private JTextField codigo;
	private JTextField nombre;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private ModeloView modelo;
	private JDesktopPane jdEscritorio; 
	/**
	* Auto-generated main method to display this JFrame
	*/

	private class AgregarPiezaListener implements ActionListener{
		public AgregarPiezaListener(){}
		@Override
		public void actionPerformed(ActionEvent e) {
			AltaPiezaView view= new AltaPiezaView(modelo);
			InternalFrameLoader.getInstance().loadFrame(jdEscritorio, view);
			actualizar.doClick();

		}	
	}	
	public ModificarModeloView(JDesktopPane jdEscritorio) {
		super();
		initGUI();
		this.jdEscritorio = jdEscritorio;
	}
	
	private void initGUI() {
		try {
			setTitle("Modificar Modelo");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre Equipo : ");
				jLabel1.setBounds(12, 81, 105, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Codigo Modelo : ");
				jLabel2.setBounds(12, 12, 92, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Descripcion : ");
				jLabel3.setBounds(12, 106, 105, 16);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(130, 78, 243, 23);
			}
			{
				codigo = new JTextField();
				getContentPane().add(codigo);
				codigo.setBounds(136, 9, 243, 23);
			}
			{
				descri = new JTextField();
				getContentPane().add(descri);
				descri.setBounds(129, 103, 243, 23);
			}
			{
				verificar = new JButton();
				getContentPane().add(verificar);
				verificar.setText("Buscar Modelo");
				verificar.setBounds(130, 44, 133, 23);
				verificar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!codigo.getText().equals("")){
							modelo=SistemadeReparaciones.getInstancia().buscarModeloView(Integer.parseInt(codigo.getText()));
							if(modelo!=null){
								nombre.setText(modelo.getNombre());
								descri.setText(modelo.getDescripcion());
								actualizarLista();
							}
							else{
								codigo.setText("");								
							}
								
							
						}
						
					}
				});
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Piezas del Modelo : ");
				jLabel4.setBounds(12, 132, 131, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 160, 225, 119);
				{
					
					SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
					
					DefaultListModel piezasModelo=new DefaultListModel();
					if(!codigo.getText().equals("")){
						for(PiezaView p: sist.buscarPiezaXModeloView(Integer.parseInt(codigo.getText()))){
							piezasModelo.addElement(p);
						}
					}				
					piezas = new JList();
					jScrollPane1.setViewportView(piezas);
					piezas.setModel(piezasModelo);
					piezas.setBounds(12, 160, 225, 119);
					
					
				}
			}
			{
				agregar = new JButton();
				getContentPane().add(agregar);
				agregar.setText("Agregar Pieza");
				agregar.setBounds(249, 167, 123, 23);
				agregar.addActionListener(new AgregarPiezaListener());
//				agregar.addActionListener(new ActionListener() {
//					
//					public void actionPerformed(ActionEvent e) {
//						AltaPiezaView view= new AltaPiezaView(modelo);
//						view.setVisible(true);							
//					}
//
//					
//				});
			}
			{
				confirmar = new JButton();
				getContentPane().add(confirmar);
				confirmar.setText("Guardar");
				confirmar.setBounds(143, 289, 111, 23);
				confirmar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(!codigo.getText().equals("")){
							modelo.setDescripcion(descri.getText());
							modelo.setNombre(nombre.getText());
							SistemadeReparaciones.getInstancia().modificarModelo(modelo);
							dispose();
						}							
					}
				});
			}
			{
				actualizar = new JButton();
				getContentPane().add(actualizar);
				actualizar.setText("Actualizar Lista");
				actualizar.setBounds(249, 202, 123, 23);
				actualizar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						actualizarLista();
					}
				});
			}
			{
				quitarPieza = new JButton();
				getContentPane().add(quitarPieza);
				quitarPieza.setText("Quitar Pieza");
				quitarPieza.setBounds(249, 237, 123, 23);
				quitarPieza.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						PiezaView pieza=(PiezaView)SistemadeReparaciones.
								getInstancia().buscarPiezaView((Integer)piezas.getSelectedValue());
						modelo.eliminarPieza(pieza);
						
						
					}
				});
			}
			pack();
			this.setSize(400, 362);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void actualizarLista() {
		SistemadeReparaciones sist=SistemadeReparaciones.getInstancia();
		
		DefaultListModel piezasModelo=new DefaultListModel();
		if(!codigo.getText().equals("")){
			for(PiezaView p: modelo.getPiezas()){
				piezasModelo.addElement(p.getNroPieza());
			}
		}				
		piezas = new JList();
		jScrollPane1.setViewportView(piezas);
		piezas.setModel(piezasModelo);
		piezas.setBounds(12, 160, 225, 119);
		
	}
}
