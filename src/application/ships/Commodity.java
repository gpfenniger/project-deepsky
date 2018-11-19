package application.ships;

public class Commodity extends Item {
	private CommodityType type;
	private int quantity;
	
	public Commodity(CommodityType type, int quantity) {
		super(type.toString(), 0);
		this.type = type;
		this.quantity = quantity;
	}
	
	public CommodityType getType() { return this.type; }
	public int getQuantity() { return this.quantity; }
	public void addQuantity(int toAdd) { this.quantity += toAdd; }
	public boolean removeQuantity(int toRemove) {
		if (this.quantity - toRemove > 1) {
			this.quantity -= toRemove;
			return true;
		}
		return false;
	}
}
