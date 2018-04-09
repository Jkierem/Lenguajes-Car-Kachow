package co.edu.javeriana.car.interpreter.control;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class VarAssign extends ASTNode {
	private String name;
	private ASTNode expression;
	
	public VarAssign( String name, ASTNode expression ) {
		super();
		this.name = name;
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		// TODO Auto-generated method stub
		return null;
	}

}
