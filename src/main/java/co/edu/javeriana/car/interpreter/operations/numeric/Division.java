package co.edu.javeriana.car.interpreter.operations.numeric;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Division extends NumericExpression {
	
	public Division(ASTNode op1, ASTNode op2) {
		super(op1,op2);
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return (float)op1.execute(null) / (float)op2.execute(null);
	}

}
