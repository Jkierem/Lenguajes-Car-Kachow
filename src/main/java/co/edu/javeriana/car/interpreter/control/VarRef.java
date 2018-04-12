package co.edu.javeriana.car.interpreter.control;

import java.util.Map;

public class VarRef extends Variable {
	
	public VarRef( String name ) {
		super(name);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if( !symbolTable.containsKey(name) ) {
			throw new Error("Undefined reference to variable \""+name+"\"");
		}
		return symbolTable.get(name);
	}

}
