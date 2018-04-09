package co.edu.javeriana.car.interpreter.operations.comparison;

import co.edu.javeriana.car.interpreter.ASTNode;
import co.edu.javeriana.car.interpreter.operations.logical.LogicalExpression;
import co.edu.javeriana.car.interpreter.operations.numeric.NumericExpression;
import co.edu.javeriana.car.interpreter.values.StringValue;

public class Equality extends Comparison {
	
	public Equality(ASTNode left, ASTNode right) {
		super(left, right);
	}

	@Override
	public Object execute() {
		if( left instanceof StringValue && right instanceof StringValue) {
			return ((String)left.execute()).equals((String)right.execute()); 
		}
		else if( left instanceof LogicalExpression && right instanceof LogicalExpression) {
			return (boolean)left.execute() == (boolean)right.execute(); 
		}
		else if( left instanceof NumericExpression && right instanceof NumericExpression) {
			return (float)left.execute() == (float)right.execute(); 
		}
		//TODO: Implement variables
		return false;
	}

}
