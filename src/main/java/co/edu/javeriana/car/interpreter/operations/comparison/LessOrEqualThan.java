package co.edu.javeriana.car.interpreter.operations.comparison;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class LessOrEqualThan extends Comparison {

	public LessOrEqualThan(ASTNode left, ASTNode right) {
		super(left, right);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return (float)left.execute(symbolTable) <= (float)right.execute(symbolTable);
	}

}
