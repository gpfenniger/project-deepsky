package application.entities;

import application.ships.ShipObject;
import application.ships.Weapon;
import javafx.scene.image.ImageView;

public class Player extends GameObject {
	private ShipObject ship;
	
	public Player(ShipObject ship) {
		super(new ImageView("/resources/ship_version_bob.png"));
		this.ship = ship;
		
		if (ship.getEngine() != null)
			super.setSpeedLimit(ship.getEngine().getSpeedLimit());
			
	}
	
	@Override
	public void update() {
		super.getView().setTranslateX(super.getView().getTranslateX() + super.getVelocity().getX());
		super.getView().setTranslateY(super.getView().getTranslateY() + super.getVelocity().getY());
		//for (Weapon w : ship.getWeapons())
			//w.update();
	}
}
