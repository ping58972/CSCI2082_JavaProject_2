package edu.century.pa2;

public class CourseNode {
	private Course data;
	private CourseNode link;
	
	/*
	 * Constructor for the CourseNode
		public IntNode(Course data, CourseNode link)
		Initialize a node with specified initial data and a link to the next node. Note
		that the initialLink may be the null reference, which indicates that the
		new node has nothing after it.
		Parameters:
			data – the initial data of this new node
			link – a reference to the node after this new node (the reference
					may be null to indicate that there is no node after this new node)
		Postcondition:
			This new node contains the specified data and a link to the next node.
	 * */
	public CourseNode(Course course, CourseNode link) {
		this.data = course;
		this.link = link;
	}
	
	/*
	 * getData
		public Course getData( )
		Accessor method to get the data from this node.
		Returns:
			the data from this node
	 * */
	public Course getData() {
		return data;
	}
	
	/*
	 * setData
		public void setData(Course data)
		Modification method to set the data in this node.
		Parameter:
			data – the new data to place in this node
		Postcondition:
			The data of this node has been set to newData.
	 * */
	public void setData(Course data) {
		this.data = data;
	}
	
	/*
	 * getLink
		public CourseNode getLink()
			Accessor method to get a reference to the next node after this node.
			Returns:
			a reference to the node after this node (or the null reference if there is
			nothing after this node)
	 * */
	public CourseNode getLink() {
		return link;
	}

	/*
	 * setLink
		public void setLink(CourseNode link)
		Modification method to set the reference to the next node after this node.
		Parameter:
			link – a reference to the node that should appear after this node in
					the linked list (or the null reference if there should be no node after
					this node)
		Postcondition:
			The link to the node after this node has been set to newLink. Any other
			node (that used to be in this link) is no longer connected to this node.
	 * */
	public void setLink(CourseNode link) {
		this.link = link;
	}

}
