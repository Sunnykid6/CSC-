import java.util.NoSuchElementException;
public class PostfixTokenizer implements Tokenizer{
	
	private String[] tokens;
	private int currToken;
	
	/*
	Constructor
	Creates a new postfix order Tokenizer. Arithmetic operators are arranged in a postfix order.
	If all the non-operators and non-parens are valid operands, the result will be a valid postfix
	arithmetic expression, with only operands and operators, no parens.
	Input: infixTokens
	Throws: IllegalExpressionException
	*/
	public PostfixTokenizer(OperatorTokenizer infixToken) throws IllegalExpressionException{
		this.tokens = new String[infixToken.numTokens() - countBraces(infixToken)];
		this.currToken = 0;
		parse(infixToken);
	}
	
	private int countBraces(OperatorTokenizer input){
		int count = 0;
		String token;
		while(input.hasNext()){
			token = input.next();
			if(token.equals("(") || token.equals(")")){
				count++;
			}
		}
		return count;
	}
	
	private void parse(OperatorTokenizer input) throws IllegalExpressionException {
		input.reset();
		StringStack opStack = new StringStack();

		String token;
		int i = 0;
		while(input.hasNext()) {
			token = input.next();
			System.out.println(token);
			try {
				// If operand, add to next spot on tokens
				Double.parseDouble(token);
				tokens[i++] = token;
			} catch (NumberFormatException e) {
				if(token.equals("(")) { opStack.push(token); } // If '(', push to opStack
				else if(token.equals(")")) { // If ')', pop opStack onto tokens until '(' is removed
					while(!opStack.peek().equals("(")) {
						tokens[i++] = opStack.pop();
						if(opStack.isEmpty()) { throw new IllegalExpressionException(); } // Mismatched parentheses
					}
					opStack.pop();
				} else if(Operator.isOperator(token)) { // If operator, push onto opStack after popping any operators of equal or greater precedence to tokens
					while(!opStack.isEmpty() && Operator.isOperator(opStack.peek())) {
						if(Operator.comparePrecedence(token, opStack.peek()) >= 0) {
							tokens[i++] = opStack.pop();
						} else {
							break;
						}
					}
					opStack.push(token);
				} else {
					throw new IllegalExpressionException();
				}

			}
		}
		while(!opStack.isEmpty()) {
			if(!Operator.isOperator(opStack.peek())) { throw new IllegalExpressionException(); } // Mismatched parentheses
			tokens[i++] = opStack.pop();
		}

	
	}
	
	/*
	Sets the iterator start position to the first item in the list
	*/
	public void reset(){
		this.currToken = 0;
	}
	
	/*
	Returns the number of tokens
	Output: the number of tokens
	*/
	public int numTokens(){
		return this.tokens.length;
	}
	
	/*
	tokens on a single line delimited by a single space.
	Output: the formatted string.
	*/
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(String i: tokens){
			s.append(i +" ");
		}
		return s.substring(0, s.length());
	}
	
	public boolean hasNext(){
		return currToken != tokens.length;
	}
	
	public String next(){
		if(!this.hasNext()){
			throw new NoSuchElementException("No more tokens");
		}
		return tokens[currToken++];
	}
	
	public void remove(){
		throw new UnsupportedOperationException("Tokens may not be removed");
	}
	
	public static void main(String[] args){
		//OperatorTokenizer o1 = new OperatorTokenizer("(25-)*4-9*(3+2)");
		//PostfixTokenizer p1 = new PostfixTokenizer(o1);
		OperatorTokenizer o2 = new OperatorTokenizer("(25*4)-30+(20/2)*2");
		PostfixTokenizer p2 = new PostfixTokenizer(o2);
		System.out.println(p2);
	}
}