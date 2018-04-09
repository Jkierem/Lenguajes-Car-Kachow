package co.edu.javeriana.car.interpreter.values;

import co.edu.javeriana.car.interpreter.ASTNode;

public class StringValue extends ASTNode {
	
	private String value;
	
	public StringValue( String value) {
		this.value  = value;
	}
	
	@Override
	public Object execute() {
		return this.value;
	}

}
