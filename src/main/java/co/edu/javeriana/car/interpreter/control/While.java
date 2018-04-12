package co.edu.javeriana.car.interpreter.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.javeriana.car.interpreter.ASTNode;

public class While extends Control {
	
	private Map<String,Object> localSymbolTable;
	
	public While(ASTNode condition, List<ASTNode> main_body) {
		super(condition, main_body);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		while( (boolean)condition.execute(symbolTable) ) {
			this.localSymbolTable = new HashMap<>(symbolTable);
			main_body.forEach((node)->{
				node.execute(localSymbolTable);
			});
			localSymbolTable.keySet().forEach((key)->{
				if( symbolTable.containsKey(key) ) {
					symbolTable.put(key, localSymbolTable.get(key));
				}
			});
		}
		return null;
	}

}
