package co.edu.javeriana.car.interpreter.control;

import java.util.Map;

public class VarDeclare extends Variable {
	
	public VarDeclare(String name) {
		super(name);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		symbolTable.put(name, new Object());
		return null;
	}

}
