package co.edu.javeriana.car.interpreter.operations.logical;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Not extends LogicalExpression {
	
	public Not( ASTNode op1 ) {
		super(op1);
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return !(boolean)op1.execute(symbolTable);
	}

}
