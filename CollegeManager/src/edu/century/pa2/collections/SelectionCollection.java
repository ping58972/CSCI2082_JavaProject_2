package edu.century.pa2.collections;

/**public class SelectionCollection from the package edu.century.pa2
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  SelectionCollection.java, Programming Assignment 02.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 09/30/2018
 * */

import edu.century.pa2.SelectedCourse;
import edu.century.pa2.Student;

public class SelectionCollection implements Cloneable{
	private int numberOfItems;
	private SelectedCourse[] items;
	private SelectedCourse setSelectedStd;
	
	/* Constructor for the SelectionCollection
	public SelectionCollection( )
	Initialize an empty Collection with an initial capacity of 10. Note that the add method works
	efficiently (without needing more memory) until this capacity is reached.
	Postcondition:
		This Collection is empty and has an initial capacity of 10.
	Throws: OutOfMemoryError
		Indicates insufficient memory for new Student[10].
 * */
	public SelectionCollection() {
		numberOfItems = 0;
		items = new SelectedCourse[10];
	}
	
	/*Second Constructor for the SelectionCollection
	public SelectionCollection(StudentCollection stdAll, CourseCollection coAll )
	Initialize an empty Collection with a specified initial capacity.
	Parameter:
		 stdAll – the initial StudentCollection of this Collection
		 coAll -  the initial CourseCollection of this Collection
	Precondition:
		stdAll is non-null.
		coAll is non-null.
	Postcondition:
		This Collection is empty and has the specified initial capacity.
	Throws: IllegalArgumentException
		Indicates that initSize is negative.
	Throws: OutOfMemoryError
		Indicates insufficient memory for allocating the Collection.*/
	public SelectionCollection(StudentCollection stdAll, CourseCollection coAll ) {
		items = new SelectedCourse[stdAll.size()];
		numberOfItems = stdAll.size();
		for(int i=0; i<stdAll.size(); i++) {
			items[i] = new SelectedCourse(stdAll.getStudentByIndex(i), coAll.clone());
		}
	}
	
	/*update
	public void update(StudentCollection stdAll, CourseCollection coAll )
	update a new element to this collection. If this new element would take this collection beyond its current capacity,
	then the capacity is increased before adding the new element.
	Parameter:
		stdAll – the new element that is being added
		coAll – the new element that is being added
	Postcondition:
		A new copy of the element has been added to this collection.
	Throws: OutOfMemoryError
		Indicates insufficient memory for increasing the capacity.
	Note:
		Creating a collection with capacity beyond Integer.MAX_VALUE causes arithmetic overflow.
 * */
	public void update(StudentCollection stdAll, CourseCollection coAll ) {
		ensureCapacity(stdAll.size()+1);
		items[numberOfItems] = new SelectedCourse(stdAll.getStudentByIndex(stdAll.size()-1), coAll.clone());
		numberOfItems = stdAll.size();
	}
	
	/*add
	public void add(SelectedCourse element)
	Add a new element to this collection. If this new element would take this collection beyond its current capacity,
	then the capacity is increased before adding the new element.
	Parameter:
		element – the new element that is being added
	Postcondition:
		A new copy of the element has been added to this collection.
	Throws: OutOfMemoryError
		Indicates insufficient memory for increasing the capacity.
	Note:
		Creating a collection with capacity beyond Integer.MAX_VALUE causes arithmetic overflow.
 * */
	public void add(SelectedCourse element) {
		if(numberOfItems == items.length) {
			ensureCapacity(numberOfItems *2 +1);
		}
		items[numberOfItems] = element;
		numberOfItems ++;
	}
	
	/*ensureCapacity
	public void ensureCapacity(int newSize)
	Change the current capacity of this Collection.
	Parameter:
		newSize – the new capacity for this Collection
	Postcondition:
		This Collection’s capacity has been changed to at least newSize. If the capacity was already
		at or greater than newSize, then the capacity is left unchanged.
	Throws: OutOfMemoryError
		Indicates insufficient memory for new int[newSize].*/
	private void ensureCapacity(int newSize) {
		SelectedCourse [] biggerArray = new SelectedCourse[newSize];
		System.arraycopy(items, 0, biggerArray, 0, items.length);
		items = biggerArray;	
	}
	
	/*addAll
	public void addAll(SelectionCollection addend)
	Add the contents of another bag to this Collection.
	Parameter:
		addend – a Collection whose contents will be added to this Collection
	Precondition:
		The parameter, addend, is not null.
	Postcondition:
		The elements from addend have been added to this Collection.
	Throws: NullPointerException
		Indicates that addend is null.
	Throws: OutOfMemoryError
		Indicates insufficient memory to increase the size of this Collection.
	Note:
		Creating a Collection with capacity beyond Integer.MAX_VALUE causes arithmetic overflow.
  */
	public void addAll(SelectionCollection addend) {
	if(items.length <= (numberOfItems+ addend.numberOfItems)) {
		ensureCapacity(numberOfItems+ addend.numberOfItems);
	}
	System.arraycopy(addend.items, 0, items, numberOfItems, addend.items.length);
	numberOfItems += addend.numberOfItems;
}

	/*addMany
	public void addMany(SelectedCourse...students)
	Add a variable number of new elements to this Collection. If these new elements would take this Collection
	beyond its current capacity, then the capacity is increased before adding the new elements.
	Parameter:
		SelectedCourse – a variable number of new elements that are all being added
	Postcondition:
		New copies of all the elements have been added to this Collection.
	Throws: OutOfMemoryError
		Indicates insufficient memory for increasing the capacity.
	Note:
		Creating a Collection with capacity beyond Integer.MAX_VALUE causes arithmetic overflow.
 * */
	public void addMany(SelectedCourse...students) {
	if(items.length <= (numberOfItems+ students.length)) {
		ensureCapacity((numberOfItems+ students.length)*2);
	}
	System.arraycopy(students, 0, items, numberOfItems, students.length);
	numberOfItems += students.length;
	}
	/*getCapacity
		public int getCapacity( )
		Accessor method to determine the current capacity of this Collection. The add method works efficiently
		(without needing more memory) until this capacity is reached.
		Returns:
			the current capacity of this Collection
	 * */
	public int getCapacity() {
		return items.length;
	}
	
	/*trimToSize
		public void trimToSize( )
		Reduce the current capacity of this bag to its actual size (i.e., the number of elements it contains).
		Postcondition:
			This bag’s capacity has been changed to its current size.
		Throws: OutOfMemoryError
			Indicates insufficient memory for altering the capacity.
	 * */
	public void trimToSize() {
		if(items.length > numberOfItems) {
			SelectedCourse[] copy = new SelectedCourse[numberOfItems];
			System.arraycopy(this.items, 0, copy, 0, numberOfItems);
			this.items = copy;
		}
	}
	
	/*remove
		public boolean remove(SelectedCourse target)
		Remove one copy of a specified element from this Collection.
		Parameter:
			target – the element to remove from this Collection
		Postcondition:
			If target was found in this Collection, then one copy of target has been removed and the method
			returns true. Otherwise, this Collection remains unchanged, and the method returns false.
	 * */
	public boolean remove(SelectedCourse target) {
		for (int i = 0; i<items.length; i++)
			if(items[i] == target) {
				System.arraycopy(items, i+1, items, i, (items.length -(i +1)));
				return true;
			};		
		return false;
	}
	
	/*removeByStudent
	public boolean remove(SelectedCourse target)
	Remove one copy of a specified element from this Collection.
	Parameter:
		std – the element to remove from this Collection
	Postcondition:
		If target was found in this Collection, then one copy of target has been removed and the method
		returns true. Otherwise, this Collection remains unchanged, and the method returns false.
 * */
	public boolean removeByStudent(Student std) {
		for (int i = 0; i<items.length; i++)
			if(items[i].getselectedStudent().equals(std)) {
				System.arraycopy(items, i+1, items, i, (items.length -(i +1)));
				return true;
			};		
		return false;
	}
	/*size
		public int size( )
		Accessor method to determine the number of items in this Collection.
		Returns:
			the number of items in this Collection
	 * */
	public int size() {
		return this.numberOfItems;
	}
	
	/*	union
		public static SelectedCourseCollection union(SelectedCourseCollection stdc1, SelectedCourseCollection stdc2)
		Create a new Collection that contains all the elements from two other Collection.
		Parameters:
			stdc1 – the first of two Collection
			stdc2 – the second of two Collection
		Precondition:
			Neither stdc1 nor stdc2 is null.
			Returns:
				a new Collection that is the union of stdc1 and stdc2
		Throws: NullPointerException
			Indicates that one of the arguments is null.
		Throws: OutOfMemoryError
			Indicates insufficient memory for the new Collection.
		Note:
			Creating a Collection with capacity beyond Integer.MAX_VALUE causes arithmetic overflow.
	 * 
	public static SelectionCollection union(SelectionCollection stdc1, SelectionCollection stdc2) {
		SelectionCollection union = new SelectionCollection(stdc1.size()+stdc2.size());
		System.arraycopy(stdc1.items, 0, union.items, 0, stdc1.size());
		System.arraycopy(stdc2.items, 0, union.items, stdc1.size(), stdc2.size());
		union.numberOfItems = stdc1.size() + stdc2.size();
		return union;
	}*/
	
	/*countOccurrences
		public int countOccurrences(SelectedCourse target)
		Accessor method to count the number of occurrences of a particular element in this collection.
		Parameter:
			target – the element that needs to be counted
		Returns:
			the number of times that target occurs in this collection
	 * */
	public int countOccurrence(SelectedCourse target) {
		int answer = 0;
		for(SelectedCourse std : items) {
			if(std.equals(target)) {
				answer++;
			}
		}
		return answer;
	}
	
	/*clone
		protected SelectionCollection clone()
		Generate a copy of this bag.
		Returns:
			The return value is a copy of this bag. Subsequent changes to the copy will not affect the
			original, nor vice versa. The return value must be typecast to an IntArrayBag before it is used.
		Throws: OutOfMemoryError
			Indicates insufficient memory for creating the clone.
	 * */
	@Override
	protected SelectionCollection clone()  {
		SelectionCollection copy = null;
		try {
			copy = (SelectionCollection) super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		copy.items = items.clone();
		return copy;
	}
	
	/*if the size of collection dose not same, return false
	 * if each of Selections object dose not match return false
	 * otherwise return true. */
	@Override
	public boolean equals(Object obj) {
		SelectionCollection std = (SelectionCollection) obj;
		if(std.size() != this.size()) 
			return false;
		for(int i=0; i<this.size(); i++) 
			if(!(items[i].equals(std.items[i]))) 
				return false;	
		return true;
	}
	

	
	/**/
	public void setStudentById(String id) {
		for(int i =0; i< numberOfItems; i++) 
			if(items[i].getselectedStudent().getStudentId().equals(id))
				this.setSelectedStd= items[i].clone();
		
	}
	
	/**/
	public void setStudentByLastName(String lname) {
		for(int i =0; i< numberOfItems; i++) 
			if(items[i].getselectedStudent().getLastName().equals(lname))
				this.setSelectedStd =  items[i].clone();
		
	}
	public void setStudentByStudent(Student std) {
		for(int i =0; i< numberOfItems; i++) 
			if(items[i].getselectedStudent().equals(std))
				this.setSelectedStd =  items[i].clone();
		
	}
	/**/
	public SelectedCourse[] getAllSelectedCourse() {
		SelectedCourse[] copy = new SelectedCourse[this.size()];
			System.arraycopy(items, 0, copy, 0, this.size());
		return copy;
	}
	public SelectedCourse getselectedStd() {
		return this.setSelectedStd;
	}
	public Student getStudent() {
		return this.setSelectedStd.getselectedStudent();
	}
	
	/* @Descriptions 
	 * 		To get info from student collection.
	 * @Parameter 
	 * @Precondition
	 * @Return
	 * 		the student collection values of instance object convert to String.
	 * @Thorws 		
	 * */
	@Override
	public String toString() {
		String strs = "";
		for(int i=0; i<numberOfItems; i++) {
			strs += String.format("%d %s", i+1,items[i].toString()+"\n") ;
			}
		return  strs;
	}
	public boolean hasStudent(Student std) {
		for(int i =0; i< numberOfItems; i++ ) 
			if(items[i].getselectedStudent().equals(std))
				return true;
		return false;
	}
}
