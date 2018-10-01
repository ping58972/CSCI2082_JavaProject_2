package edu.century.pa2;
/**public class Course from the package edu.century.pa2
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  Course.java, Programming Assignment 02.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 09/30/2018
 * */
public class Course implements Cloneable {
	private int id;
	private String subject;
	private int credits;
	private int courseNumber;
	private int courseSection;
	private String status;
	private String instructor;
	
	public Course() {
		this(1000, "Java2018", 5, 1111, 2222, "Open", "Zaky");
	}
	
	public Course(int id, String subject, int credits, 
			int courseNumber, int courseSection, String status,
			String instructor) {
		super();
		this.id = id;
		this.subject = subject;
		this.credits = credits;
		this.courseNumber = courseNumber;
		this.courseSection = courseSection;
		this.status = status;
		this.instructor = instructor;
	}
	
	/* @Descriptions 
	 * 		Initialize and Constructor for the Course class
	 * @Parameter
	 * 		subject - a string that set the subject to instance of object
	 * 		instructor - the string that initialize to instance of object 	
	 * @Precondition
	 * 		subject cannot be empty or null.
	 * 		instructor cannot be empty or null.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates subject and instructor are null.		
	 * */
	public Course(String subject, String instructor) {
		super();
		this.id =( 1000+(int)(Math.random()*999 +1)%999);
		this.subject = subject;
		this.credits = (int)(Math.random()*5 +1);
		this.courseNumber = 100+(int)(Math.random()*99 +1)%99;
		this.courseSection = 10+(int)(Math.random()*9 +1)%9;
		this.status = "Open";
		this.instructor = instructor;
	}
	
	/* @Descriptions 
	 * 		to get Course Id 
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Course Id.
	 * @Thorws 		
	 * */
	public int getId() {
		return id;
	}
	
	/* @Descriptions 
	 * 		to get Subject from Course
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Course Subject.
	 * @Thorws 		
	 * */
	public String getSubject() {
		return subject;
	}
	
	/* @Descriptions 
	 * 		To set Subject to Course.
	 * @Parameter
	 * 		subject - a String subject that set to Course
	 * @Precondition
	 * 		subject is only string type to set the Course.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates subject is null.
	 * */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/* @Descriptions 
	 * 		to get credits from Course
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Course credits.
	 * @Thorws 		
	 * */
	public int getCredits() {
		return credits;
	}
	
	/* @Descriptions 
	 * 		To set credits to Course.
	 * @Parameter
	 * 		credits - integer that set to Course
	 * @Precondition
	 * 		credits is only integer type to set the Course.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates credits is not negative.
	 * */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	/* @Descriptions 
	 * 		to get courseNumber from Course
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Course courseNumber.
	 * @Thorws 		
	 * */
	public int getCourseNumber() {
		return courseNumber;
	}
	
	/* @Descriptions 
	 * 		To set courseNumber to Course.
	 * @Parameter
	 * 		courseNumber - integer that set to Course
	 * @Precondition
	 * 		courseNumber is only integer type to set the Course.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates courseNumber is not negative.
	 * */
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	/* @Descriptions 
	 * 		to get courseSection from Course
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Course courseSection.
	 * @Thorws 		
	 * */
	public int getCourseSection() {
		return courseSection;
	}
	
	/* @Descriptions 
	 * 		To set courseSection to Course.
	 * @Parameter
	 * 		courseSection - integer that set to Course
	 * @Precondition
	 * 		courseSection is only integer type to set the Course.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates courseSection is not negative.
	 * */
	public void setCourseSection(int courseSection) {
		this.courseSection = courseSection;
	}
	
	/* @Descriptions 
	 * 		to get status from Course
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Course status.
	 * @Thorws 		
	 * */
	public String getStatus() {
		return status;
	}
	
	/* @Descriptions 
	 * 		To set status to Course.
	 * @Parameter
	 * 		status - a String that set to Course
	 * @Precondition
	 * 		status is only string type to set the Course.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates status is null.
	 * */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/* @Descriptions 
	 * 		to get instructor from Course
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Course instructor.
	 * @Thorws 		
	 * */
	public String getInstructor() {
		return instructor;
	}
	
	/* @Descriptions 
	 * 		To set instructor to Course.
	 * @Parameter
	 * 		instructor - a String that set to Course
	 * @Precondition
	 * 		instructor is only string type to set the Course.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates instructor is null.
	 * */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/* @Descriptions 
	 * 		To get info from Course
	 * @Parameter 
	 * @Precondition
	 * @Return
	 * 		the current values of instance object convert to String.
	 * @Thorws 		
	 * */
	@Override
	public String toString() {
		return "ID=" + id + ", subject=" + subject + ", credits=" + credits + ", courseNumber=" + courseNumber
				+ ", courseSection=" + courseSection + ", status=" + status + ", instructor=" + instructor;
	}

	@Override
	public Course clone() {
		Course copy = null;
		try {
			copy = (Course)super.clone();
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return copy;
	}
	@Override
	public boolean equals(Object arg0) {
		Course cou = (Course) arg0;
		return (cou.id == this.id)&&
				(cou.courseNumber == this.courseNumber)&&
				(cou.courseSection == this.courseSection)&&
				cou.subject.equals(this.subject);
	}
	
}
