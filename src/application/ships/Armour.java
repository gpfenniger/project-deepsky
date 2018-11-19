package application.ships;

public class Armour extends Item {
	private int maxValue;
	private int value;
	
	public Armour(String name, int maxValue, int credits) {
		super(name, credits);
		this.maxValue = maxValue;
		this.value = maxValue;
	}
	
	public int getMaxValue() { return this.maxValue; }
	public int getValue() { return this.value; }
	public void repair() { this.value = this.maxValue; }
	public void repair(int amount) {
		if (this.value + amount < this.maxValue)
			this.value += amount;
		else
			this.value = this.maxValue;
	}
}
