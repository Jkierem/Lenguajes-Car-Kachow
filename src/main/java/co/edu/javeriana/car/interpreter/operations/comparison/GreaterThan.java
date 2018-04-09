package co.edu.javeriana.car.interpreter.operations.comparison;

import co.edu.javeriana.car.interpreter.ASTNode;

public class GreaterThan extends Comparison {
	
	public GreaterThan(ASTNode left, ASTNode right) {
		super(left, right);
	}

	@Override
	public Object execute() {
		return (float)left.execute() > (float)right.execute();
	}
}
