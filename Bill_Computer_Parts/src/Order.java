
public class Order {
	int customerID;
	String customerName;
	int productID;
	String productName;
	int quantity;	
	boolean discountStatus;
	double productPrice;
	double orderAmount;
	double discountAmount;
	
	public Order (int customerID, int productID, int quantity)
	{
		super();
		this.customerID = customerID;
		this.productID = productID;
		this.quantity = quantity;
	}
	
	public int getCustomerID()
	{
		return customerID;
	}
	
	public void setCustomerID(int customerID)
	{
		this.customerID = customerID;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	
	public int getProductID()
	{
		return productID;
	}
	
	public void setProductID(int productID)
	{
		this.productID = productID;
	}
	
	public String getProductName()
	{
		return productName;
	}
	
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public boolean getDiscountStatus()
	{
		return discountStatus;
	}
	
	public void setDiscountStatus(boolean discountStatus)
	{
		this.discountStatus = discountStatus;
	}
	
	public double getProductPrice()
	{
		return productPrice;
	}
	
	public void setProductPrice(double productPrice)
	{
		this.productPrice = productPrice;
	}
	
	public double getOrderAmount()
	{
		return orderAmount;
	}
	
	public void setOrderAmount() {
		double orderAmount;
		orderAmount = productPrice * quantity;
		if (discountStatus) {			
			orderAmount = orderAmount * 0.9;
		}
		this.orderAmount = orderAmount;
	}
	
	public double getDiscountAmount() 
	{
		return discountAmount;
	}
	
	public void setDiscountAmount()
	{
		if (discountStatus) {
			this.discountAmount = productPrice * quantity - orderAmount;
		}
		else {
			this.discountAmount = 0.0;
		}
	}

}
