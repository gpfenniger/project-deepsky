package application.ships;

public class ShipObject {
	private String name;
	private Shield shield;
	private Armour armour;
	private Cargo cargo;
	private Engine engine;
	private Weapon[] weapons;
	
	public ShipObject(
			String name, Shield shield, Armour armour,
			Cargo cargo, Engine engine, Weapon[] weapons
	) {
		this.name = name;
		this.shield = shield;
		this.armour = armour;
		this.cargo = cargo;
		this.engine = engine;
		this.weapons = weapons;
	}
	
	public String getName() { return this.name; }
	public Shield getShield() { return this.shield; }
	public Armour getArmour() { return this.armour; }
	public Cargo getCargo() { return this.cargo; }
	public Engine getEngine() { return this.engine; }
	public Weapon[] getWeapons() { return this.weapons; }

	public void setName(String name) { this.name = name; }
	public void setShield(Shield shield) { this.shield = shield; }
	public void setArmour(Armour armour) { this.armour = armour; }
	public void setCargo(Cargo cargo) { this.cargo = cargo; }
	public void setEngine(Engine engine) { this.engine = engine; }
	public void setWeapons(Weapon[] weapons) { this.weapons = weapons; }
}
