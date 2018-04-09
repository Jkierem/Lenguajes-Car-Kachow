package co.edu.javeriana.car.interpreter.operations.logical;

import co.edu.javeriana.car.interpreter.ASTNode;

public class And extends LogicalExpression {
	
	private ASTNode op1;
	private ASTNode op2;
	
	public And( ASTNode op1 , ASTNode op2 ) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	@Override
	public Object execute() {
		return (boolean)op1.execute() && (boolean)op2.execute();
	}

}
