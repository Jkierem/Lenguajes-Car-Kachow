package co.edu.javeriana.car.interpreter.control;

import java.util.Map;

public class VarDeclare extends Variable {
	
	public VarDeclare(String name) {
		super(name);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if( !symbolTable.containsKey(name) ) {
			symbolTable.put(name, new Object());
		}else {
			throw new Error("Variable \""+name+"\" redeclaration");
		}
		return null;
	}

}
