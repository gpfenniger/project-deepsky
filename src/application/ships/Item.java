package application.ships;

public class Item {
	private String name;
	private int credits;
	
	public Item(String name, int credits) {
		this.name = name;
		this.credits = credits;
	}
	
	public String getName() { return this.name; }
	public int getCredits() { return this.credits; }
}
