package co.edu.javeriana.car.interpreter.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class Conditional extends Control {
	
	private List<ASTNode> else_body;
	
	public Conditional( ASTNode condition , List<ASTNode> main_body , List<ASTNode> else_body ) {
		super( condition , main_body );
		this.else_body = else_body;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		Map<String,Object> localTable = new HashMap<>(symbolTable);
		if( (boolean)this.condition.execute(symbolTable) ) {
			this.main_body.forEach((node)->{
				node.execute(localTable);
			});
		}else if( !this.else_body.isEmpty() ) {
			this.else_body.forEach((node)->{
				node.execute(localTable);
			});
		}
		localTable.keySet().forEach((key)->{
			if( symbolTable.containsKey(key) ) {
				symbolTable.put(key, localTable.get(key));
			}
		});
		return null;
	}

}
