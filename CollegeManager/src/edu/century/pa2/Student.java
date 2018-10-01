package edu.century.pa2;
/**public class Student from the package edu.century.pa2
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  Student.java, Programming Assignment 02.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 09/30/2018
 * */
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Student implements Cloneable{
	private String studentId;
	private String firstName;
	private String lastName;
	private GregorianCalendar birthdate;
	private String email;
	private static int increaseId =0; 
	public Student() {
		this("Pink Ping", "01-01-2000");
	}
	/* @Descriptions 
	 * 		Initialize and Constructor for the Student class
	 * @Parameter
	 * 		fullName - a string that set the name to instance of object
	 * 		birthdate - the string that initialize to instance of object 
	 * @Precondition
	 * 		fullName cannot be empty or null.
	 * 		birthdate cannot be empty or null.
	 * 		increaseId start with 1000 and increase with random.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates fullName and birthdate are null.		
	 * */
	public Student(String fullName, String birthdate){
		int studentid = ( 1000+(int)(Math.random()*999 +1)%999);
		studentid += increaseId;
		increaseId ++;
		this.studentId = "cs"+ String.format("%d",studentid);
		this.firstName = fullName.split(" ")[0];
		this.lastName = fullName.split(" ")[1];
		String[] mmddyy = birthdate.split("-");
		this.birthdate = new GregorianCalendar((Integer.parseInt(mmddyy[2])),
				(Integer.parseInt(mmddyy[0])-1), Integer.parseInt(mmddyy[1]));
		this.email = this.studentId+"@ping.edu";
	}
	
	/* @Descriptions 
	 * 		to get Student Id 
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Student Id.
	 * @Thorws 		
	 * */
	public String getStudentId() {
		return studentId;
	}
	
	/* @Descriptions 
	 * 		to get FirstName from Student
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Student FirstName.
	 * @Thorws 		
	 * */
	public String getFirstName() {
		return firstName;
	}
	
	/* @Descriptions 
	 * 		To set name to Student.
	 * @Parameter
	 * 		firstName - a String FirstName that set to Student
	 * @Precondition
	 * 		firstName is only string type to set the name.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates FirstName is null.
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/* @Descriptions 
	 * 		to get LastName from Student
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Student LastName.
	 * @Thorws 		
	 * */
	public String getLastName() {
		return lastName;
	}
	
	/* @Descriptions 
	 * 		To set name to Student.
	 * @Parameter
	 * 		lastName - a String LastName that set to Student
	 * @Precondition
	 * 		lastName is only string type to set the name.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates lastName is null.
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/* @Descriptions 
	 * 		to get Birthdate from Student
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Student Birthdate.
	 * @Thorws 		
	 * */
	public String getBirthdate() {
		return new SimpleDateFormat("MMM-dd-yyyy").format(birthdate.getTime());
	}
	
	/* @Descriptions 
	 * 		To set birthdate to Student.
	 * @Parameter
	 * 		birthdate - a String birthdate that set to Student
	 * @Precondition
	 * 		birthdate is only string type to set the birthdate.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates birthdate is null.
	 * */
	public void setBirthdate(String birthdate) {
		String[] mmddyy = birthdate.split("-");
		this.birthdate = new GregorianCalendar((Integer.parseInt(mmddyy[2])),
				(Integer.parseInt(mmddyy[0])-1), Integer.parseInt(mmddyy[1]));
	}
	
	/* @Descriptions 
	 * 		to get Email from Student
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Student Email.
	 * @Thorws 		
	 * */
	public String getEmail() {
		return email;
	}
		
	/* @Descriptions 
	 * 		To get info from Student
	 * @Parameter 
	 * @Precondition
	 * @Return
	 * 		the current values of instance object convert to String.
	 * @Thorws 		
	 * */
	@Override
	public String toString() {
		return "ID=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdate=" + getBirthdate() + ", email=" + email;
	}	
	
	@Override
	public Student clone(){
		Student copy = null;
		try {
			copy = (Student)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return copy;
	}
	@Override
	public boolean equals(Object obj) {
		Student std = (Student)obj;
		return (std.firstName.equalsIgnoreCase(this.firstName))&&
				(std.lastName.equalsIgnoreCase(this.lastName))&&
				//(std.studentId.equalsIgnoreCase(this.studentId))&&
				(std.birthdate.equals(this.birthdate));
	}	
}
