package com.parinherm.ui

import com.parinherm.model.ComboBoxItem

import java.awt.Component

import javax.swing.Icon
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.ListCellRenderer

class ComboListLabelProvider extends JLabel implements ListCellRenderer<ComboBoxItem> {

	public ComboListLabelProvider() {
		super()
		setOpaque(true)
		setHorizontalAlignment(CENTER)
		setVerticalAlignment(CENTER)
	}

	public ComboListLabelProvider(String text) {
		super(text)
		// TODO Auto-generated constructor stub
	}

	public ComboListLabelProvider(Icon image) {
		super(image)
		// TODO Auto-generated constructor stub
	}

	public ComboListLabelProvider(String text, int horizontalAlignment) {
		super(text, horizontalAlignment)
		// TODO Auto-generated constructor stub
	}

	public ComboListLabelProvider(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment)
		// TODO Auto-generated constructor stub
	}

	public ComboListLabelProvider(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment)
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends ComboBoxItem> list, ComboBoxItem value, int index,
			boolean isSelected, boolean cellHasFocus) {
			
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
		setText(value.description)
		return this;
	}
}
