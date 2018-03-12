package co.edu.javeriana.car;

import org.jpavlich.agent.Executor;
import org.jpavlich.agent.model.Agent;
import org.jpavlich.agent.model.AgentProxy;

public class Car extends AgentProxy<Agent> implements ICar {

	public Car(Agent agent, Executor executor) {
		super(agent, executor);
	}
	
	public void color(float red, float green, float blue, float alpha){
		this.agent.color(red, green, blue, alpha);
	}

	public void forward(float amount){
		float rot = this.getRotation();
		float x = 1;
		float y = 0;
		
		float dx = (float)(x*Math.cos(rot) - y*Math.sin(rot));
		float dy = (float)(x*Math.sin(rot) + y*Math.cos(rot));
		
		dx *= amount;
		dy *= amount;
		
		this.agent.move(dx, dy);
	}

	public void backwards(float amount){
		this.forward(-1*amount);
	}

	public void left(float degrees){
		this.agent.left(degrees);
	}
	
	public void right(float degrees){
		this.agent.right(degrees);
	}
}
