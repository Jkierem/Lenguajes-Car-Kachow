package co.edu.javeriana.car.interpreter.commands;

import java.util.Map;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class MovementCommand extends Command {
	
	protected ASTNode arg1;
	
	public MovementCommand(Car car, ASTNode arg1) {
		super(car);
		this.arg1 = arg1;
	}

	@Override
	public abstract Object execute(Map<String, Object> symbolTable);

}
