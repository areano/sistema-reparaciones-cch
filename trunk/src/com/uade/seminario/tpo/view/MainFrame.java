package com.uade.seminario.tpo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.uade.seminario.tpo.view.clientes.AltaClienteFrame;


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
public class MainFrame extends javax.swing.JFrame {
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
			this.setFocusableWindowState(false);
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
								BaseFrame frame = new AltaClienteFrame();
								frame.setVisible(true);
								desktop.add(frame);
							}
						});
					}
					{
						jmiModificarCliente = new JMenuItem();
						jMenu1.add(jmiModificarCliente);
						jmiModificarCliente.setText("Modificar");
					}
					{
						jmiBajaCliente = new JMenuItem();
						jMenu1.add(jmiBajaCliente);
						jmiBajaCliente.setText("Baja");
					}
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
}
