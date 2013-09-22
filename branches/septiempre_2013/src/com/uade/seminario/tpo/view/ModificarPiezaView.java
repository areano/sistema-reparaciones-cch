package com.uade.seminario.tpo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
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
public class ModificarPiezaView extends javax.swing.JInternalFrame {

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton buscar;
	private JButton ok;
	private JTextArea descripcion;
	private JTextField codigo;
	private PiezaView pieza;

	public ModificarPiezaView() {
		super();
		initGUI();
	}
	private class ModificarPiezaLiestener implements ActionListener{
		private javax.swing.JInternalFrame frame;
		public ModificarPiezaLiestener(javax.swing.JInternalFrame frame){
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			pieza.setDescripcion(descripcion.getText());
			SistemadeReparaciones.getInstancia().modificarPieza(pieza);
			frame.dispose();
			
		}
		
	}
	private class BuscarPiezaLiestener implements ActionListener{
		private javax.swing.JInternalFrame frame;
		@Override
		public void actionPerformed(ActionEvent e) {
			pieza = SistemadeReparaciones.getInstancia().buscarPiezaView(Integer.parseInt(codigo.getText()));
			if(pieza != null){
				cargarPieza(pieza);
			}
		}
	}
	
	private void cargarPieza(PiezaView pieza) {
		descripcion.setText(pieza.getDescripcion());
	}

	private void initGUI() {
		try {
			setTitle("Modificar Pieza");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Codigo Pieza : ");
				jLabel2.setBounds(26, 17, 115, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Descripcion : ");
				jLabel4.setBounds(20, 127, 115, 16);
			}

			{
				codigo = new JTextField();
				getContentPane().add(codigo);
				codigo.setBounds(141, 14, 224, 23);
			}
			{
				descripcion = new JTextArea();
				getContentPane().add(descripcion);
				descripcion.setBounds(141, 127, 224, 87);
				descripcion.setEditable(false);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("Modificar Pieza");
				ok.setBounds(141, 241, 122, 23);
				ok.setEnabled(false);
				ok.addActionListener(new ModificarPiezaLiestener(this));
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("Buscar Pieza");
				buscar.setBounds(244, 49, 121, 23);
				buscar.addActionListener(new BuscarPiezaLiestener());
			}
			pack();
			this.setSize(400, 314);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
