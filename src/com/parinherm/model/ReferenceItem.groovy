package com.parinherm.model

import groovy.beans.Bindable
import groovy.transform.Canonical

@Canonical
class ReferenceItem {
	
	ReferenceItem() {
		
	}
	
	@Bindable String stringTest
	@Bindable String comboTest
	
	def item1 = new ComboBoxItem(code: "x", description: "xylophone")
	def item2 = new ComboBoxItem(code: "y", description: "Yellow")
	def item3 = new ComboBoxItem(code: "z", description:"Zenlikestate")
	
	def comboList = [item1, item2, item3]
}
