package co.edu.javeriana.car.interpreter.operations.logical;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class LogicalExpression extends ASTNode {

	@Override
	public abstract Object execute(Map<String, Object> symbolTable);

}
