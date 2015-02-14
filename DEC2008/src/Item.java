import java.util.Comparator;


public class Item {
	String id;
	double price;
	int quantity;
	int reorderPoint;
	int minimumOrder;
	int orderAmount;
	
	public Item(String id, double price, int quantity, int reorderPoint, int minimumOrder) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.reorderPoint = reorderPoint;
		this.minimumOrder = minimumOrder;
		this.orderAmount = 0;
	}
	
	public String getID() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int num, boolean isSold) {
		if (isSold) {
			this.quantity -= num;
		}
		else {
			this.quantity += num;
		}
	}
	
	public int getReorderPoint() {
		return reorderPoint;
	}
	
	public int getMinimumOrder() {
		return minimumOrder;
	}
	
	public void processOrderAmount() {
		this.orderAmount = reorderPoint + minimumOrder - quantity;
	}
	
	public int getOrderAmount() {
		return orderAmount;
	}
	
	public static Comparator<Item> sortAscOrderAmount = new Comparator<Item>() {
		public int compare(Item i1, Item i2) {
			int res = i1.getOrderAmount() - i2.getOrderAmount();
			if (res > 0) {
				return 1;
			}
			else if (res == 0) {
				return 0;
			}
			else {
				return -1;
			}
		}
	};
}
