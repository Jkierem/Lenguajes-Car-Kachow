package co.edu.javeriana.car.interpreter.operations.logical;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Not extends LogicalExpression {
	
	private ASTNode op1;
	
	public Not( ASTNode op1 ) {
		this.op1 = op1;
	}
	
	@Override
	public Object execute() {
		return !(boolean)op1.execute();
	}

}
