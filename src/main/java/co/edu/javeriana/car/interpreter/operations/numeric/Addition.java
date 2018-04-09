package co.edu.javeriana.car.interpreter.operations.numeric;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Addition extends NumericExpression {
	
	public Addition(ASTNode op1, ASTNode op2) {
		super(op1,op2);
	}

	@Override
	public Object execute() {
		return (float)op1.execute() + (float)op2.execute();
	}

}
