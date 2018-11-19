package application.ships;

public class Shield extends Item {
	private int maxValue;
	private int rechargeRate;
	private int value;
	
	public Shield(String name, int maxValue, int rechargeRate, int credits) {
		super(name, credits);
		this.maxValue = maxValue;
		this.rechargeRate = rechargeRate;
	}
	
	public int getMaxValue() { return this.maxValue; }
	public int getRechargeRate() { return this.rechargeRate; }
	public int getValue() { return this.value; }
	public boolean shieldsFull() { if (value == maxValue) return true; return false; }
	public void recharge() { if (!shieldsFull()) this.value += rechargeRate; }
	public void fullRecharge() { this.value = this.maxValue; }
}
