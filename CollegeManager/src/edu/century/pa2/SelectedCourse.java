package edu.century.pa2;
/**public class SelectedCourse from the package edu.century.pa2
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  SelectedCourse.java, Programming Assignment 02.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 09/30/2018
 * */
import edu.century.pa2.collections.CourseCollection;
import edu.century.pa2.collections.StudentCollection;

public class SelectedCourse implements Cloneable{
	private Student selectedStudent;
	private CourseCollection selectedCourse;
	private CourseCollection unSelectedCourse;
	
	/* @Descriptions 
	 * 		Initialize and Constructor for the SelectedCourse class
	 * @Parameter
	 * 		student - a Student class that set the student to instance of object.
	 * 		courseCollection - the CourseCollection that initialize to instance of object 	
	 * @Precondition
	 * 		student cannot be empty or null.
	 * 		courseCollection cannot be empty or null.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates student and courseCollection are null.		
	 * */
	public SelectedCourse(Student student, CourseCollection courseCollection) {
		this.selectedStudent = student;
		this.unSelectedCourse = courseCollection;
		this.selectedCourse = new CourseCollection();
	}

	/* @Descriptions 
	 * 		To add course to selectedCourse.
	 * @Parameter
	 * 		course - a course class that set to selectedCourse
	 * @Precondition
	 * 		course is only course type to set the selectedCourse.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates course is null.
	 * */
	public void addCourseToSelection(Course course) {
		if(unSelectedCourse.hasElement(course)) {
			selectedCourse.add(course);
			unSelectedCourse.remove(course);
		}
	}
	
	/* @Descriptions 
	 * 		To remove course to selectedCourse.
	 * @Parameter
	 * 		course - a course class that remove to selectedCourse
	 * @Precondition
	 * 		course is only course type to remove the selectedCourse.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates course is null.
	 * */
	public void removeCourseToSelection(Course course) {
		if(selectedCourse.hasElement(course)) {
			selectedCourse.remove(course);
			unSelectedCourse.add(course);
		}
	}
	
	/* @Descriptions 
	 * 		To add course by subject to selectedCourse.
	 * @Parameter
	 * 		subject - a String subject that set to selectedCourse
	 * @Precondition
	 * 		that course is only course type to set the selectedCourse.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates subject is null.
	 * */
	public void addCouseBySubject(String subject) {
		Course cou =unSelectedCourse.getCourseBySubject(subject);
		if(unSelectedCourse.hasElement(cou)) {
			selectedCourse.add(cou);
			unSelectedCourse.remove(cou);
		}
	}
	
	/* @Descriptions 
	 * 		To add course by id to selectedCourse.
	 * @Parameter
	 * 		id - a integer that set to selectedCourse
	 * @Precondition
	 * 		that course is only course type to set the selectedCourse.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates subject and course is null.
	 * */
	public void addCouseById(int id) {
		Course cou =unSelectedCourse.getCourseById(id);
		if(unSelectedCourse.hasElement(cou)) {
			selectedCourse.add(cou);
			unSelectedCourse.remove(cou);
		}
	}
	
	/* @Descriptions 
	 * 		To remove course by subject to selectedCourse.
	 * @Parameter
	 * 		subject - a String that remove by subject to selectedCourse
	 * @Precondition
	 * 		course is only course type to remove the selectedCourse.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates subject and course is null.
	 * */
	public void removeCouseBySubject(String subject) {
		Course cou =selectedCourse.getCourseBySubject(subject);
		if(selectedCourse.hasElement(cou)) {
			unSelectedCourse.add(cou);
			selectedCourse.remove(cou);
		}
	}
	
	/* @Descriptions 
	 * 		To remove course by id to selectedCourse.
	 * @Parameter
	 * 		id - a integer that remove by id to selectedCourse
	 * @Precondition
	 * 		id is not negative to remove the selectedCourse.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates id is not negative.
	 * */
	public void removeCouseById(int id) {
		Course cou =selectedCourse.getCourseById(id);
		if(selectedCourse.hasElement(cou)) {
			unSelectedCourse.add(cou);
			selectedCourse.remove(cou);
		}
	}
	
	/* @Descriptions 
	 * 		to get Unselected Course To String from Course collection
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of Unselected Course To String.
	 * @Thorws 		
	 * */
	public String getUnselectCouseToString() {
		return "Unselected Course:\n" +unSelectedCourse.toString();
	}
	
	/* @Descriptions 
	 * 		to get selected Course To String from Course collection
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of selected Course To String.
	 * @Thorws 		
	 * */
	public String getSelectedCouseToString() {
		return "Selected Course:\n"+selectedCourse.toString();
	}
	
	/* @Descriptions 
	 * 		to get selected Student from Student collection
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of selected Student from Student collection
	 * @Thorws 		
	 * */
	public Student getselectedStudent() {
		return selectedStudent;
	}
	
	/* @Descriptions 
	 * 		to set selected Student to selectedStudent. 
	 * @Parameter
	 * 		selStd - a Student class that set the student to instance of object.
	 * @Precondition
	 * 		selStd cannot be empty or null.
	 * @Return
	 * @Thorws 	
	 * 		NullPointerException - Indicates course is null.	
	 * */
	public void setSelectedStudent(Student selStd) {
		this.selectedStudent = selStd.clone();
	}
	
	/* @Descriptions 
	 * 		to get selected Course from Course collection
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of selected Student from CourseCollection
	 * @Thorws 		
	 * */
	public CourseCollection getSelected() {
		return selectedCourse.clone();
	}
	
	/* @Descriptions 
	 * 		to set selected Student to CourseCollection. 
	 * @Parameter
	 * 		selected - a CourseCollection class that set the selected to instance of object.
	 * @Precondition
	 * 		selStd cannot be empty or null.
	 * @Return
	 * @Thorws 	
	 * 		NullPointerException - Indicates CourseCollection is null.	
	 * */
	public void setSelectedCourse(CourseCollection selected) {
		this.selectedCourse = selected.clone();
	}
	
	/* @Descriptions 
	 * 		to get Course from unSelectedCourse
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of course from unSelectedCourse
	 * @Thorws 		
	 * */
	public CourseCollection getUnSelectedCourse() {
		return unSelectedCourse.clone();
	}
	
	/* @Descriptions 
	 * 		to set unselected Student to CourseCollection. 
	 * @Parameter
	 * 		unselected - a CourseCollection class that set the selected to instance of object.
	 * @Precondition
	 * 		unSelect cannot be empty or null.
	 * @Return
	 * @Thorws 	
	 * 		NullPointerException - Indicates unSelect is null.	
	 * */
	public void setUnSelectedCourse(CourseCollection unSelect) {
		this.unSelectedCourse = unSelect.clone();
	}
	
	/* @Descriptions 
	 * 		To get info from Selected Course.
	 * @Parameter 
	 * @Precondition
	 * @Return
	 * 		the current values of instance object convert to String.
	 * @Thorws 		
	 * */
	@Override
	public String toString() {
		return "ID: "+selectedStudent.getStudentId()+"\tName: "+ selectedStudent.getFirstName()+" "
	+selectedStudent.getLastName() + "\nSelected Course:\n" + selectedCourse.toString() +"\n\n";
	}
	@Override
	public SelectedCourse clone(){
		SelectedCourse copy = null;
		try {
			copy = (SelectedCourse)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return copy;
	}
	@Override
	public boolean equals(Object obj) {
		SelectedCourse std = (SelectedCourse)obj;
		return (std.selectedStudent.equals(this.selectedStudent));
	}	

	
}
