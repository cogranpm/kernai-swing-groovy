package com.parinherm.ui

import java.awt.Component
import java.awt.EventQueue
import java.awt.event.WindowEvent

import javax.swing.DefaultComboBoxModel
import javax.swing.DefaultListCellRenderer
import javax.swing.JList

import com.parinherm.model.ComboBoxItem
import groovy.transform.CompileStatic

@CompileStatic
class MainWindowBDGroove extends MainWindowBD {

	
	MainWindowBDGroove() {
		super()
		referenceItem.setStringTest("Hi a watha")
		cboTest.setModel(new DefaultComboBoxModel(referenceItem.comboList as ComboBoxItem[]))
		cboTest.setRenderer(new ComboListLabelProvider())
		
		/*
		cboTest.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// TODO Auto-generated method stub
				setText((value as ComboBoxItem).description)
				return this
			}
				
			})
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
