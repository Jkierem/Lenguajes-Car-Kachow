package co.edu.javeriana.car.interpreter;

import java.util.Map;

public abstract class ASTNode {
	public abstract Object execute(Map<String, Object> symbolTable);
}
