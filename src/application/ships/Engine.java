package application.ships;

public class Engine extends Item {
	private double speedLimit;
	
	public Engine(String name, int credits, double speedLimit) {
		super(name, credits);
		this.speedLimit = speedLimit;
	}
	
	public double getSpeedLimit() { return this.speedLimit; }
}
