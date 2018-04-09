package co.edu.javeriana.car.interpreter.operations.comparison;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class GreaterOrEqualThan extends Comparison {
	
	public GreaterOrEqualThan(ASTNode left, ASTNode right) {
		super(left, right);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return (float)left.execute(null) >= (float)right.execute(null);
	}

}
