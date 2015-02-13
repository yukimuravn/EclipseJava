
public class Product {
	int id;
	int numOfSales;
	double price;
	
	public Product(int id, double price) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.price = price;
		this.numOfSales = 0;
	}
	
	public int getID() {
		return id;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public int getNumOfsales() {
		return numOfSales;
	}
	
	public void increNumOfSales(int num) {
		this.numOfSales += num;
	}
}
