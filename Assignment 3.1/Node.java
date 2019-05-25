/*
Name: Victor Sun
Student Number: V00894734
Project: Assignment 3 
*/

class Node{
	String item;
	Node next;
	/*
	 Constructor. Assigns the n to item, nextNode to next.
	 @param n        an object of type int is assigned to the instance variable item.
	 @param nextNode an Node object assigned to the instance object next
	*/ 
	Node(String item, Node next){
		this.item = item;
		this.next = next;
	}
	/*
	 Constructor. Assigns the n to item, null to next.
	 @param n an object of type int is assigned to the instance variable item.
	*/
	Node(String item){
		this(item, null);
	}
	/*
	 Default constructor. Sets the item and next to null.
	*/
	Node(){
		this(null);
	}
}