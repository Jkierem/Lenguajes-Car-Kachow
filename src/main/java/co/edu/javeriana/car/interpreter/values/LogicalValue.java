package co.edu.javeriana.car.interpreter.values;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class LogicalValue extends ASTNode {
	
	private boolean value;
	
	public LogicalValue(String value) {
		this.value = Boolean.parseBoolean(value);
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return this.value;
	}

}
