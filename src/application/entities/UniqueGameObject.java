package application.entities;

import javafx.scene.shape.Rectangle;

public class UniqueGameObject extends GameObject {
	private String name;
	
	public UniqueGameObject(String name) {
		super(new Rectangle(20, 20));
		this.name = name;
	}
	
	public String getName() { return this.name; }
}
