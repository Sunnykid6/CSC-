public class StringStack{
	
	private Node top;
	
	/*
	Constructor
	Initializes a stack that has no elements
	*/ 
	public StringStack(){
		this.top = null;
	}
	
	/*
	Checks to see if the stack is empty or not
	Output: True if stack is empty, else false
	*/
	public boolean isEmpty(){
		if(this.top == null){
			return true;
		}
		return false;
	}
	
	/*
	puts an element onto the top of the stack
	Input: the element see
	*/
	public void push (String s){
		this.top = new Node(s, this.top);
	}
	
	/*
	Removes the top element of the stack and returns item
	Output: top element
	Throws a Stack exception if the stack is empty
	*/
	public String pop() throws StackException{
		if(this.isEmpty()){
			throw new StackException();
		}
		Node temp = this.top;
		this.top = this.top.next;
		return temp.item;
	}
	
	/*
	Returns the top element of the stack
	Output: top element
	Throws a Stack exception if the stack is empty
	*/
	public String peek() throws StackException{
		if(this.isEmpty()){
			throw new StackException();
		}
		return this.top.item;
	}
	
	/*
	Empties all elements from the stack
	*/
	public void popAll(){
		this.top = null;
	}
}