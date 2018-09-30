package edu.century.pa2;

import edu.century.pa2.collections.CourseCollection;
import edu.century.pa2.collections.StudentCollection;

public class SelectedCourse implements Cloneable{
	private Student selectedStudent;
	//private StudentCollection allStudents;
	private CourseCollection selectedCourse;
	private CourseCollection unSelectedCourse;
	
	public SelectedCourse(Student std, CourseCollection cc) {
		this.selectedStudent = std;
		this.unSelectedCourse = cc.clone();
		this.selectedCourse = new CourseCollection();
	}
//	public Student selectStudentByLname(String lname) {
//		return this.selectedStudent.getLastName();
//	}
//	public void setStudentById(String id) {
//		this.selectedStudent = allStudents.getStudentById(id);
//	}
	public void addCourseToSelection(Course cou) {
		if(unSelectedCourse.hasElement(cou)) {
			selectedCourse.add(cou);
			unSelectedCourse.remove(cou);
		}
	}
	public void removeCourseToSelection(Course cou) {
		if(selectedCourse.hasElement(cou)) {
			selectedCourse.remove(cou);
			unSelectedCourse.add(cou);
		}
	}
	public void addCouseBySubject(String sub) {
		Course cou =unSelectedCourse.getCourseBySubject(sub);
		if(unSelectedCourse.hasElement(cou)) {
			selectedCourse.add(cou);
			unSelectedCourse.remove(cou);
		}
	}
	public void addCouseById(int id) {
		Course cou =unSelectedCourse.getCourseById(id);
		if(unSelectedCourse.hasElement(cou)) {
			selectedCourse.add(cou);
			unSelectedCourse.remove(cou);
		}
	}
	public void removeCouseBySubject(String sub) {
		Course cou =selectedCourse.getCourseBySubject(sub);
		if(selectedCourse.hasElement(cou)) {
			unSelectedCourse.add(cou);
			selectedCourse.remove(cou);
		}
	}
	public void removeCouseById(int id) {
		Course cou =selectedCourse.getCourseById(id);
		if(selectedCourse.hasElement(cou)) {
			unSelectedCourse.add(cou);
			selectedCourse.remove(cou);
		}
	}
	public String getUnselectCouseToString() {
		return "Unselected Course:\n" +unSelectedCourse.toString();
	}
	public String getSelectedCouseToString() {
		return "Selected Course:\n"+selectedCourse.toString();
	}
	public Student getselectedStudent() {
		return selectedStudent;
	}
	public void setSelectedStudent(Student selStd) {
		this.selectedStudent = selStd.clone();
	}
	public CourseCollection getSelected() {
		return selectedCourse.clone();
	}
	public void setSelectedCourse(CourseCollection selected) {
		this.selectedCourse = selected.clone();
	}
	public CourseCollection getUnSelectedCourse() {
		return unSelectedCourse.clone();
	}
	public void setUnSelectedCourse(CourseCollection unSelect) {
		this.unSelectedCourse = unSelect.clone();
	}
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
