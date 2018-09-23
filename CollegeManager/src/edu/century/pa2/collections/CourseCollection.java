package edu.century.pa2.collections;

import edu.century.pa2.*;

public class CourseCollection implements Cloneable {
	private int numberOfNodes;
	private CourseNode head;
	
	/*
	 * */
	public CourseCollection() {
		this.numberOfNodes = 0;
		this.head = null;
	}

	/*
	 * */
	public void add(Course element) {
		head = new CourseNode(element, head);
		numberOfNodes +=1;
	}
	
	/*
	 * */
	public void addAfter(Course currentElm, Course newElm) {
		for( CourseNode i=head; i!= null; i=i.getLink()) 
			if(i.getData()==currentElm) {
				i.setLink(new CourseNode(newElm,i.getLink()));
				numberOfNodes +=1;	
				return;
			}
	}
	
	/*
	 * */
	public void addBefore(Course currentElm, Course newElm) {
		for( CourseNode i=head; i!= null; i=i.getLink()) 
			if(i.getLink().getData()==currentElm) {
				i.setLink(new CourseNode(newElm,i.getLink()));
				numberOfNodes +=1;	
				return;
			}		
	}
	
	/*
	 * */
	public void addAll(CourseCollection addend) {
		if(addend.head == null) return;
		CourseNode tmp = head;
		while(tmp != null) {
			if(tmp.getLink() == null) {
				tmp.setLink(addend.head);
				this.numberOfNodes += addend.numberOfNodes;
				return;
			}
			tmp = tmp.getLink();
		}
		
	}
	
	/*
	 * */
	public void addMany(Course...courses) {
		for(Course tmp : courses) {
			this.add(tmp);
		}
	}
	
	/*
	 * */
	public void addArray(Course[] courses) {
		for(Course tmp : courses) {
			this.add(tmp);
		}
	}
	
	/*
	 * */
	public int countOccurrences(Course target) {
		return 0;
	}
	
	/*
	 * */
	public Course grab() {
		return null;
	}
	
	/*
	 * */
	public boolean remove(Course target) {
		return false;
	}
	
	/*
	 * */
	public int size() {
		return this.numberOfNodes;
	}
	
	/*
	 * */
	public static CourseCollection union(CourseCollection c1, CourseCollection c2) {
		CourseCollection union = new CourseCollection();
		union.head = c1.head;
		union.numberOfNodes = c1.numberOfNodes;
		union.addAll(c2);
		return union.clone();
	}

	/*
	 * */
	public boolean hasElement(Course course) {
		for(CourseNode i = head; i !=null; i=i.getLink()) 
			if(i.getData().equals(course))
				return true;
		 return false;
	}
	
	/*
	 * */
	public Course getCourseById(int id) {
		return null;
	}
	
	/*
	 * */
	public Course getCourseBySubject(String subject) {
		return null;
	}
	
	/*
	 * */
	public Course[] getArray() {
		return null;
	}
	
	/*
	 * */
	@Override
	public CourseCollection clone() {
		CourseCollection copy = null;
		try {
			copy = (CourseCollection)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return copy;
	}

	/*
	 * */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	/*
	 * */
	@Override
	public String toString() {
		String str="";
		int j=0;
		for (CourseNode i= head; i != null; i=i.getLink())
			str +=String.format("%d %s", j++,(i.getData().toString()+"\n")) ;
		return str;
	}
}
