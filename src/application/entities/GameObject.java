package application.entities;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public class GameObject {
	private Node view;
	private Point2D velocity;
	
	private boolean alive = true;
	private double speedLimit = 1;
	
	public GameObject(Node view) {
		this.view = view;
	}
	
	public void update() {
		view.setTranslateX(view.getTranslateX() + velocity.getX());
		view.setTranslateY(view.getTranslateY() + velocity.getY());
	}
	
	public boolean isAlive() { return this.alive; }
	public void setAlive(boolean alive) { this.alive = alive; }
	public boolean isDead() {return !alive; }
	
	public double getRotate() { return view.getRotate(); }
	public void rotateLeft() { 
		this.view.setRotate(view.getRotate() - 5); 
		//setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
	}
	public void rotateRight() {
		this.view.setRotate(view.getRotate() + 5); 
		//setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
	}
	public void setRotate(double r) {	//Degrees
		this.view.setRotate(r);
	}
	
	public Point2D getVelocity() { return this.velocity; }
	public void setVelocity(Point2D velocity) { this.velocity = velocity; }
	public void addVelocity(Point2D addedVelocity) {
		double dx = 0, dy = 0;
		if (checkSpeedLimit(velocity.getX(), addedVelocity.getX()))
			dx = addedVelocity.getX();
		if (checkSpeedLimit(velocity.getY(), addedVelocity.getY()))
			dy = addedVelocity.getY();
		
		
		this.velocity = new Point2D(
			velocity.getX() + dx,
			velocity.getY() + dy
		);
	}
	
	private boolean checkSpeedLimit(double currV, double addV) {
		if (currV + addV >= 0-speedLimit && currV + addV <= speedLimit)
			return true;
		return false;
	}
	
	public Node getView() { return this.view; }
	
	public boolean isColliding(GameObject other) {
		return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
	}
	
	protected void setSpeedLimit(double speedLimit) { this.speedLimit = speedLimit; }
}
