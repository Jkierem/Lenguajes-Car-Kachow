package co.edu.javeriana.car.interpreter.control;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class VarDeclareAssign extends Variable {
	
	private ASTNode expression;
	
	public VarDeclareAssign(String name, ASTNode expression) {
		super(name);
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if( !symbolTable.containsKey(name) ) {
			symbolTable.put(name, expression.execute(symbolTable));
		}else {
			throw new Error("Variable \""+name+"\" redeclaration");
		}
		return null;
	}

}
