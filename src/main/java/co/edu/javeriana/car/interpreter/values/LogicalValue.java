package co.edu.javeriana.car.interpreter.values;

import co.edu.javeriana.car.interpreter.ASTNode;

public class LogicalValue extends ASTNode {
	
	private boolean value;
	
	public LogicalValue(String value) {
		this.value = Boolean.parseBoolean(value);
	}
	
	@Override
	public Object execute() {
		return this.value;
	}

}
