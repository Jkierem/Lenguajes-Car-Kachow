package co.edu.javeriana.car.interpreter.control;

import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class Variable extends ASTNode {
	
	protected String name;
	
	public Variable( String name ) {
		this.name = name;
	}
	
}
