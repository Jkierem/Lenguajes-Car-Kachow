package co.edu.javeriana.car.interpreter.operations.comparison;

import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class Comparison extends ASTNode {
	protected ASTNode left;
	protected ASTNode right;
	
	public Comparison( ASTNode left , ASTNode right ) {
		this.left = left;
		this.right = right;
	}
	
	public abstract Object execute(Map<String, Object> symbolTable);

}
