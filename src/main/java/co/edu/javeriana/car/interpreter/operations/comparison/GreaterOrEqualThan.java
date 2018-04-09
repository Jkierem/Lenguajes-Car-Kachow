package co.edu.javeriana.car.interpreter.operations.comparison;

import co.edu.javeriana.car.interpreter.ASTNode;

public class GreaterOrEqualThan extends Comparison {
	
	public GreaterOrEqualThan(ASTNode left, ASTNode right) {
		super(left, right);
	}

	@Override
	public Object execute() {
		return (float)left.execute() >= (float)right.execute();
	}

}
