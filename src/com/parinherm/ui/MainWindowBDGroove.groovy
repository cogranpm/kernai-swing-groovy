package com.parinherm.ui

import java.awt.EventQueue
import java.awt.event.WindowEvent

import groovy.transform.CompileStatic

@CompileStatic
class MainWindowBDGroove extends MainWindowBD {

	
	MainWindowBDGroove() {
		super()
		referenceItem.setStringTest("Hi a watha")
		
		/*btnToolSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(referenceItem.getStringTest());
			}
		});
		*/
		btnSave.addActionListener({ println referenceItem.getStringTest()})
		mnuFileQuit.addActionListener({ 
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING))
		})
	}
	
	/**
	 * Launch the application.
	 */
	static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowBDGroove window = new MainWindowBDGroove()
					window.frame.setVisible(true)
				} catch (Exception e) {
					e.printStackTrace()
				}
			}
		});
	}

}
