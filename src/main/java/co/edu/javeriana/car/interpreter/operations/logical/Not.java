package co.edu.javeriana.car.interpreter.operations.logical;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Not extends LogicalExpression {
	
	private ASTNode op1;
	
	public Not( ASTNode op1 ) {
		this.op1 = op1;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return !(boolean)op1.execute(null);
	}

}
