package edu.century.pa2.collections;

/**public class CourseCollection from the package edu.century.pa2
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  CourseCollection.java, Programming Assignment 02.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 09/30/2018
 * */

import edu.century.pa2.*;

public class CourseCollection implements Cloneable {
	private int numberOfNodes;
	private CourseNode head;
	private CourseNode tail;
	
	/*
	 * Constructor for the CourseCollection
		public CourseCollection()
		Initialize an empty Collection.
		Postcondition:
			This Collection is empty.
	 * */
	public CourseCollection() {
		this.numberOfNodes = 0;
		this.head = null;
		this.tail =null;
	}

	/*
	 * add
		public void add(Course element)
		Add a new element to this Collection.
		Parameter:
			element – the new element that is being added
		Postcondition:
			A new copy of the element has been added to this Collection.
		Throws: OutOfMemoryError
			Indicates insufficient memory for adding a new element.
	 * */
	public void add(Course element) {
		
		head = new CourseNode(element, head);
		numberOfNodes ++;
		if(numberOfNodes ==1) {
			tail = head;
		}
	}
	
	/*
	 * addAfter and addBefore
		public void addAfter(Course currentElm, Course newElm)
		public void addBefore(Course currentElm, Course newElm)
			Adds a new element to this sequence either before or after the current element.
			Parameter:
				currentElm – the new element that is being added
				newElm - the new element that is being added
			Postcondition:
				A new copy of the element has been added to this sequence. If there was a current element,
				addAfter places the new element after the current element, and addBefore places the new
				element before the current element. If there was no current element, addAfter places the
				new element at the end of the sequence, and addBefore places the new element at the front
				of the sequence. The new element always becomes the new current element of the sequence.
			Throws: OutOfMemoryError
				Indicates insufficient memory for a new node.
	 * */
	public void addAfter(Course currentElm, Course newElm) {
		for( CourseNode i=head; i!= null; i=i.getLink()) 
			if(i.getData()==currentElm) {
				i.setLink(new CourseNode(newElm,i.getLink()));
				numberOfNodes +=1;	
				return;
			}
	}
	public void addBefore(Course currentElm, Course newElm) {
		for( CourseNode i=head; i!= null; i=i.getLink()) 
			if(i.getLink().getData()==currentElm) {
				i.setLink(new CourseNode(newElm,i.getLink()));
				numberOfNodes +=1;	
				return;
			}		
	}
	
	/*
	 * addAll
		public void addAll(CourseCollection addend)
		Place the contents of another sequence at the end of this sequence.
			Parameter:
				addend – a sequence whose contents will be placed at the end of this sequence
			Precondition:
				The parameter, addend, is not null.
			Postcondition:
				The elements from addend have been placed at the end of this sequence. The current element
				of this sequence remains where it was, and the addend is also unchanged.
			Throws: NullPointerException
				Indicates that addend is null.
			Throws: OutOfMemoryError
				Indicates insufficient memory to increase the size of the sequence.
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
	 * addMany
		public void addMany(int... elements)
			Add a variable number of new elements to this bag. If these new elements would take this bag
			beyond its current capacity, then the capacity is increased before adding the new elements.
		Parameter:
			elements – a variable number of new elements that are all being added
		Postcondition:
			New copies of all the elements have been added to this bag.
		Throws: OutOfMemoryError
			Indicates insufficient memory to increase the size of this bag.
	 * */
	public void addMany(Course...courses) {
		for(Course tmp : courses) {
			this.add(tmp);
		}
	}
	
	/*
	 * addMany
		public void addArray(Course[] courses)
			Add a variable number of new elements to this bag. If these new elements would take this bag
			beyond its current capacity, then the capacity is increased before adding the new elements.
		Parameter:
			courses – a array of new elements that are all being added
		Postcondition:
			New copies of all the elements have been added to this bag.
		Throws: OutOfMemoryError
			Indicates insufficient memory to increase the size of this bag.
	 * */
	public void addArray(Course[] courses) {
		for(Course tmp : courses) {
			this.add(tmp);
		}
	}
	
	/*
	 * countOccurrences
		public int countOccurrences(Course target)
			Accessor method to count the number of occurrences of a particular element in this bag.
		Parameter:
			target – the element that needs to be counted
		Returns:
			the number of times that target occurs in this bag
	 * */
	public int countOccurrences(Course target) {
		int answer=0;
		for (CourseNode i = head; i != null; i = i.getLink())
			if(i.getData().equals(target)) 
				answer ++;	
		return answer;
	}
	
	/*
	 * public Course grab()
		Accessor method to determine the current element of the sequence by random.
		Precondition:
		Returns:
			the current Course of the sequence by random.
		Throws: IllegalStateException
			Indicates that there is no current element.
	 * */
	public Course grab() {
		return getCourseByPosition((int)(Math.random()*numberOfNodes));
	}
	
	/*
	 * removeCurrent
		public boolean remove(Course target)
			Remove the target element from this sequence.
		Precondition:
			the target element is in this sequence
		Postcondition:
			The target element has been removed from the sequence, and the following element (if
			there is one) is now the new target element. If there was no following element, then there
			is now no target element.
		Throws: IllegalStateException
			Indicates that there is no target element, so remove target may not be called.
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
	
	/*size
	 * public int size( )
		Accessor method to determine the number of elements in this sequence.
		Returns:
			the number of elements in this sequence
	 * */
	public int size() {
		return this.numberOfNodes;
	}
	
	/*
	 * union
		public static CourseCollection union(CourseCollection c1, CourseCollection c2)
		Create a new sequence that contains all the elements from one sequence followed by another.
		Parameters:
			c1 – the first of two sequences
			c2 – the second of two sequences
		Precondition:
			Neither c1 nor c2 is null.
		Returns:
			a new sequence that has the elements of c1 followed by c2 (with no current element)
		Throws: IllegalArgumentException
			Indicates that one of the arguments is null.
		Throws: OutOfMemoryError
			Indicates insufficient memory for the new sequence.
	 * */
	public static CourseCollection union(CourseCollection c1, CourseCollection c2) {
		CourseCollection union = new CourseCollection();
		union.head = c1.head;
		union.numberOfNodes = c1.numberOfNodes;
		union.addAll(c2);
		return union.clone();
	}

	/*
	 * hasElement
		public boolean hasElement(Course course)
			Accessor method to determine whether this sequence has a specified current element that can
			be retrieved with the getCurrent method.
		Parameters:
			element – the  element that is test if in the Collection.
		Returns:
			true (there is a target element) or false (there is no target element at the moment)
	 * */
	public boolean hasElement(Course course) {
		if(course == null) return false;
		for(CourseNode i = head; i !=null; i=i.getLink()) 
			if(i.getData().equals(course))
				return true;
		 return false;
	}
	
	/*
	 * public Course getCourseByPosition(int index)
		Accessor method to determine the current element of the sequence.
		Parameters:
			index – the index of the sequence
		Precondition:
			index is not negative.
		Returns:
			the current Course of the sequence
		Throws: IllegalStateException
			Indicates that there is no current element.
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
	 * public Course getCourseById(int id)
		Accessor method to determine the current element of the sequence.
		Parameters:
			id – the index of the sequence
		Precondition:
			index is not negative.
		Returns:
			the current Course by id of the sequence
		Throws: IllegalStateException
			Indicates that there is no current element.
	 * */
	public Course getCourseById(int id) {
		for(CourseNode i = head; i !=null; i=i.getLink()) 
			if(i.getData().getId()== id)
				return i.getData();
		return null;
	}
	
	/*
	 * public Course getCourseBySubject(String subject)
		Accessor method to determine the current element of the sequence.
		Parameters:
			subject – the subject of the course in sequence
		Precondition:
			subject is not null.
		Returns:
			the current Course by subject of the sequence
		Throws: IllegalStateException
			Indicates that there is no current element.
	 * */
	public Course getCourseBySubject(String subject) {
		for(CourseNode i = head; i !=null; i=i.getLink()) 
			if(i.getData().getSubject().equals(subject))
				return i.getData();
		return null;
	}
	
	/*
	 * public Course[] getArray()
		Accessor method to determine the current element of the sequence.
		Parameters:
		Precondition:
		Returns:
			the all array Course from the sequence
		Throws: IllegalStateException
			Indicates that there is no current element.
		Throws: NullPointerException
			Indicates that addend is null.
		Throws: OutOfMemoryError
			Indicates insufficient memory to increase the size of the sequence.
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
		CourseCollection copy = new CourseCollection();
	
			for(CourseNode i = head; i !=null; i=i.getLink()) {
				copy.add(i.getData().clone());
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

	/* @Descriptions 
	 * 		To get info from Course collection.
	 * @Parameter 
	 * @Precondition
	 * @Return
	 * 		the Course collection values of instance object convert to String.
	 * @Thorws 		
	 * */
	@Override
	public String toString() {
		String str="";
		int j=1;
		for (CourseNode i= head; i != null; i=i.getLink())
			str += String.format("%d %s", j++,(i.getData().toString()+"\n")) ;
		if(str.equals("")) return "No Selected Course";
		return str;
	}
}
