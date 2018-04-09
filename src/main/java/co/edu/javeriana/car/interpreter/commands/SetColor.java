package co.edu.javeriana.car.interpreter.commands;

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
	public Object execute() {
		car.color( (float)red.execute(), 
				 (float)green.execute(), 
				  (float)blue.execute(), 
				 (float)alpha.execute());
		return null;
	}

}
