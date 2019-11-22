package com.parinherm.model
import groovy.transform.Canonical
import groovy.transform.ToString

@Canonical
class ComboBoxItem {
	String code
	String description
	
	
	
	String toString() {
		return description
	}
}
