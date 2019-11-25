package com.parinherm.model
import groovy.transform.Canonical


@Canonical
class ComboBoxItem {
	String code
	String description
	
	
	//this is the easy way to have a combobox bound to this class
	String toString() {
		return description
	}
}
