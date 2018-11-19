package application.ships;

public class Weapon extends Item {
	private int damage;
	private int delay;
	private int currentTimer = 0;
	private boolean loaded = true;
	
	public Weapon(String name, int credits, int damage, int delay) {
		super(name, credits);
		this.damage = damage;
		this.delay = delay;
	}
	
	public int getDamage() { return this.damage; }
	public int getDelay() { return this.delay; }
	public boolean isLoaded() { return loaded; }
	
	public void shoot() { 
		this.loaded = false; 
		this.currentTimer = 0;
	}
	
	public void update() {
		if (!loaded) {
			currentTimer++;
			if (currentTimer > delay)
				loaded = true;
		}
	}
	
}
