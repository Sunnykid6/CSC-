/*
Name: Victor Sun
Student Number: V00894734
Project: Assignment 3 
*/


public class StackEmptyException extends RuntimeException{
	
	/*
	 * Creates an exception related to an action being unable to complete on a stack.
	 * @param msg Some information about the cause of the exception
	 */
	public StackEmptyException(String msg){
		super(msg);
	}
	/*
	 * Creates an exception related to an action being unable to complete on a stack.
	 */
	public StackEmptyException(){
		super();
	}
}