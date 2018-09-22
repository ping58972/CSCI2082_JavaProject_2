package edu.century.pa2.collections;
import edu.century.pa2.Student;

public class StudentCollection implements Cloneable{
	private int numberOfItems;
	private Student[] items;
	
	/* Constructor for the StudentCollection
		public StudentCollection( )
		Initialize an empty Collection with an initial capacity of 10. Note that the add method works
		efficiently (without needing more memory) until this capacity is reached.
		Postcondition:
			This Collection is empty and has an initial capacity of 10.
		Throws: OutOfMemoryError
			Indicates insufficient memory for new Student[10].
	 * */
	public StudentCollection() {
		numberOfItems = 0;
		items = new Student[10];		
	}
	
	/*Second Constructor for the StudentCollection
		public StudentCollection(int initSize)
		Initialize an empty Collection with a specified initial capacity.
		Parameter:
			initSize – the initial capacity of this Collection
		Precondition:
			initSize is non-negative.
		Postcondition:
			This Collection is empty and has the specified initial capacity.
		Throws: IllegalArgumentException
			Indicates that initSize is negative.
		Throws: OutOfMemoryError
			Indicates insufficient memory for allocating the Collection.*/
	public StudentCollection(int initSize) {
		items = new Student[initSize];
		numberOfItems = 0;
	}
	
	/*add
		public void add(Student element)
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
	public void add(Student element) {
		if(numberOfItems == items.length) {
			ensureCapacity(numberOfItems *2 +1);
		}
		items[numberOfItems] = element;
		numberOfItems ++;
	}
	
	/*addAll
		public void addAll(StudentCollection addend)
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
	public void addAll(StudentCollection addend) {
		if(items.length <= (numberOfItems+ addend.numberOfItems)) {
			ensureCapacity(numberOfItems+ addend.numberOfItems);
		}
		System.arraycopy(addend.items, 0, items, numberOfItems, addend.items.length);
		numberOfItems += addend.numberOfItems;
	}
	
	/*addMany
		public void addMany(Student...students)
		Add a variable number of new elements to this Collection. If these new elements would take this Collection
		beyond its current capacity, then the capacity is increased before adding the new elements.
		Parameter:
			students – a variable number of new elements that are all being added
		Postcondition:
			New copies of all the elements have been added to this Collection.
		Throws: OutOfMemoryError
			Indicates insufficient memory for increasing the capacity.
		Note:
			Creating a Collection with capacity beyond Integer.MAX_VALUE causes arithmetic overflow.
	 * */
	public void addMany(Student...students) {
		if(items.length <= (numberOfItems+ students.length)) {
			ensureCapacity((numberOfItems+ students.length)*2);
		}
		System.arraycopy(students, 0, items, numberOfItems, students.length);
		numberOfItems += students.length;
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
		Student [] biggerArray = new Student[newSize];
		System.arraycopy(items, 0, biggerArray, 0, items.length);
		items = biggerArray;	
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
			Student[] copy = new Student[numberOfItems];
			System.arraycopy(this.items, 0, copy, 0, numberOfItems);
			this.items = copy;
		}
	}
	
	/*remove
		public boolean remove(Student target)
		Remove one copy of a specified element from this Collection.
		Parameter:
			target – the element to remove from this Collection
		Postcondition:
			If target was found in this Collection, then one copy of target has been removed and the method
			returns true. Otherwise, this Collection remains unchanged, and the method returns false.
	 * */
	public boolean remove(Student target) {
		for (int i = 0; i<items.length; i++)
			if(items[i] == target) {
				System.arraycopy(items, i+1, items, 0, (items.length -(i +1)));
				return true;
			} else return false;		
		return true;
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
	
	/*union
		public static StudentCollection union(StudentCollection stdc1, StudentCollection stdc2)
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
	 * */
	public static StudentCollection union(StudentCollection stdc1, StudentCollection stdc2) {
		StudentCollection union = new StudentCollection(stdc1.size()+stdc2.size());
		System.arraycopy(stdc1.items, 0, union.items, 0, stdc1.size());
		System.arraycopy(stdc2.items, 0, union.items, stdc1.size(), stdc2.size());
		union.numberOfItems = stdc1.size() + stdc2.size();
		return union;
	}
	
	/*countOccurrences
		public int countOccurrences(Student target)
		Accessor method to count the number of occurrences of a particular element in this collection.
		Parameter:
			target – the element that needs to be counted
		Returns:
			the number of times that target occurs in this collection
	 * */
	public int countOccurrence(Student target) {
		int answer = 0;
		for(Student std : items) {
			if(std.equals(target)) {
				answer++;
			}
		}
		return answer;
	}
	
	/*clone
		public IntArrayBag clone( )
		Generate a copy of this bag.
		Returns:
			The return value is a copy of this bag. Subsequent changes to the copy will not affect the
			original, nor vice versa. The return value must be typecast to an IntArrayBag before it is used.
		Throws: OutOfMemoryError
			Indicates insufficient memory for creating the clone.
	 * */
	@Override
	protected StudentCollection clone()  {
		StudentCollection copy = null;
		try {
			copy = (StudentCollection) super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		copy.items = items.clone();
		return copy;
	}
	
	/*if the size of collection dose not same, return false
	 * if each of students object dose not match return false
	 * otherwise return true. */
	@Override
	public boolean equals(Object obj) {
		StudentCollection std = (StudentCollection) obj;
		if(std.size() != this.size()) 
			return false;
		for(int i=0; i<this.size(); i++) 
			if(!(items[i].equals(std.items[i]))) 
				return false;	
		return true;
	}
	
	/**/
	public Student getStudentById(String id) {
		for(Student std : items) 
			if(std.getStudentId() == id)
				return std.clone();
		return null;
	}
	
	/**/
	public Student getStudentByLastName(String lname) {
		for(Student std : items) 
			if(std.getLastName() == lname)
				return std.clone();
		return null;
	}
	
	/**/
	public Student[] getAllStudent() {
		Student[] copy = new Student[this.size()];
			System.arraycopy(items, 0, copy, 0, this.size());
		return copy;
	}
	
	/*to transform to String.*/
	@Override
	public String toString() {
		String str = "";
		for(Student std : items)
			str += std.toString();
		return "the number of Student is: "+ this.numberOfItems +"\nList all of student:\n"+ str;
	}
	
}
