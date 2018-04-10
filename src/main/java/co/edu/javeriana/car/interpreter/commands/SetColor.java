package co.edu.javeriana.car.interpreter.commands;

import java.util.Map;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.car.interpreter.ASTNode;

public class SetColor extends Command {
	
	private ASTNode red;
	private ASTNode green;
	private ASTNode blue;
	private ASTNode alpha;

	public SetColor(Car car, ASTNode red, ASTNode green, ASTNode blue, ASTNode alpha) {
		super(car);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		car.color( (float)red.execute(symbolTable), 
				 (float)green.execute(symbolTable), 
				  (float)blue.execute(symbolTable), 
				 (float)alpha.execute(symbolTable));
		return null;
	}

}
