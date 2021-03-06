/**
 * CSC115 Assignment 3 : Fun With Binary Trees.
 * InvalidExpressionException.java.
 * Created for use by CSC115 Summer 2016
 */

/**
 * An exception thrown when an Arithmetic expression is determined to be invalid.
 */ 
public class InvalidExpressionException extends RuntimeException {

	/**
	 * Creates an exception.
	 * @param msg The message to the calling program.
	 */
	public InvalidExpressionException(String msg) {
		super(msg);
	}

	/**
	 * Creates an exception without a message.
	 */
	public InvalidExpressionException() {
		super();
	}
}
