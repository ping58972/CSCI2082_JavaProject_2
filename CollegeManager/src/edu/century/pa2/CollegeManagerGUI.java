package edu.century.pa2;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.century.pa2.collections.CourseCollection;
import edu.century.pa2.collections.SelectionCollection;
import edu.century.pa2.collections.StudentCollection;

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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CollegeManagerGUI  implements ActionListener {

	private JFrame frame;
	private JFrame frameStd;
	private JFrame frameCo;
	private JTextField textField_2 = new JTextField();
	private JTextField textField_1;
	private JPanel studentPanel = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_8 = new JPanel();
	private JLabel lblNewLabel = new JLabel(" Students Board");
	private JPanel panel_9 = new JPanel();
	private JLabel lblNewLabel_2 = new JLabel("Selection by");
	private JComboBox comboBox = new JComboBox();	
	private JButton btnNewButton_3 = new JButton("Select");
	private JPanel panel_2 = new JPanel();
	private JTextArea textArea_1 = new JTextArea();
	private JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
	private JPanel panel_4 = new JPanel();
	private JButton btnNewButton_1 = new JButton("Edit Student List");
	private JPanel displaysPanel = new JPanel();	
	private JPanel panel = new JPanel();
	private JTextArea textArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(textArea);
	private JPanel panel_1 = new JPanel();
	private JButton btnNewButton = new JButton("Display All");
	private JPanel coursePanel = new JPanel();
	private JPanel panel_11 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JLabel lblNewLabel_1 = new JLabel("Courses Board");
	private JPanel panel_12 = new JPanel();
	private JLabel lblSelecctionBy = new JLabel("Selecction By");
	private JComboBox comboBox_1 = new JComboBox();
	private JPanel panel_13 = new JPanel();
	private JButton btnNewButton_4 = new JButton("Register");
	private JPanel panel_7 = new JPanel();
	private JTextArea textArea_2 = new JTextArea();
	private JScrollPane scrollPane_2 = new JScrollPane(textArea_2);
	private JPanel panel_6 = new JPanel();
	private JButton btnNewButton_2 = new JButton("Edit Course List");
	private JTextField tfStdFname = new JTextField();
	private JTextArea textAreaAddStd = new JTextArea("Student List:\n");	
	private JTextArea textAreaAddCo = new JTextArea("Course List:\n");
	private JTextField tfStdRm = new JTextField();
	private JTextField tfStdBD = new JTextField();
	private JTextField tfCo1 = new JTextField();
	private JTextField tfInstr = new JTextField();
	private JTextField tfCoRm = new JTextField();
	private JScrollPane scrollPane_std = new JScrollPane(textAreaAddStd);
	private JScrollPane scrollPane_co = new JScrollPane(textAreaAddCo);
	private JComboBox comboRmCo = new JComboBox(new DefaultComboBoxModel(new String[] {"Subject", "ID"}));
	private JComboBox comboRm = new JComboBox(new DefaultComboBoxModel(new String[] {"Last Name", "ID"}));
	private final JPanel panel_14 = new JPanel();
	private final JTextField textField = new JTextField();
	private final JButton btnNewButton_5 = new JButton("RemoveC");
	
	static StudentCollection studentAll; 
	static CourseCollection courseAll;
	static SelectionCollection selectionAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
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
		createStdCoClass();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textField.setColumns(10);
		textArea_2.setEditable(false);
		textArea.setEditable(false);
		textArea_1.setEditable(false);
		textField_2.setColumns(10);
		frame = new JFrame("College Manager");
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));		
		frame.getContentPane().add(studentPanel, BorderLayout.WEST);
		
		studentPanel.setLayout(new BorderLayout(0, 0));
		studentPanel.add(panel_3, BorderLayout.NORTH);
		
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));	
		panel_3.add(panel_8);
				
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_8.add(lblNewLabel);
				
		panel_3.add(panel_9);
				
		panel_9.add(lblNewLabel_2);
				
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Last Name", "ID"}));
		comboBox.addActionListener(this);
		panel_9.add(comboBox);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
				
		btnNewButton_3.addActionListener(this);
		
		panel_10.add(textField_2);
		panel_10.add(btnNewButton_3);
			
		studentPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
			
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setHgap(35);
		studentPanel.add(panel_4, BorderLayout.SOUTH);
		
		btnNewButton_1.addActionListener(this);
		panel_4.add(btnNewButton_1);
		
		frame.getContentPane().add(displaysPanel, BorderLayout.CENTER);
		displaysPanel.setLayout(new BorderLayout(0, 0));
				
		displaysPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
				
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		displaysPanel.add(panel_1, BorderLayout.SOUTH);
			
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
				
		frame.getContentPane().add(coursePanel, BorderLayout.EAST);
		coursePanel.setLayout(new BorderLayout(0, 0));
				
		coursePanel.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
				
		panel_5.add(panel_11);
				
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_11.add(lblNewLabel_1);
				
		panel_5.add(panel_12);
				
		panel_12.add(lblSelecctionBy);
				
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Subject", "ID"}));
		comboBox_1.addActionListener(this);
		panel_12.add(comboBox_1);
				
		panel_5.add(panel_13);
		
		textField_1 = new JTextField();
		panel_13.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.addActionListener(this);
		panel_13.add(btnNewButton_4);
		
		panel_5.add(panel_14);
		
		panel_14.add(textField);
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.addActionListener(this);
		panel_14.add(btnNewButton_5);
				
		coursePanel.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
				
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_7.add(scrollPane_2);
				
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setHgap(60);
		coursePanel.add(panel_6, BorderLayout.SOUTH);
				
		btnNewButton_2.addActionListener(this);
		panel_6.add(btnNewButton_2);
		
		
		//panel_7.add(scrollPane_std);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if(cmd.equals("Edit Student List")) {
			frameStd = new JFrame("Edit Student List");
			frameStd.setBounds(100, 100, 600, 200);
			frameStd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frameStd.getContentPane().setLayout(new BorderLayout(0, 0));
			JPanel panelInStd = new JPanel();
			JPanel panelInStd1 = new JPanel();
			JPanel panelInStd2 = new JPanel();
			JPanel panelInStd3 = new JPanel();
			JButton btnAdd = new JButton("Add Student");
			btnAdd.addActionListener(this);
			JLabel lbStdFname = new JLabel("Full Name:");
			
			tfStdFname.setColumns(10);
			JLabel lbStdBD = new JLabel("Birthday:");
			
			tfStdBD.setColumns(6);
			panelInStd1.add(btnAdd);
			panelInStd1.add(lbStdFname);
			panelInStd1.add(tfStdFname);
			panelInStd1.add(lbStdBD);
			panelInStd1.add(tfStdBD);			
			panelInStd.add(panelInStd1);
			
			JButton btnRemove = new JButton("Remove Student");
			btnRemove.addActionListener(this);
			JLabel lbremove = new JLabel("By:");
			
			comboRm.addActionListener(this);
			
			tfStdRm.setColumns(10);
			panelInStd2.add(btnRemove);
			panelInStd2.add(lbremove);
			panelInStd2.add(comboRm);
			panelInStd2.add(tfStdRm);
			panelInStd.add(panelInStd2);
			textAreaAddStd.append(studentAll.toString());
			scrollPane_std.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane_std.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			panelInStd3.setLayout(new BorderLayout(0,0));
			panelInStd3.add(scrollPane_std, BorderLayout.CENTER);
			panelInStd.add(panelInStd3);
			panelInStd.setLayout(new BoxLayout(panelInStd, BoxLayout.Y_AXIS)); 
			
			textAreaAddStd.setEditable(false);
			frameStd.getContentPane().add(panelInStd,BorderLayout.CENTER);
			frameStd.setVisible(true);
		}
		if(cmd.equals("Edit Course List")) {
			frameCo = new JFrame("Edit Course List");
			frameCo.setBounds(100, 100, 600, 200);
			frameCo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frameCo.getContentPane().setLayout(new BorderLayout(0, 0));
			JPanel panelInCo = new JPanel();
			JPanel panelInCo1 = new JPanel();
			JPanel panelInCo2 = new JPanel();
			JPanel panelInCo3 = new JPanel();
			JButton btnAddCo = new JButton("Add Course");
			btnAddCo.addActionListener(this);
			JLabel lbCoSj = new JLabel("Subject:");
			
			tfCo1.setColumns(10);
			JLabel lbInstr = new JLabel("Instructor:");
			
			tfInstr.setColumns(6);
			panelInCo1.add(btnAddCo);
			panelInCo1.add(lbCoSj);
			panelInCo1.add(tfCo1);
			panelInCo1.add(lbInstr);
			panelInCo1.add(tfInstr);			
			panelInCo.add(panelInCo1);
			
			JButton btnRemove = new JButton("Remove Course");
			btnRemove.addActionListener(this);
			JLabel lbremove = new JLabel("By:");
			
			comboRmCo.addActionListener(this);
			
			tfCoRm.setColumns(10);
			panelInCo2.add(btnRemove);
			panelInCo2.add(lbremove);
			panelInCo2.add(comboRmCo);
			panelInCo2.add(tfCoRm);
			panelInCo.add(panelInCo2);
			textAreaAddCo.append(courseAll.toString());
			scrollPane_co.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane_co.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			panelInCo3.setLayout(new BorderLayout(0,0));
			panelInCo3.add(scrollPane_co, BorderLayout.CENTER);
			panelInCo.add(panelInCo3);
			panelInCo.setLayout(new BoxLayout(panelInCo, BoxLayout.Y_AXIS)); 
		
			textAreaAddCo.setEditable(false);
			frameCo.getContentPane().add(panelInCo,BorderLayout.CENTER);
			frameCo.setVisible(true);
			
		}
		if(cmd.equals("Display All")) {
			textArea_1.setText("");
			textArea.setText("");
			textArea_2.setText("");
			textArea_1.append(studentAll.toString());
			String str = "";
			for(SelectedCourse selC : selectionAll.getAllSelectedCourse()) {
				
				str += selC.toString();
			}
			textArea.append(str);
			textArea_2.append(courseAll.toString());	
			btnNewButton_4.setEnabled(false);
			btnNewButton_5.setEnabled(false);
		}

		if(cmd.equals("Select")) {
			if(!(textField_2.getText().equals(""))) {
				if(comboBox.getSelectedItem().equals("Last Name")) {
					if(selectionAll.getselectedStd()!=null) {
					selectionAll.setStudentByLastName(textField_2.getText());
					
					textArea_1.setText("");
					textArea.setText("");
					textArea_2.setText("");
					textArea_1.append(selectionAll.getselectedStd().getselectedStudent().toString());
					textArea.append(selectionAll.getselectedStd().toString());
					textArea_2.append(selectionAll.getselectedStd().getUnselectCouseToString());
					btnNewButton_4.setEnabled(true);
					btnNewButton_5.setEnabled(true);
					}
				}
				if(comboBox.getSelectedItem().equals("ID")) {
					if(selectionAll.getselectedStd()!=null) {
					selectionAll.setStudentById(textField_2.getText());
					
					textArea_1.setText("");
					textArea.setText("");
					textArea_2.setText("");
					textArea_1.append(selectionAll.getselectedStd().getselectedStudent().toString());
					textArea.append(selectionAll.getselectedStd().toString());
					textArea_2.append(selectionAll.getselectedStd().getUnselectCouseToString());
					btnNewButton_4.setEnabled(true);
					btnNewButton_5.setEnabled(true);
					}
				}
				
			}
			
		}
		if(cmd.equals("Register")) {
			if(comboBox_1.getSelectedItem().equals("Subject")) {
				if(selectionAll.getselectedStd()!=null) {
				selectionAll.getselectedStd().addCouseBySubject(textField_1.getText());
				
					textArea_1.setText("");
					textArea.setText("");
					textArea_2.setText("");
					textArea_1.append(selectionAll.getselectedStd().getselectedStudent().toString());
					textArea.append(selectionAll.getselectedStd().toString());
					textArea_2.append(selectionAll.getselectedStd().getUnselectCouseToString());
					}
			}
			if(comboBox_1.getSelectedItem().equals("ID")) {
				if(selectionAll.getselectedStd()!=null) {
				selectionAll.getselectedStd().addCouseById(Integer.parseInt(textField_1.getText()));
				
					textArea_1.setText("");
					textArea.setText("");
					textArea_2.setText("");
					textArea_1.append(selectionAll.getselectedStd().getselectedStudent().toString());
					textArea.append(selectionAll.getselectedStd().toString());
					textArea_2.append(selectionAll.getselectedStd().getUnselectCouseToString());
					}
			}
		}
		if(cmd.equals("Add Student")) {
			Student std = new Student(tfStdFname.getText(),tfStdBD.getText());
			studentAll.add(std);
			textAreaAddStd.setText("Student List:\n");
			textAreaAddStd.append(studentAll.toString());
			
			textArea_1.setText("");
			textArea.setText("");
			textArea_2.setText("");
			textArea_1.append(studentAll.toString());
			String str = "";
			for(SelectedCourse selC : selectionAll.getAllSelectedCourse()) {
				
				str += selC.toString();
			}
			textArea.append(str);
			textArea_2.append(courseAll.toString());
		
		}
		if(cmd.equals("Remove Student")) {
			if(comboRm.getSelectedItem().equals("Last Name")) {
				studentAll.remove(studentAll.getStudentByLastName(tfStdRm.getText()));
				
				textAreaAddStd.setText("Student List:\n");
				textAreaAddStd.append(studentAll.toString());
				textArea_1.setText("");
				textArea.setText("");
				textArea_2.setText("");
				textArea_1.append(studentAll.toString());
				String str = "";
				for(SelectedCourse selC : selectionAll.getAllSelectedCourse()) {
					
					str += selC.toString();
				}
				textArea.append(str);
				textArea_2.append(courseAll.toString());
				
			}
			if(comboRm.getSelectedItem().equals("ID")) {
				studentAll.remove(studentAll.getStudentById(tfStdRm.getText()));
				
				textAreaAddStd.setText("Student List:\n");
				textAreaAddStd.append(studentAll.toString());
				
				
				textArea_1.setText("");
				textArea.setText("");
				textArea_2.setText("");
				textArea_1.append(studentAll.toString());
				String str = "";
				for(SelectedCourse selC : selectionAll.getAllSelectedCourse()) {
					
					str += selC.toString();
				}
				textArea.append(str);
				textArea_2.append(courseAll.toString());
			}
			
			
		
		}
		if(cmd.equals("Add Course")) {
			
			Course co = new Course(tfCo1.getText(), tfInstr.getText());
			courseAll.add(co);
			textAreaAddCo.setText("Course List:\n");
			textAreaAddCo.append(courseAll.toString());
			
			textArea_1.setText("");
			textArea.setText("");
			textArea_2.setText("");
			textArea_1.append(studentAll.toString());
			String str = "";
			for(SelectedCourse selC : selectionAll.getAllSelectedCourse()) {
				
				str += selC.toString();
			}
			textArea.append(str);
			textArea_2.append(courseAll.toString());
		
		}
		if(cmd.equals("Remove Course")) {
			if(comboRmCo.getSelectedItem().equals("Subject")) {
				courseAll.remove(courseAll.getCourseBySubject(tfCoRm.getText()));
				
				textAreaAddCo.setText("Student List:\n");
				textAreaAddCo.append(studentAll.toString());
				textArea_1.setText("");
				textArea.setText("");
				textArea_2.setText("");
				textArea_1.append(studentAll.toString());
				String str = "";
				for(SelectedCourse selC : selectionAll.getAllSelectedCourse()) {
					
					str += selC.toString();
				}
				textArea.append(str);
				textArea_2.append(courseAll.toString());
				
			}
			if(comboRmCo.getSelectedItem().equals("ID")) {
				courseAll.remove(courseAll.getCourseById(Integer.parseInt(tfCoRm.getText())));
				
				textAreaAddCo.setText("Student List:\n");
				textAreaAddCo.append(studentAll.toString());
				
				
				textArea_1.setText("");
				textArea.setText("");
				textArea_2.setText("");
				textArea_1.append(studentAll.toString());
				String str = "";
				for(SelectedCourse selC : selectionAll.getAllSelectedCourse()) {
					
					str += selC.toString();
				}
				textArea.append(str);
				textArea_2.append(courseAll.toString());
			}
			textAreaAddCo.setText("Course List:\n");
			textAreaAddCo.append(courseAll.toString());
		
		}
		if(cmd.equals("RemoveC")) {
			if(comboBox_1.getSelectedItem().equals("Subject")) {
				if(selectionAll.getselectedStd()!=null) {
				selectionAll.getselectedStd().removeCouseBySubject(textField.getText());
				
					textArea_1.setText("");
					textArea.setText("");
					textArea_2.setText("");
					textArea_1.append(selectionAll.getselectedStd().getselectedStudent().toString());
					textArea.append(selectionAll.getselectedStd().toString());
					textArea_2.append(selectionAll.getselectedStd().getUnselectCouseToString());
					}
			}
			if(comboBox_1.getSelectedItem().equals("ID")) {
				if(selectionAll.getselectedStd()!=null) {
				selectionAll.getselectedStd().removeCouseById(Integer.parseInt(textField.getText()));
				
					textArea_1.setText("");
					textArea.setText("");
					textArea_2.setText("");
					textArea_1.append(selectionAll.getselectedStd().getselectedStudent().toString());
					textArea.append(selectionAll.getselectedStd().toString());
					textArea_2.append(selectionAll.getselectedStd().getUnselectCouseToString());
					}
			}
		
		}
		
	}

	public void createStdCoClass() {
		
		Course j1 = new Course("Java2011", "Zak1");
		Course j2 = new Course("Java2012", "Zak2");
		Course j3 = new Course("Java2013", "Zak3");
		Course j4 = new Course("Java2013", "Zak4");
		Course j5 = new Course("Java2015", "Zak5");
		Course j6 = new Course("Java2016", "Zak6");
		Course j7 = new Course("Java2017", "Zak7");
		Course j8 = new Course("Java2018", "Zak8");
		Course c1 = new Course("C++2011", "Peterman1");
		Course c2 = new Course("C++2012", "Peterman2");
		Course c3 = new Course("C++2013", "Peterman3");
		Course c4 = new Course("C++2014", "Peterman4");
		Course c5 = new Course("C++2015", "Peterman5");
		Course c6 = new Course("C++2016", "Peterman6");
		Course c7 = new Course("C++2017", "Peterman7");
		Course c8 = new Course("C++2018", "Peterman8");
		
		CourseCollection jj = new CourseCollection();
		CourseCollection cc = new CourseCollection();
		Course[] jjArray = {j3, j4, j5};
		jj.add(j1); jj.add(j2); jj.addArray(jjArray);
		jj.add(j6); jj.addBefore(j4,j7); jj.add(j8);
		cc.add(c1); cc.add(c2); cc.addMany(c3, c4, c5);
		cc.add(c6); cc.add(c7); cc.addAfter(c5, c8);
		
		courseAll = CourseCollection.union(cc, jj);
		
		
		Student s1 = new Student("Pink Ping1", "01-01-2001");
		Student s2 = new Student("Pink Ping2", "02-02-2002");
		Student s3 = new Student("Pink Ping3", "03-03-2001");
		Student s4 = new Student("Pink Ping4", "04-04-2001");
		Student s5 = new Student("Pink Ping5", "05-06-2001");
		Student s6 = new Student("Pink Ping6", "06-01-2001");
		Student s7 = new Student("Pink Ping7", "01-07-2001");
		Student s8 = new Student("Pink Ping8", "08-06-2001");
		Student s9 = new Student("Pink Ping9", "09-03-2001");
		Student s10 = new Student("Pink Ping10", "10-01-2001");
		Student s11 = new Student("Pink Ping11", "10-11-2001");
		
		studentAll = new StudentCollection();
		studentAll.add(s1); studentAll.add(s2);
		studentAll.addMany(s3, s4, s5, s6, s7, s8, s9, s10, s11);
		studentAll.remove(s5);
		//System.out.println(studentAll.toString());

		//SelectedCourse sc1 = new SelectedCourse(studentAll, courseAll);
		selectionAll = new SelectionCollection(studentAll, courseAll);
		selectionAll.setStudentByLastName("Ping3");
	
		selectionAll.getselectedStd().addCouseBySubject("Java2011");
		selectionAll.getselectedStd().addCourseToSelection(c2);
		selectionAll.getselectedStd().addCourseToSelection(c3);
		selectionAll.getselectedStd().addCourseToSelection(c4);
		selectionAll.getselectedStd().addCourseToSelection(c5);
		selectionAll.getselectedStd().removeCourseToSelection(c3);
		//System.out.println(selectionAll.getselectedStd().toString());
		//System.out.println("UnselectionCo:\n"+selectionAll.getselectedStd().getUnselectCouseToString().toString());
		//selectionAll = new SelectionCollection(studentAll, courseAll);
		selectionAll.setStudentByLastName("Ping4");
		//System.out.println(selectionAll.getStudent().toString());
		selectionAll.getselectedStd().addCouseBySubject("Java2011");
		selectionAll.getselectedStd().addCourseToSelection(c2);
		selectionAll.getselectedStd().addCourseToSelection(c3);
		selectionAll.getselectedStd().addCourseToSelection(c4);
		//selectionAll.getselectedStd().addCourseToSelection(c5);
		selectionAll.getselectedStd().removeCourseToSelection(c2);
		//System.out.println(selectionAll.getselectedStd().toString());
		//System.out.println("UnselectionCo:\n"+selectionAll.getselectedStd().getUnselectCouseToString().toString());
	
	}


}
