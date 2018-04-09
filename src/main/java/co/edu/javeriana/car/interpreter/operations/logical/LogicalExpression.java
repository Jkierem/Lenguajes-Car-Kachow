package co.edu.javeriana.car.interpreter.operations.logical;

import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class LogicalExpression extends ASTNode {

	@Override
	public abstract Object execute();

}
