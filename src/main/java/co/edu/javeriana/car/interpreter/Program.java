package co.edu.javeriana.car.interpreter;

import java.util.List;
import java.util.Map;

public class Program extends ASTNode {
	
	List<ASTNode> sentences;
	
	public Program( List<ASTNode> sentences ) {
		this.sentences = sentences;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		this.sentences.forEach((node)->{
			node.execute(symbolTable);
		});
		return null;
	}

}
