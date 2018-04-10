package co.edu.javeriana.car.interpreter.commands;

import java.util.Map;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.car.interpreter.ASTNode;

public class TurnLeft extends MovementCommand {

	public TurnLeft(Car car, ASTNode arg1) {
		super(car, arg1);
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		car.left((float)arg1.execute(symbolTable));
		return null;
	}

}
