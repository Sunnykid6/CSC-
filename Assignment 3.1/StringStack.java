/*
Name: Victor Sun
Student Number: V00894734
Project: Assignment 3 
*/

/*
 * The shell of the class, to be completed as part of the CSC115 Assignment 3 : Calculator.
 */

public class StringStack {

	private Node head;
	
	public StringStack(){
		this.head = null;
	}
	/*
	Checks to see if the stack is empty or not
	Returns true if it is
	Returns false if not
	*/
	public boolean isEmpty() {
		if(this.head == null){
			return true;
		}
		return false;
	}
	/*
	Removes the top element of the stack
	Returns the element removed
	Throws an exception if the stack is empty
	*/
	public String pop() throws StackEmptyException{
		if(this.isEmpty()){
			throw new StackEmptyException();
		}
		Node temp = this.head;
		this.head = this.head.next;
		return temp.item;
	}
	/*
	Returns the top element of the stack
	Throws an exception if the stack is empty
	*/
	public String peek() throws StackEmptyException{
		if(this.isEmpty()){
			throw new StackEmptyException("Stack is empty");
		}
		return this.head.item;
	}
	/*
	Puts an element onto the top of the stack
	param@ item - the element being put onto the stack
	*/
	public void push(String item) {
		this.head = new Node(item, this.head);
	}
	/*
	Empties the stack
	*/
	public void popAll() {
		this.head = null;
	}
	
	public static void main(String[] args){
		StringStack s = new StringStack();
		System.out.println(s.isEmpty());
		s.push("hello");
		s.push("how");
		s.push("are");
		s.push("you");
		System.out.println(s.isEmpty());
		/*
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.peek());
		*/
		s.popAll();
		
		System.out.println(s.peek());
	}
}
