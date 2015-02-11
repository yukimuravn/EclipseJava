import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class OrderDetail {

	List<Order> allOrders;
	List<Customer> allCustomers;
	List<Product> allProducts;

	//Method for order processing
	
	public OrderDetail() {
		allOrders = new ArrayList<Order>();
		allCustomers = new ArrayList<Customer>();
		allProducts = new ArrayList<Product>();
	}
	
	public void addOrder(int customerID, int productID, int quantity) {
		Order order = new Order(customerID, productID, quantity);
		allOrders.add(order);
	}
	
	public void addCustomer(int customerID, String customerName, String discountStatus) {
		Customer customer = new Customer(customerID, customerName, discountStatus);
		allCustomers.add(customer);
	}
	
	public void addProduct(int productID, String productName, double productPrice) {
		Product product = new Product(productID, productName, productPrice);
		allProducts.add(product);
	}
	
	public void addCustomerDetail() {
		for (Order order : allOrders) {
			for (Customer customer : allCustomers) {
				if (order.getCustomerID() == customer.getId()) {
					order.setCustomerName(customer.name);
					order.setDiscountStatus(customer.discountStatus);
					break;
				}
			}
		}
	}

	public void addProductDetail() {
		for (Order order : allOrders) {
			for (Product product : allProducts) {
				if (order.getProductID() == product.getId()) {
					order.setProductName(product.name);
					order.setProductPrice(product.price);
					break;
				}
			}
		}
	}
	
	public void calculateOrderAmount() {
		for (Order order : allOrders) {
			order.setOrderAmount();
			order.setDiscountAmount();
		}
	}
	
	public void displayOrderDetail() {
		try {
			PrintWriter printWriter = new PrintWriter(new File("orderdetails.txt"));

			String cName = "Customer Name";
			String pName = "Product Name";
			String price = "Price";
			String quantity = "Quantity";
			String ordAmount = "Order Amount";
			String discount = "Discount";
			String orderDetails = "Order Details";
			System.out.printf("%40s \n \n", orderDetails);
			printWriter.write(String.format("%40s \n \n", orderDetails));
			System.out.printf("%s  %s  %s  %s  %s  %s \n",cName,pName,price,quantity,ordAmount,discount);
			printWriter.write(String.format("%s  %s  %s  %s  %s  %s \n",cName,pName,price,quantity,ordAmount,discount));
			
			/*
			Iterator<Order> orderIterator = allOrders.iterator();
			while (orderIterator.hasNext()) {
				Order order = orderIterator.next();
				System.out.printf("%-14s %-13s %-9.1f %-8d %-12.1f %.1f \n", order.getCustomerName(), order.getProductName(),
						order.getProductPrice(), order.getQuantity(), order.getOrderAmount(), order.getDiscountAmount());
				printWriter.write(String.format("%-14s %-13s %-9.1f %-8d %-12.1f %.1f \n", order.getCustomerName(), order.getProductName(),
						order.getProductPrice(), order.getQuantity(), order.getOrderAmount(), order.getDiscountAmount()));
			}
			*/
			
			for (Order order : allOrders) {
				System.out.printf("%-14s %-13s %-9.1f %-8d %-12.1f %.1f \n", order.getCustomerName(), order.getProductName(),
						order.getProductPrice(), order.getQuantity(), order.getOrderAmount(), order.getDiscountAmount());
				printWriter.write(String.format("%-14s %-13s %-9.1f %-8d %-12.1f %.1f \n", order.getCustomerName(), order.getProductName(),
						order.getProductPrice(), order.getQuantity(), order.getOrderAmount(), order.getDiscountAmount()));
			}
			
			printWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void calculateTotalAmount() {
		for (Customer customer : allCustomers) {
			for (Order order : allOrders) {
				if (customer.getId() == order.getCustomerID()) {
					customer.setTotalAmount(order.getOrderAmount());
				}				
			}			
		}
	}

	
	public void displaySummary() {
		try {
			//Prepare to write
			PrintWriter printWriter = new PrintWriter(new File("summary.txt"));
			
			//Sort the allCustomers by totalAmount
			Collections.sort(allCustomers, Customer.ttAmount);
			
			System.out.println();
			String summary = "Summary";
			System.out.printf("%20s \n \n", summary);
			printWriter.write(String.format("%20s \n \n", summary));
			System.out.println("Customer Name   Total Amount");
			printWriter.write("Customer Name   Total Amount \n");
			for (Customer customer : allCustomers) 
			{
				if (customer.getTotalAmount() > 0) 
				{
					System.out.printf("%-15s %.1f \n", customer.getName(),customer.getTotalAmount());
					printWriter.write(String.format("%-15s %.1f \n", customer.getName(),customer.getTotalAmount()));
				}			
			}
			printWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
