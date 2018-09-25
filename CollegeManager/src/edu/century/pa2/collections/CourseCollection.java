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
		int answer=0;
		for (CourseNode i = head; i != null; i = i.getLink())
			if(i.getData().equals(target)) 
				answer ++;	
		return answer;
	}
	
	/*
	 * */
	public Course getCourseByPosition(int index) {
		CourseNode tmp = head;
		int i;
		if(index<0 || index > numberOfNodes)
			throw new IllegalArgumentException("The position is not availible!");
		for(i=0; (i<index)&& (tmp != null); i++)
			tmp = tmp.getLink();
		return tmp.getData();
	}
	
	/*
	 * */
	public Course grab() {
		return getCourseByPosition((int)(Math.random()*numberOfNodes));
	}
	
	/*
	 * */
	public boolean remove(Course target) {
		for(CourseNode i=head; i!=null; i=i.getLink()) {
			if(head.getData().equals(target)) {
				head = new CourseNode(head.getLink().getData(),head.getLink().getLink());
				numberOfNodes--;
				return true;
			}		
			if(i.getLink().getData().equals(target)) {
				i.setLink(i.getLink().getLink()); 
				numberOfNodes--;
				return true;
			}
		}
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
		for(CourseNode i = head; i !=null; i=i.getLink()) 
			if(i.getData().getId()== id)
				return i.getData();
		return null;
	}
	
	/*
	 * */
	public Course getCourseBySubject(String subject) {
		for(CourseNode i = head; i !=null; i=i.getLink()) 
			if(i.getData().getSubject()== subject)
				return i.getData();
		return null;
	}
	
	/*
	 * */
	public Course[] getArray() {
		Course [] array = new Course[numberOfNodes];
		for(CourseNode i = head; i !=null; i=i.getLink()) { 
			int j=0;
			array[j++] = i.getData().clone();
		}
		return array;
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
		CourseCollection tmp = (CourseCollection)obj;
		if(this.numberOfNodes != tmp.numberOfNodes)
		return false;
		for(CourseNode i = head; i !=null; i=i.getLink()) 
			if(tmp.hasElement(i.getData()))
				return true;
		return false;
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
