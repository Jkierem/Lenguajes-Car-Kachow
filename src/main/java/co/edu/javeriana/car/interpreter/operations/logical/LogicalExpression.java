package co.edu.javeriana.car.interpreter.operations.logical;

import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class LogicalExpression extends ASTNode {
	protected ASTNode op1;
	
	public LogicalExpression( ASTNode op1 ) {
		this.op1 = op1;
	}
}
