package application.ships;

public class Cargo extends Item {
	private Item[] storage;
	private int maxItems;
	
	public Cargo(String name, int maxItems, int credits) {
		super(name, credits);
		this.maxItems = maxItems;
		this.storage = new Item[maxItems];
		for (int i = 0; i < maxItems; i++)
			storage[i] = null;
	}
	
	public int getMaxItems() { return this.maxItems; }
	public Item[] getStorage() { return this.storage; }
	
	public boolean isFull() {
		for (Item i : storage)
			if (i == null)
				return false;
		return true;
	}
	
	public void add(Item item) {
		if (!isFull()) {
			for (Item i : storage)
				if (i == null)
					i = item;
		}
	}
	
	public void remove(Item item) {
		for (Item i : storage)
			if (i == item)
				i = null;
	}
}
