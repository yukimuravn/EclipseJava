import java.util.Comparator;


public class Customer {
	int id;
	String name;
	boolean discountStatus;
	double totalAmount;
	
	public Customer(int id, String name, String discountStatus)
	{
		super();
		this.id = id;
		this.name = name;
		if (discountStatus.equals("YES")) {
			this.discountStatus = true;
		}
		else {
			this.discountStatus = false;
		}
		this.totalAmount = 0.0;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getDiscountStatus() {
		return discountStatus;
	}
	
	public void setDiscountStatus(boolean discountStatus) {
		this.discountStatus = discountStatus;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(double orderAmount) {
		this.totalAmount += orderAmount; 
	}
	
	/*Comparator for sorting the list by total amount*/
    public static Comparator<Customer> ttAmount = new Comparator<Customer>() 
    {
		public int compare(Customer c1, Customer c2) 
		{
	
		   int ttAmount1 = (int) c1.getTotalAmount();
		   int ttAmount2 = (int) c2.getTotalAmount();
	
		   /*For ascending order*/
		   //return ttAmount1 - ttAmount2;
	
		   /*For descending order*/
		   return ttAmount2 - ttAmount1;
		}
    };
    
    /*Comparator for sorting the list by customer name*/
    public static Comparator<Customer> cusName = new Comparator<Customer>() 
    {
		public int compare(Customer c1, Customer c2) 
		{
	
		   String cus1 = c1.getName();
		   String cus2 = c2.getName();
	
		   /*For ascending order*/
		   return cus1.compareTo(cus2);
	
		   /*For descending order*/
		   //return cus2.compareTo(cus1);
		}
    };
}
