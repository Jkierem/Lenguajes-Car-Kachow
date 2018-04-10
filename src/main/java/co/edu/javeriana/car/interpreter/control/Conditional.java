package co.edu.javeriana.car.interpreter.control;

import java.util.List;
import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Conditional extends Control {
	
	private List<ASTNode> else_body;
	
	public Conditional( ASTNode condition , List<ASTNode> main_body , List<ASTNode> else_body ) {
		super( condition , main_body );
		this.else_body = else_body;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if( (boolean)this.condition.execute(symbolTable) ) {
			this.main_body.forEach((node)->{
				node.execute(symbolTable);
			});
		}else if( !this.else_body.isEmpty() ) {
			this.else_body.forEach((node)->{
				node.execute(symbolTable);
			});
		}
		return null;
	}

}
