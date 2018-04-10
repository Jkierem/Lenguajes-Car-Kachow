package co.edu.javeriana.car.interpreter.commands;

import java.util.Map;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.car.interpreter.ASTNode;

public class RunBackwards extends MovementCommand {
	
	public RunBackwards(Car car, ASTNode arg1) {
		super(car, arg1);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		car.backwards((float)arg1.execute(symbolTable));
		return null;
	}

}
