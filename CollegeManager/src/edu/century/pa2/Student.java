package edu.century.pa2;

import java.util.GregorianCalendar;

public class Student {
	private String studentId;
	private String firstName;
	private String lastName;
	private GregorianCalendar birthdate;
	private String email;
	private static int increaseId =0; 
	public Student() {
		this("Pink Ping", "01-01-2000");
	}
	public Student(String fullName, String birthdate){
		int studentid = 1000;
		studentid += increaseId;
		increaseId ++;
		this.studentId = "cs"+ String.format("%d",studentid);
		this.firstName = fullName.split(" ")[0];
		this.lastName = fullName.split(" ")[1];
		String[] mmddyy = birthdate.split("-");
		this.birthdate = new GregorianCalendar(Integer.parseInt(mmddyy[2]),
				Integer.parseInt(mmddyy[0]), Integer.parseInt(mmddyy[1]));
		this.email = this.studentId+"@ping.edu";
	}
	public String getStudentId() {
		return studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthdate() {
		return birthdate.getTime().toString();
	}
	public void setBirthdate(String birthdate) {
		String[] mmddyy = birthdate.split("-");
		this.birthdate = new GregorianCalendar(Integer.parseInt(mmddyy[2]),
				Integer.parseInt(mmddyy[0]), Integer.parseInt(mmddyy[1]));
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdate=" + getBirthdate() + ", email=" + email + "]";
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	public static void main(String[] args) {
		Student std = new Student();
		Student std2 = new Student("Ping Danddank", "12-14-1986");
		System.out.println(std);
		System.out.println(std2);
		Course cos = new Course();
		System.out.println(cos);
	}
	
}
