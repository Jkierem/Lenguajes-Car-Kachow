package co.edu.javeriana.car.interpreter;

import java.util.List;

public class Program extends ASTNode {
	
	List<ASTNode> sentences;
	
	public Program( List<ASTNode> sentences ) {
		this.sentences = sentences;
	}

	@Override
	public Object execute() {
		this.sentences.forEach((node)->{
			node.execute();
		});
		return null;
	}

}
