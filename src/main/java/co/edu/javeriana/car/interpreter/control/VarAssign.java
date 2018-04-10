package co.edu.javeriana.car.interpreter.control;

import java.util.Map;
import co.edu.javeriana.car.interpreter.ASTNode;

public class VarAssign extends Variable {
	
	private ASTNode expression;
	
	public VarAssign( String name, ASTNode expression ) {
		super(name);
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		symbolTable.put(name, expression.execute(symbolTable));
		return null;
	}

}
