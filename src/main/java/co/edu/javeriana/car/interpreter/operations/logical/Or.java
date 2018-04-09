package co.edu.javeriana.car.interpreter.operations.logical;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Or extends LogicalExpression {
	
	private ASTNode op1;
	private ASTNode op2;
	
	public Or( ASTNode op1 , ASTNode op2 ) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return (boolean)op1.execute(null) || (boolean)op2.execute(null);
	}

}
