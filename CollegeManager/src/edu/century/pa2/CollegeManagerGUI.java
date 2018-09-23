package edu.century.pa2;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.century.pa2.collections.CourseCollection;

import java.awt.BorderLayout;

public class CollegeManagerGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
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
		//cc.addMany(c4, c5, c6);
//		cc.addArray(cca);
		CourseCollection cc3 = CourseCollection.union(cc, cc2);
		System.out.println(cc3.hasElement(c4));
		System.out.println(cc3.toString());
		
/*		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CollegeManagerGUI window = new CollegeManagerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
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
	}

}
