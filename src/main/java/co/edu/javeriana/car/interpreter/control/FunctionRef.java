package co.edu.javeriana.car.interpreter.control;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import co.edu.javeriana.car.interpreter.ASTNode;

public class FunctionRef extends Function {

	public FunctionRef(String id, List<ASTNode> body) {
		super(id, body);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if( symbolTable.containsKey(id) ) {
			FunctionDeclare funkNode = (FunctionDeclare)symbolTable.get(id);
			Map<String,Object> localTable = new HashMap<>(funkNode.getLocalSymbolTable());
			List<String> paramIds = funkNode.getParamIds();
			int funkParams = paramIds.size();
			int refParams = this.body.size();
			if( funkParams != refParams ) {
				String fParams = Integer.toString(funkParams) + " parameter" +
									( funkParams != 1?"s":"");
				String rParams = Integer.toString(refParams) + " parameter" +
									( refParams != 1?"s":"");
				throw new Error("Parameters don't match. Function \""
									+id+"\" expects "+ fParams +" but received "+ rParams);
			}
			for( int i = 0 ; i < paramIds.size() ; i++ ) {
				localTable.put( paramIds.get(i) , this.body.get(i).execute(symbolTable) );
			}
			funkNode.body.forEach((node)->{
				node.execute(localTable);
			});
		}else {
			throw new Error("Undefined reference to function \""+id+"\"");
		}
		return null;
	}

}
