package co.edu.javeriana.car.interpreter.commands;

import java.util.Map;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.car.interpreter.ASTNode;

public abstract class Command extends ASTNode {
	
	protected Car car;
	
	public Command(Car car) {
		this.car = car;
	}
	
	public abstract Object execute(Map<String, Object> symbolTable);

}
