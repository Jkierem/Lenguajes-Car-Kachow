package co.edu.javeriana.car.interpreter.control;

import java.util.List;

import co.edu.javeriana.car.interpreter.ASTNode;

public class While extends Control {

	public While(ASTNode condition, List<ASTNode> main_body) {
		super(condition, main_body);
	}

	@Override
	public Object execute() {
		while( (boolean)condition.execute() ) {
			main_body.forEach((node)->{
				node.execute();
			});
		}
		return null;
	}

}
