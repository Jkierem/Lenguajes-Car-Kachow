package co.edu.javeriana.car.interpreter.control;

import java.util.List;

import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class Function extends ASTNode {
	
	protected String id;
	protected List<ASTNode> body;
	
	public Function(String id, List<ASTNode> body) {
		super();
		this.id = id;
		this.body = body;
	}
	
}
