package com.parinherm.ui

import static javax.swing.JFrame.EXIT_ON_CLOSE

import java.awt.*

import com.parinherm.model.ReferenceItem

import groovy.swing.SwingBuilder



class MainWindow {
	
	def refItem = new ReferenceItem("Hello World")
	
	def buildWindow() {
		def swingBuilder = new SwingBuilder()
		swingBuilder.edt { 
			lookAndFeel 'nimbus'
			frame (title: "Kernai", size: [750, 750], show: true, defaultCloseOperation: EXIT_ON_CLOSE) {
				borderLayout(vgap: 5)
				
				panel(constraints: BorderLayout.CENTER,
					border: compoundBorder([emptyBorder(10), titledBorder('Enter data')])) {
					tableLayout {
						tr {
							td {
								label: 'String Test'
							}
							td {
								textField refItem.stringTest, id: 'StringTest', columns: 20
							}
						}
					}
				}
				
				panel(constraints: BorderLayout.SOUTH) {
					button text: 'Save', actionPerformed: {
						println refItem
					}
				}
				
				bean refItem,
					stringTest: bind { StringTest.text }
			}
		}
	}
	
	public static void main (String... args) {
		println "hello from groovy guys"
		def mainWin = new MainWindow().buildWindow()
	}
}
