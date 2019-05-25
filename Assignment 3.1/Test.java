/*
 * The shell of the class, to be completed as part of CSC115 Assignment 3 : Calculator.
 */

import java.util.regex.Pattern;
import java.util.Scanner;
import java.math.*;

import java.util.regex.Matcher;

public class Test{

	private TokenList postfixTokens;
	private TokenList infixTokens;

	public Test(String word) {
		if (Tools.isBalancedBy("()",word)) {
			tokenizeInfix(word);
			infixToPostfix();
		} else {
			throw new InvalidExpressionException("Parentheses unbalanced");
		}
	}

	/*
	 * A private helper method that tokenizes a string by separating out
	 * any arithmetic operators or parens from the rest of the string.
	 * It does no error checking.
	 * The method makes use of Java Pattern matching and Regular expressions to
	 * isolate the operators and parentheses.
	 * The operands are assumed to be the substrings delimited by the operators and parentheses.
	 * The result is captured in the infixToken list, where each token is 
	 * an operator, a paren or a operand.
	 * @param express The string that is assumed to be an arithmetic expression.
	 */
	private void tokenizeInfix(String express) {
		infixTokens  = new TokenList(express.length());

		// regular expression that looks for any operators or parentheses.
		Pattern opParenPattern = Pattern.compile("[-+*/^()]");
		Matcher opMatcher = opParenPattern.matcher(express);

		String matchedBit, nonMatchedBit;
		int lastNonMatchIndex = 0;
		String lastMatch = "";

		// find all occurrences of a matched substring
		while (opMatcher.find()) {
			matchedBit = opMatcher.group();
			// get the substring between matches
			nonMatchedBit = express.substring(lastNonMatchIndex, opMatcher.start());
			nonMatchedBit = nonMatchedBit.trim(); //removes outside whitespace
			// The very first '-' or a '-' that follows another operator is considered a negative sign
			if (matchedBit.charAt(0) == '-') {
				if (opMatcher.start() == 0 || 	
					!lastMatch.equals(")") && nonMatchedBit.equals("")) {
					continue;  // ignore this match
				}
			}
			// nonMatchedBit can be empty when an operator follows a ')'
			if (nonMatchedBit.length() != 0) {
				infixTokens.append(nonMatchedBit);
			}
			lastNonMatchIndex = opMatcher.end();
			infixTokens.append(matchedBit);
			lastMatch = matchedBit;
		}
		// parse the final substring after the last operator or paren:
		if (lastNonMatchIndex < express.length()) {
			nonMatchedBit = express.substring(lastNonMatchIndex,express.length());
			nonMatchedBit.trim();
			infixTokens.append(nonMatchedBit);
		}
	}

	/**
	 * Determines whether a single character string is an operator.
	 * The allowable operators are {+,-,*,/,^}.
	 * @param op The string in question.
	 * @return True if it is recognized as a an operator.
	 */
	public static boolean isOperator(String op) {
		switch(op) {
			case "+":
			case "-":
			case "/":
			case "*":
			case "^":
				return true;
			default:
				return false;
		}
	}

	private void infixToPostfix() {
		//String s = infixTokens.toString();
		String s = "";
		postfixTokens = new TokenList();
		StringStack stack = new StringStack();
		for(int i=0; i<infixTokens.size();i++){
			if(isOperator(infixTokens.get(i))){
				while(!stack.isEmpty()){
					if(stack.peek().equals("^")){
						postfixTokens.append(stack.pop());
					}else{
						break;
					}
				}
				stack.push(infixTokens.get(i));
			}else if(isOperator(infixTokens.get(i))){
				while(!stack.isEmpty()){
					if(stack.peek().equals("*")||stack.peek().equals("/")){
						postfixTokens.append(stack.pop());
					}else{
						break;
					}
				}
				stack.push(infixTokens.get(i));
			}else if(infixTokens.get(i).equals("(")){
				stack.push(infixTokens.get(i));
			}else if(infixTokens.get(i).equals(")")){
				while(!stack.isEmpty()){
					if(!stack.peek().equals("(")){
						postfixTokens.append(stack.pop());
					}else{
						stack.pop();
						break;
					}
				}
			}else{
				postfixTokens.append(infixTokens.get(i));
			}
		}
		while(!stack.isEmpty()){
			postfixTokens.append(stack.pop());
		}
		//System.out.println(postfixTokens);
		System.out.println(evaluate());
	}

	public String getInfixExpression() {
		return infixTokens.toString();
	}

	public String getPostfixExpression() {
		return postfixTokens.toString();
	}
		
	public double evaluate() {
		String s = postfixTokens.toString();
		StringStack stack = new StringStack();
		double result = 0;
		for(int i =0; i < postfixTokens.size(); i++){
			String tmpStr = postfixTokens.get(i);
			try {
				if(tmpStr.equals("+")){ 
					try {
						double first = Double.parseDouble(stack.pop());
						double second = Double.parseDouble(stack.pop());
						result = first + second;
						stack.push(Double.toString(result));
					} catch (StackEmptyException e) {
						System.out.println("Stack Empty");
					}
				}else if(tmpStr.equals("-")){
					
						try {
							double first = Double.parseDouble(stack.pop());
							double second = Double.parseDouble(stack.pop());
							result = second - first;
							stack.push(Double.toString(result));
						} catch (StackEmptyException e) {
							System.out.println("Stack Empty");
						}
					
				}else if(tmpStr.equals("*")){
					
						try {
							double first = Double.parseDouble(stack.pop());
							double second = Double.parseDouble(stack.pop());
							result = first * second;
							stack.push(Double.toString(result));
						} catch (StackEmptyException e) {
							System.out.println("Stack Empty");
						}
					
				}else if(tmpStr.equals("/")){
					
						try {
							double first = Double.parseDouble(stack.pop());
							double second = Double.parseDouble(stack.pop());
							result = second/first;
							stack.push(Double.toString(result));
						} catch (StackEmptyException e) {
							System.out.println("Stack Empty");
						}
				}else if(tmpStr.equals("^")){	
					try {
						double second = Double.parseDouble(stack.pop());
						double first = Double.parseDouble(stack.pop());
						result = Math.pow(first, second);
						stack.push(Double.toString(result));
					} catch (StackEmptyException e) {
						System.out.println("Stack Empty");
					}
				}else{//means not operation, push it to stack
					//System.out.println(tmpStr);
					stack.push(tmpStr);
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid Number Format");
			}
		}
		return result;
	}
						
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArithExpression ae = new ArithExpression(s.nextLine());
	}			
}