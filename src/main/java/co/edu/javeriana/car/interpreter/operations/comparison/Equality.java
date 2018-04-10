package co.edu.javeriana.car.interpreter.operations.comparison;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;
import co.edu.javeriana.car.interpreter.operations.logical.LogicalExpression;
import co.edu.javeriana.car.interpreter.operations.numeric.NumericExpression;
import co.edu.javeriana.car.interpreter.values.StringValue;

public class Equality extends Comparison {
	
	public Equality(ASTNode left, ASTNode right) {
		super(left, right);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if( left instanceof StringValue && right instanceof StringValue) {
			return ((String)left.execute(symbolTable)).equals((String)right.execute(symbolTable)); 
		}
		else if( left instanceof LogicalExpression && right instanceof LogicalExpression) {
			return (boolean)left.execute(symbolTable) == (boolean)right.execute(symbolTable); 
		}
		else if( left instanceof NumericExpression && right instanceof NumericExpression) {
			return (float)left.execute(symbolTable) == (float)right.execute(symbolTable); 
		}
		return false;
	}

}
