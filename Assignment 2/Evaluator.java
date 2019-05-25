public class Evaluator{

	public Evaluator(){

	}
	
	public static double evaluate(String expression) throws IllegalExpressionException{
		PostfixTokenizer p = new PostfixTokenizer(new OperatorTokenizer(expression));
		StringStack s = new StringStack();
		String token;
		Double op1;
		Double op2;
		while(p.hasNext()){
			token = p.next();
			if(!Operator.isOperator(token)){
				s.push(token);
			}
			else{
				try{
					op2 = Double.parseDouble(s.pop());
					op1 = Double.parseDouble(s.pop());
				}
				catch(NumberFormatException e){
					throw new IllegalExpressionException("Invalid operands");
				}
				catch(StackException x){
					throw new IllegalExpressionException("Not enough operands");
				}
				s.push(Double.toString(Operator.evaluate(op1, op2, token)));
			}
		}
		double result = Double.parseDouble(s.pop());
		if(!s.isEmpty()){
			throw new IllegalExpressionException("Too many operands");
		}
		return result;
	}
	
	public static void main(String[] args){
		//System.out.println(evaluate("20+6*(4-8)*(3-2)+2"));
		System.out.println(evaluate("(25*4)-30+(20/2)*2"));
	}
}
		