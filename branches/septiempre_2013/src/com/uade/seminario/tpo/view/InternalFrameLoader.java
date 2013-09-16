package com.uade.seminario.tpo.view;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;

public class InternalFrameLoader {

	private static InternalFrameLoader instance=null;
	private InternalFrameLoader(){
		
	}
	public static InternalFrameLoader getInstance(){
		if (instance == null) instance = new InternalFrameLoader();
		return instance;
	}
	
	public void loadFrame(JDesktopPane jdEscritorio,javax.swing.JInternalFrame frame ){
		frame.setVisible(true);
		frame.setClosable(true);
		jdEscritorio.add(frame);
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
}
