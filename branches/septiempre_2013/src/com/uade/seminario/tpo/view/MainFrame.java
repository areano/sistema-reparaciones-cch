package com.uade.seminario.tpo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.view.clientes.AltaClienteFrame;
import com.uade.seminario.tpo.view.clientes.BajaClienteFrame;
import com.uade.seminario.tpo.view.clientes.ModificarClienteFrame;

public class MainFrame extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -865594599931243954L;
	private JMenuBar jMenu;
	private JMenuItem jmiModificarCliente;
	private JMenuItem jmiBajaCliente;
	private JMenuItem jmiAltaCliente;
	private JMenu jMenu1;
	private JDesktopPane desktop;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				JFrame.setDefaultLookAndFeelDecorated(true);

				MainFrame inst = new MainFrame();

				inst.setExtendedState(JFrame.MAXIMIZED_BOTH);
				inst.setVisible(true);
				inst.setResizable(false);
				inst.setLocationRelativeTo(null);
			}
		});
	}

	public MainFrame() {
		super("Sistema de Reparaciones - Chh srl");
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				desktop = new JDesktopPane();
				jMenu = new JMenuBar();
				setContentPane(desktop);
				setJMenuBar(jMenu);
				{
					jMenu1 = new JMenu();
					jMenu.add(jMenu1);
					jMenu1.setText("Clientes");
					{
						jmiAltaCliente = new JMenuItem();
						jMenu1.add(jmiAltaCliente);
						jmiAltaCliente.setText("Alta");
						jmiAltaCliente.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								cargarInternalFrame(new AltaClienteFrame());
							}
						});
					}
					{
						jmiModificarCliente = new JMenuItem();
						jMenu1.add(jmiModificarCliente);
						jmiModificarCliente.setText("Modificar");
						jmiModificarCliente
								.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										cargarInternalFrame(new ModificarClienteFrame());
									}
								});
					}
					{
						jmiBajaCliente = new JMenuItem();
						jMenu1.add(jmiBajaCliente);
						jmiBajaCliente.setText("Baja");
						jmiBajaCliente.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								cargarInternalFrame(new BajaClienteFrame());
							}
						});
					}
				}
			}
			pack();
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void cargarInternalFrame(JInternalFrame frame) {
		frame.setVisible(true);
		desktop.add(frame);

		// seleccionar el frame actual
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
