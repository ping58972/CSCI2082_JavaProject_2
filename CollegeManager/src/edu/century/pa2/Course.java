package edu.century.pa2;

public class Course implements Cloneable {
	private int id;
	private String subject;
	private int credits;
	private int courseNumber;
	private int courseSection;
	private String status;
	private String instructor;
	public Course() {
		this(100, "Java2018", 5, 1111, 2222, "Open", "Zaky");
	}
	public Course(int id, String subject, int credits, int courseNumber, int courseSection, String status,
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	public int getCourseSection() {
		return courseSection;
	}
	public void setCourseSection(int courseSection) {
		this.courseSection = courseSection;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", subject=" + subject + ", credits=" + credits + ", courseNumber=" + courseNumber
				+ ", courseSection=" + courseSection + ", status=" + status + ", instructor=" + instructor + "]";
	}

	@Override
	protected Course clone() {
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
