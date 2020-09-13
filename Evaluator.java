import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Evaluator {

	String finalResult = null;
	
	@SuppressWarnings("unchecked")
	public void tokenizer(String expression) {
		final Set<String> operators = new HashSet<String>(Arrays.asList("(", ")", "+", "-", "/", "*"));
		String token = null;
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/()", true);
		EvaluatorStack operandStack = new EvaluatorStack();
		EvaluatorStack operatorStack = new EvaluatorStack();
		Object leftOperand = null;
		Object rightOperand = null;
		Object operator = null;
		Object result = null;
		
		
		
		
		while (tokenizer.hasMoreElements()) {
			
			token = tokenizer.nextToken();
			if (operators.contains(token) == false) {
				operandStack.push(token);
			} else if (token.equals("(")) {
				operatorStack.push(token);
			} else if (token.equals(")")) {
				while(operatorStack.stackElements[0].toString() != ")") {
					rightOperand = operandStack.pop();
					leftOperand = operandStack.pop();
					operator = operatorStack.pop();
					result = calculate(leftOperand, rightOperand, operator);
					operandStack.push(result);
				}
			} else if ((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/"))) {
				while (operatorStack.isEmpty() == false && precedenceCheck(operatorStack.stackElements[0]) >= precedenceCheck(token))   {
					rightOperand = operandStack.pop();
					leftOperand = operandStack.pop();
					result = calculate(leftOperand, rightOperand, token);
					operandStack.push(result);
				}
				operatorStack.push(token);
			}
			//while (operatorStack.isEmpty() == false) {
				//rightOperand = operandStack.pop();
				//leftOperand = operandStack.pop();
				//operator = operatorStack.pop();
				//result = calculate(leftOperand, rightOperand, operator);
				//operandStack.push(result);
			//}
			
			
		}
		
		while (operatorStack.isEmpty() == false) {
			rightOperand = operandStack.pop();
			leftOperand = operandStack.pop();
			operator = operatorStack.pop();
			result = calculate(leftOperand, rightOperand, operator);
			operandStack.push(result);
		}
		finalResult = operandStack.stackElements[0].toString();
		
		System.out.println("This is the operand stack");
		operandStack.displayStackElements();
		System.out.println("This is the operator stack");
		operatorStack.displayStackElements();
	}
	
	//Calculates left and right operands.
	//Also checks for divide by zero.
	public Object calculate(Object left, Object right, Object op) {
		int calculated = 0;
		int leftValue = (Integer) left;
		int rightValue = (Integer) right;
		if (op.toString() == "+") {
			calculated = leftValue + rightValue;
		} else if (op.toString() == "-") {
			calculated = leftValue - rightValue;
		} else if (op.toString() == "*") {
			calculated = leftValue * rightValue;
		} else if (op.toString() == "/" && rightValue != 0) {
			calculated = leftValue / rightValue;
		} else if (op.toString() == "/" && rightValue == 0) {
			System.out.println("Divided by zero");
		}	
		Integer calcObj = new Integer(calculated);
		return calcObj;
	}
	
	public int precedenceCheck(Object sign) {
		switch (sign.toString()) {
			case "+":
			case "-":
				return 0;
			case "*":
			case "/":
				return 1;
			default:
				throw new IllegalArgumentException("Operator unknown: " + sign.toString());
		}
	}
}
