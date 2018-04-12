package co.edu.javeriana.car.interpreter.control;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import co.edu.javeriana.car.interpreter.ASTNode;

public class FunctionDeclare extends Function {

	private List<String> paramIds;
	private Map<String,Object> localSymbolTable; 
	
	public FunctionDeclare(String id, List<String> paramIds , List<ASTNode> body) {
		super(id, body);
		this.localSymbolTable = new HashMap<>();
		this.paramIds = paramIds;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if( !symbolTable.containsKey(id) ) {
			symbolTable.put(id, this);
			this.localSymbolTable = new HashMap<>(symbolTable);
			this.paramIds.forEach((param)->{
				this.localSymbolTable.put(param, null);
			});
		}else {
			throw new Error("Function \""+id+"\" is redeclaration of a value");
		}
		return null;
	}

	public List<String> getParamIds() {
		return paramIds;
	}

	public void setParamIds(List<String> paramIds) {
		this.paramIds = paramIds;
	}

	public Map<String, Object> getLocalSymbolTable() {
		return localSymbolTable;
	}

	public void setLocalSymbolTable(Map<String, Object> localSymbolTable) {
		this.localSymbolTable = localSymbolTable;
	}
	
	
	
}
