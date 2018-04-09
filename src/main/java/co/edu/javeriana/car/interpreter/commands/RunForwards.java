package co.edu.javeriana.car.interpreter.commands;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.car.interpreter.ASTNode;

public class RunForwards extends MovementCommand {

	public RunForwards(Car car, ASTNode arg1) {
		super(car, arg1);
	}

	@Override
	public Object execute() {
		car.forward((float)arg1.execute());
		return null;
	}

}
