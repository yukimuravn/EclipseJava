
public class Transaction {
	String itemID;
	int quantity;
	boolean isSold;
	
	public Transaction(String itemID, int quantity, String isSoldString) {
		super();
		this.itemID = itemID;
		this.quantity = quantity;
		if (isSoldString.equals("S")) {
			this.isSold = true;
		}
		else {
			this.isSold = false;
		}
	}
	
	public String getItemID() {
		return itemID;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public boolean isSoldType () {
		return isSold;
	}
}
