package com.parinherm.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

public class DataboundPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5172883663737792735L;
	private BindingGroup m_bindingGroup;
	private com.parinherm.model.ReferenceItem referenceItem = new com.parinherm.model.ReferenceItem();
	private JTextField stringTestJTextField;

	public DataboundPanel(com.parinherm.model.ReferenceItem newReferenceItem) {
		this();
		setReferenceItem(newReferenceItem);
	}

	public DataboundPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel stringTestLabel = new JLabel("StringTest:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(stringTestLabel, labelGbc_0);

		stringTestJTextField = new JTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(stringTestJTextField, componentGbc_0);

		if (referenceItem != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {
		BeanProperty<com.parinherm.model.ReferenceItem, java.lang.String> stringTestProperty = BeanProperty
				.create("stringTest");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty = BeanProperty.create("text");
		AutoBinding<com.parinherm.model.ReferenceItem, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, referenceItem, stringTestProperty,
						stringTestJTextField, textProperty);
		autoBinding.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		bindingGroup.addBinding(autoBinding);
		//
		return bindingGroup;
	}

	public com.parinherm.model.ReferenceItem getReferenceItem() {
		return referenceItem;
	}

	public void setReferenceItem(com.parinherm.model.ReferenceItem newReferenceItem) {
		setReferenceItem(newReferenceItem, true);
	}

	public void setReferenceItem(com.parinherm.model.ReferenceItem newReferenceItem, boolean update) {
		referenceItem = newReferenceItem;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (referenceItem != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

}
