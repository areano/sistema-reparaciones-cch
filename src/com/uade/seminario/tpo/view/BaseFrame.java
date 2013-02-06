package com.uade.seminario.tpo.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JInternalFrame;

public abstract class BaseFrame extends JInternalFrame {

	public BaseFrame() {
		this("");
	}

	public BaseFrame(String title) {
		super("Alta Cliente",false,true,false,false);
		
		try {
			initGUI();
						
			setPreferredSize(new Dimension(400, 300));
			setBounds(new Rectangle(0, 0, 400, 300));
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract void initGUI();
}