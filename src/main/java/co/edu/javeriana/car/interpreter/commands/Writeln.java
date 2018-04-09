package co.edu.javeriana.car.interpreter.commands;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Writeln extends ASTNode {
	protected ASTNode arg1;
	
	public Writeln(ASTNode arg1) {
		super();
		this.arg1 = arg1;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		System.out.println(this.arg1.execute(null));
		return null;
	}

}
