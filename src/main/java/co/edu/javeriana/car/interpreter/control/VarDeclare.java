package co.edu.javeriana.car.interpreter.control;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class VarDeclare extends ASTNode {
	private String name;
	
	public VarDeclare(String name) {
		super();
		this.name = name;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		// TODO Auto-generated method stub
		return null;
	}

}
