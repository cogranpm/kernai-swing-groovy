package com.parinherm.ui

import com.parinherm.model.ComboBoxItem
import java.awt.Color
import java.awt.Component
import java.awt.Font
import javax.swing.Icon
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.ListCellRenderer
import javax.swing.plaf.basic.BasicComboBoxRenderer

class ComboListLabelProvider  extends JLabel implements ListCellRenderer{

	public ComboListLabelProvider() {
		super()
		setOpaque(false)
		
	}
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		//return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			
			
			setText((value as ComboBoxItem).description);
			
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(Color.WHITE)
				list.setForeground(list.getForeground());
			}

		
//			if(isSelected) setBackground(list.getSelectionForeground());
//			else setBackground(new Color(153, 204, 255));


			return this;
	}
/*	public Component getListCellRendererComponent(JList<? extends ComboBoxItem> list, ComboBoxItem value, int index,
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
	*/
}
