package co.edu.javeriana.car.interpreter.control;

import java.util.List;
import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class While extends Control {

	public While(ASTNode condition, List<ASTNode> main_body) {
		super(condition, main_body);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		while( (boolean)condition.execute(symbolTable) ) {
			main_body.forEach((node)->{
				node.execute(symbolTable);
			});
		}
		return null;
	}

}
