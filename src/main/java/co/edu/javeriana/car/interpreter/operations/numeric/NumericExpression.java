package co.edu.javeriana.car.interpreter.operations.numeric;

import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class NumericExpression extends ASTNode {
	
	protected ASTNode op1;
	protected ASTNode op2;
	
	public NumericExpression(ASTNode op1 , ASTNode op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	@Override
	public abstract Object execute();

}
