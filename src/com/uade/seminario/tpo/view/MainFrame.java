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

public class MainFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -865594599931243954L;
	private JDesktopPane jdEscritorio;
	private JMenuBar jMenu;
	private JMenu jmCliente;
	private JMenuItem jmiModificarCliente;
	private JMenuItem jmiAltaCliente;
	private JMenu jmEquipo;
	private JMenu jmGarantia;
	private JMenu jmModelo;
	private JMenu jmOrdenDeReparacion;
	private JMenu jmPieza;
	private JMenu jmTareaDeReparacion;
	private JMenuItem jmiAltaEquipo;
	private JMenuItem jmiAltaGarantia;
	private JMenuItem jmiAltaModelo;
	private JMenuItem jmiModificarModelo;
	private JMenuItem jmiBajaModelo;
	private JMenuItem jmiAltaOrdenReparacion;
	private JMenuItem jmiAltaPieza;
	private JMenuItem jmiModificarPieza;
	private JMenuItem jmiBajaPieza;
	private JMenuItem jmiAltaTareaReparacion;

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
				jdEscritorio = new JDesktopPane();
				jMenu = new JMenuBar();
				setContentPane(jdEscritorio);
				setJMenuBar(jMenu);
				{
					{
						jmCliente = new JMenu("Cliente");
						jMenu.add(jmCliente);
						{
							jmiAltaCliente = new JMenuItem("Alta");
							jmCliente.add(jmiAltaCliente);
							jmiAltaCliente.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									cargarInternalFrame(new AltaClienteView());
								}
							});
						}
						{
							jmiModificarCliente = new JMenuItem("Modificar");
							jmCliente.add(jmiModificarCliente);
							jmiModificarCliente.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new ModificarClienteView());
								}
							});
						}
					}
					{
						jmEquipo = new JMenu("Equipo");
						jMenu.add(jmEquipo);
						{
							jmiAltaEquipo = new JMenuItem("Alta");
							jmEquipo.add(jmiAltaEquipo);
							jmiAltaEquipo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new AltaEquipoView());
								}
							});
						}
					}
					{
						jmGarantia = new JMenu("Garantia");
						jMenu.add(jmGarantia);
						{
							jmiAltaGarantia = new JMenuItem("Alta");
							jmGarantia.add(jmiAltaGarantia);
							jmiAltaGarantia.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new AltaGarantiaView());
								}
							});
						}
					}
					{
						jmModelo = new JMenu("Modelo");
						jMenu.add(jmModelo);
						{
							jmiAltaModelo = new JMenuItem("Alta");
							jmModelo.add(jmiAltaModelo);
							jmiAltaModelo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new AltaModeloView());
								}
							});
						}
						{
							jmiModificarModelo = new JMenuItem("Modificar");
							jmModelo.add(jmiModificarModelo);
							jmiModificarModelo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new ModificarModeloView());
								}
							});
						}
						{
							jmiBajaModelo = new JMenuItem("Baja");
							jmModelo.add(jmiBajaModelo);
							jmiBajaModelo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new BajaModeloView());
								}
							});
						}
					}
					{
						jmOrdenDeReparacion = new JMenu("Orden de Reparacion");
						jMenu.add(jmOrdenDeReparacion);
						{
							jmiAltaOrdenReparacion = new JMenuItem("Alta");
							jmOrdenDeReparacion.add(jmiAltaOrdenReparacion);
							jmiAltaOrdenReparacion.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new AltaOrdenReparacionView());
								}
							});
						}
					}
					{
						jmPieza = new JMenu("Pieza");
						jMenu.add(jmPieza);
						{
							jmiAltaPieza = new JMenuItem("Alta");
							jmPieza.add(jmiAltaPieza);
							jmiAltaPieza.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new AltaPiezaView());
								}
							});
						}
						{
							jmiModificarPieza = new JMenuItem("Modificar");
							jmPieza.add(jmiModificarPieza);
							jmiModificarPieza.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new ModificarPiezaView());
								}
							});
						}
						{
							jmiBajaPieza = new JMenuItem("Baja");
							jmPieza.add(jmiBajaPieza);
							jmiBajaPieza.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new BajaPiezaView());
								}
							});
						}
					}
					{
						jmTareaDeReparacion = new JMenu("Tarea de Reparacion");
						jMenu.add(jmTareaDeReparacion);
						{
							jmiAltaTareaReparacion = new JMenuItem("Alta");
							jmTareaDeReparacion.add(jmiAltaTareaReparacion);
							jmiAltaTareaReparacion.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									cargarInternalFrame(new AltaTareaReparacionView(""));
								}
							});
						}
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
		frame.setClosable(true);

		jdEscritorio.add(frame);

		// seleccionar el frame actual
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
