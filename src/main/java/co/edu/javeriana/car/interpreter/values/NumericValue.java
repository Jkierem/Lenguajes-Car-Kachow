package co.edu.javeriana.car.interpreter.values;

import co.edu.javeriana.car.interpreter.ASTNode;

public class NumericValue extends ASTNode {
	
	private float value;
	
	public NumericValue(String value) {
		this.value = Float.parseFloat(value);
	}
	
	@Override
	public Object execute() {
		return this.value;
	}

}
