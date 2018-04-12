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
		if( !symbolTable.containsKey(name) ) {
			throw new Error("Trying to assign undefined reference to \""+name+"\"");
		}
		symbolTable.put(name, expression.execute(symbolTable));
		return null;
	}

}
