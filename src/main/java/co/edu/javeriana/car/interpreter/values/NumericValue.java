package co.edu.javeriana.car.interpreter.values;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class NumericValue extends ASTNode {
	
	private float value;
	
	public NumericValue(String value) {
		this.value = Float.parseFloat(value);
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return this.value;
	}

}
