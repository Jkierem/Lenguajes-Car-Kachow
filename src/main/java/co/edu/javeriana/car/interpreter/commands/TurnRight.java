package co.edu.javeriana.car.interpreter.commands;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.car.interpreter.ASTNode;

public class TurnRight extends MovementCommand {

	public TurnRight(Car car, ASTNode arg1) {
		super(car, arg1);
	}

	@Override
	public Object execute() {
		car.right((float)arg1.execute());
		return null;
	}

}
