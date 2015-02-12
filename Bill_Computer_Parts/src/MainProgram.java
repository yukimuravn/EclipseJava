import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
	public static ArrayList<Product> productsArrayList = new ArrayList<Product>();
	public static ArrayList<Order> ordersArrayList = new ArrayList<Order>();
	public static ArrayList<OrderDetail> orderDetailsArrayList = new ArrayList<OrderDetail>();

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//Create OrderDetail object
		OrderDetail orderDetail = new OrderDetail();
		
		//Read input file "customers.txt" and add to customers ArrayList
		Scanner scnCustomer = new Scanner(new File("customers.txt"));
		while (scnCustomer.hasNextLine()) {
			int id = scnCustomer.nextInt();
			String name = scnCustomer.next();
			String discountStatus = scnCustomer.next();
			orderDetail.addCustomer(id, name, discountStatus);
		}
		scnCustomer.close();
		
		//Read input file "products.txt" and add to products ArrayList
		Scanner scnProducts = new Scanner(new File("products.txt"));
		while (scnProducts.hasNextLine()) {
			int id = scnProducts.nextInt();
			String name = scnProducts.next();
			double price = scnProducts.nextDouble();
			orderDetail.addProduct(id, name, price);
		}
		scnProducts.close();
		
		//Read input file "orders.txt" and add to orders ArrayList
		Scanner scnOrders = new Scanner(new File("orders.txt"));
		while (scnOrders.hasNextLine()) {
			int cusID = scnOrders.nextInt();
			int proID = scnOrders.nextInt();
			int quantity = scnOrders.nextInt();
			orderDetail.addOrder(cusID, proID, quantity);
			}
		scnOrders.close();		
		
		//Order processing
		orderDetail.addCustomerDetail();
		orderDetail.addProductDetail();
		orderDetail.calculateOrderAmount();
		orderDetail.calculateTotalAmount();
		
		//Print the output to screen
		orderDetail.displayOrderDetail();
		orderDetail.displaySummary();
	}

}
