
public class Slip {
	int personID;
	int productID;
	int numOfSales;
	
	public Slip(int personID, int productID, int numOfSales)
	{
		super();
		this.personID = personID;
		this.productID = productID;
		this.numOfSales = numOfSales;
	}
	
	public int getPersonID() {
		return personID;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public int getNumOfsales() {
		return numOfSales;
	}
}
