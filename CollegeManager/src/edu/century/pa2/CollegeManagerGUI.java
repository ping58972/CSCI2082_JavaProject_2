package edu.century.pa2;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.century.pa2.collections.CourseCollection;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.Font;

public class CollegeManagerGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	/*
		Course c1 = new Course();
		c1.setId(1001);
		Course c2 = new Course();
		c2.setId(1002);
		Course c3 = new Course();
		c3.setId(1003);
		Course c4 = new Course();
		c4.setId(1004);
		Course c5 = new Course();
		c5.setId(1005);
		Course c6 = new Course();
		c6.setId(1006);
		
		CourseCollection cc = new CourseCollection();
		cc.add(c1);
		cc.add(c2);
		cc.add(c3);
		cc.add(c4);
		//cc.addBefore(c3, c5);
		//cc.addAfter(c3, c6);
		CourseCollection cc2 = new CourseCollection();
		cc2.add(c5);
		cc2.add(c6);
//		cc2.addAll(cc);
//		Course[] cca = {c4, c5, c6};
//		cc.addMany(c4, c5, c6);
//		cc.addArray(cca);
		CourseCollection cc3 = CourseCollection.union(cc, cc2);
		System.out.println(cc3.remove(c4));
		System.out.println(cc3.toString());
		*/
		
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CollegeManagerGUI window = new CollegeManagerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public CollegeManagerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("College Manager");
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel studentPanel = new JPanel();
		frame.getContentPane().add(studentPanel, BorderLayout.WEST);
		studentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		studentPanel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		
		JLabel lblNewLabel = new JLabel(" Students Board");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_8.add(lblNewLabel);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		
		JLabel lblNewLabel_2 = new JLabel("Selection by");
		panel_9.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Last Name", "ID"}));
		panel_9.add(comboBox);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		
		textField = new JTextField();
		panel_10.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Select");
		panel_10.add(btnNewButton_3);
		
		
		JPanel panel_2 = new JPanel();
		studentPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea_1 = new JTextArea();
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		//Dimension dim = new Dimension(500, 50); 
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setHgap(35);
		studentPanel.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Edit Student List");
		panel_4.add(btnNewButton_1);
		//panel_4.setSize(1000,50);
		
		JPanel displaysPanel = new JPanel();
		frame.getContentPane().add(displaysPanel, BorderLayout.CENTER);
		displaysPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		displaysPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		displaysPanel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Display All");
		panel_1.add(btnNewButton);
		
		JPanel coursePanel = new JPanel();
		frame.getContentPane().add(coursePanel, BorderLayout.EAST);
		coursePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		coursePanel.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		
		JLabel lblNewLabel_1 = new JLabel("Courses Board");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_11.add(lblNewLabel_1);
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12);
		
		JLabel lblSelecctionBy = new JLabel("Selecction By");
		panel_12.add(lblSelecctionBy);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"NAME", "ID"}));
		comboBox_1.setToolTipText("");
		panel_12.add(comboBox_1);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		textField_1 = new JTextField();
		panel_13.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Register");
		panel_13.add(btnNewButton_4);
		
		JPanel panel_7 = new JPanel();
		coursePanel.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea_2 = new JTextArea();
		JScrollPane scrollPane_2 = new JScrollPane(textArea_2);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_7.add(scrollPane_2);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setHgap(60);
		coursePanel.add(panel_6, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Edit Course List");
		panel_6.add(btnNewButton_2);
		//Dimension panelSize = new Dimension();
	}

}
