package edu.century.pa2;

public class CourseNode {
	private Course data;
	private CourseNode link;
	
	public CourseNode(Course course) {
		this.data = course;
		this.link = null;
	}

	public Course getData() {
		return data;
	}

	public void setData(Course data) {
		this.data = data;
	}

	public CourseNode getLink() {
		return link;
	}

	public void setLink(CourseNode link) {
		this.link = link;
	}

}
