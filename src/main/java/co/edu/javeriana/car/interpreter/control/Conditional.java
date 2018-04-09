package co.edu.javeriana.car.interpreter.control;

import java.util.List;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Conditional extends Control {
	
	private List<ASTNode> else_body;
	
	public Conditional( ASTNode condition , List<ASTNode> main_body , List<ASTNode> else_body ) {
		super( condition , main_body );
		this.else_body = else_body;
	}
	
	@Override
	public Object execute() {
		if( (boolean)this.condition.execute() ) {
			this.main_body.forEach((node)->{
				node.execute();
			});
		}else if( this.else_body != null ) {
			this.else_body.forEach((node)->{
				node.execute();
			});
		}
		return null;
	}

}
