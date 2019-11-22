package com.parinherm.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jdesktop.beansbinding.AutoBinding;
import com.parinherm.model.ReferenceItem;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;


import com.parinherm.model.*;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainWindowBD {
	private AutoBinding<ReferenceItem, String, JTextField, String> BndStringTest;

	protected JFrame frame;
	protected JTextField txtStringTest;
	protected ReferenceItem referenceItem = new ReferenceItem();
	protected JToolBar toolBar;
	protected JButton btnSave;
	protected JMenuBar menuBar;
	protected JMenu mnuFile;
	protected JMenuItem mnuFileQuit;
	protected JLabel lblComboTest;
	protected JComboBox cboTest;
	protected JComboBox comboBox;


	/**
	 * Create the application.
	 */
	public MainWindowBD() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1169, 752);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		btnSave = new JButton("Save");
		toolBar.add(btnSave);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[right][grow,fill]", "[fill][100px:n][fill]"));
		
		JLabel lblStringTest = new JLabel("String Test:");
		lblStringTest.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblStringTest, "cell 0 0,grow");
		
		txtStringTest = new JTextField();
		panel.add(txtStringTest, "cell 1 0,grow");
		txtStringTest.setColumns(20);
		
		lblComboTest = new JLabel("Combo Test");
		panel.add(lblComboTest, "cell 0 1,alignx trailing,aligny bottom");
		
		cboTest = new JComboBox();
		panel.add(cboTest, "cell 1 1,growx");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"test", "now", "then"}));
		panel.add(comboBox, "cell 1 2,growx");
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnuFile = new JMenu("File");
		mnuFile.setMnemonic('f');
		menuBar.add(mnuFile);
		
		mnuFileQuit = new JMenuItem("Quit");
		mnuFileQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnuFile.add(mnuFileQuit);
		initDataBindings();
	}
	protected void initDataBindings() {
		BeanProperty<ReferenceItem, String> referenceItemBeanProperty = BeanProperty.create("stringTest");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		BndStringTest = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, referenceItem, referenceItemBeanProperty, txtStringTest, jTextFieldBeanProperty, "StringTest");
		BndStringTest.bind();
		//
		BeanProperty<ReferenceItem, String> referenceItemBeanProperty_1 = BeanProperty.create("comboTest");
		BeanProperty<JComboBox, Object> jComboBoxBeanProperty = BeanProperty.create("selectedItem");
		AutoBinding<ReferenceItem, String, JComboBox, Object> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, referenceItem, referenceItemBeanProperty_1, cboTest, jComboBoxBeanProperty, "bndCboTest");
		autoBinding.setConverter(new ComboTestConverter());
		autoBinding.bind();
	}
}
