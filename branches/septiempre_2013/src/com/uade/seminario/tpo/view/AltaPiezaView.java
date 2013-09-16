package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
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
public class AltaPiezaView extends javax.swing.JInternalFrame {
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton buscarPieza;
	private JButton ok;
	private JTextArea descripcion;
	private JTextField codModelo;
	private JTextField codigo;
	private JLabel jLabel3;
	private ModeloView modelo;
	private PiezaView pieza;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				AltaPiezaView inst = new AltaPiezaView("");
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	private class AgregarPiezaListener implements ActionListener{
		private javax.swing.JInternalFrame frame;
		public AgregarPiezaListener(javax.swing.JInternalFrame frame){
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			PiezaView piezaV=SistemadeReparaciones.getInstancia().buscarPiezaView(Integer.parseInt(codigo.getText()));
			if(piezaV!=null){
				if (!piezaV.getEstado().equalsIgnoreCase("activo")){
					piezaV.setDescripcion(descripcion.getText());
					piezaV.setEstado("activo");
					SistemadeReparaciones.getInstancia().modificarPieza(piezaV);
				}
				List<PiezaView> piezas = modelo.getPiezas();
				piezas.add(piezaV);
				modelo.setPiezas(piezas);	
				
				frame.dispose();
				
			}
			else{
				if(!codigo.getText().isEmpty()){
					pieza.setDescripcion(descripcion.getText());
					pieza.setEstado("activo");
					List<PiezaView> piezas = modelo.getPiezas();
					piezas.add(pieza);
					modelo.setPiezas(piezas);
					SistemadeReparaciones.getInstancia().altaPieza(pieza);
					frame.dispose();
				}else{
					MensajeErrorFrame mensaje = new MensajeErrorFrame("Codigo de pieza son Mandatorios");
					mensaje.setVisible(true);
					
					if  (codigo.getText().isEmpty()) codigo.setBackground(new java.awt.Color(255,0,0));
					
				}
			}
			frame.dispose();
			
		}
		
	}
	public AltaPiezaView() {
		super();
		pieza = null;		
		initGUI();
		codModelo.setEditable(false);
	}
	public AltaPiezaView(ModeloView modelo) {
		super();
		this.modelo = modelo;
		pieza = null;
		initGUI();		
		codModelo.setText(String.valueOf(modelo.getNroModelo()));
		codModelo.setEditable(false);
	}
	
	private void initGUI() {
		try {
			setTitle("Alta Pieza");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Codigo Pieza : ");
				jLabel2.setBounds(12, 39, 115, 23);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Codigo Modelo : ");
				jLabel3.setBounds(12, 67, 115, 23);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Descripcion : ");
				jLabel4.setBounds(12, 95, 117, 23);
			}
			{
				codigo = new JTextField();
				getContentPane().add(codigo);
				codigo.setBounds(127, 36, 224, 23);
			}
			{
				codModelo = new JTextField();
				getContentPane().add(codModelo);
				codModelo.setBounds(127, 64, 224, 23);
			}
			{
				descripcion = new JTextArea();
				getContentPane().add(descripcion);
				descripcion.setBounds(128, 93, 225, 89);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("Agregar Pieza");
				ok.setBounds(190, 210, 122, 23);
				ok.addActionListener(new AgregarPiezaListener(this));
				
			}
			{
				buscarPieza = new JButton();
				getContentPane().add(buscarPieza);
				buscarPieza.setText("Buscar Pieza");
				buscarPieza.setBounds(363, 36, 112, 23);
				buscarPieza.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						pieza=SistemadeReparaciones.getInstancia().buscarPiezaView(Integer.parseInt(codigo.getText()));
						if(pieza!=null ){
							if(pieza.getEstado().equalsIgnoreCase("activo")){
								descripcion.setText(pieza.getDescripcion());
								descripcion.setEditable(false);
								codigo.setEditable(false);
							}else{
								codigo.setEditable(false);
								descripcion.setText(pieza.getDescripcion());
							}
						}else{
							
							MensajeFrame mensaje = new MensajeFrame("No existe la pieza ["+codigo.getText()
									+"] por lo que sera creada s continua");
							mensaje.setVisible(true);
							pieza = new PiezaView(Integer.parseInt(codigo.getText()),descripcion.getText());
						}
					}
				});
			}
			pack();
			this.setSize(530, 300);
			this.setPreferredSize(new java.awt.Dimension(488, 282));
			this.setBounds(0, 0, 488, 282);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
