package com.parinherm.model

import org.jdesktop.beansbinding.Converter

class ComboTestConverter extends Converter {

	@Override
	public Object convertForward(Object arg0) {
		return "Hi there"
	}

	@Override
	public Object convertReverse(Object arg0) {
		return (arg0 as ComboBoxItem).code
	}
}
