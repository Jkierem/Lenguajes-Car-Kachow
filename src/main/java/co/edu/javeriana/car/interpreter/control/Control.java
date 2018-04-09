package co.edu.javeriana.car.interpreter.control;

import java.util.List;
import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class Control extends ASTNode {
	
	protected ASTNode condition;
	protected List<ASTNode> main_body;
	
	public Control(ASTNode condition, List<ASTNode> main_body) {
		super();
		this.condition = condition;
		this.main_body = main_body;
	}

	public abstract Object execute(Map<String, Object> symbolTable);

}
