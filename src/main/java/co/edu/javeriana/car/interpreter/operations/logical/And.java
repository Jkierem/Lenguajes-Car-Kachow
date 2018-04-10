package co.edu.javeriana.car.interpreter.operations.logical;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class And extends LogicalExpression {
	
	private ASTNode op2;
	
	public And( ASTNode op1 , ASTNode op2 ) {
		super(op1);
		this.op2 = op2;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return (boolean)op1.execute(symbolTable) && (boolean)op2.execute(symbolTable);
	}

}
