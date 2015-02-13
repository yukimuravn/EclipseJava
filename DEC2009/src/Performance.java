import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Performance {
	int personID;
	List<Product> productList;
	double performance;
	
	public Performance(int personID) {
		super();
		this.personID = personID;
		this.performance = 0;
		this.productList = new ArrayList<Product>();
	}
	
	public int getPersonID() {
		return personID;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	
	public double getPerformance() {
		return performance;
	}
	
	/*
	 * Set product ID and price to productList
	 */
	public void setProductID(List<Price> priceList) {	
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < priceList.size(); j++) {
				if (i == j) {
					Product p = new Product(priceList.get(i).getID(), priceList.get(i).getPrice());
					productList.add(p);
					break;
				}
			}
		}
	}
	
	/*
	 * Add number of sales to productList
	 */
	public void processProductList(Slip slip) {
		for (Product product : productList) {
			if (product.getID() == slip.getProductID()) {
				product.increNumOfSales(slip.getNumOfsales());
			}
		}
	}
	
	/*
	 * Calculate the performance of this personID
	 */
	
	public void calculatePerformance() {
		for (Product product : productList) {
			double res = product.getNumOfsales() * product.getPrice();
			this.performance += res;
			//System.out.printf("[%d] * [%f] = [%f] \n", product.getNumOfsales(), product.getPrice(), this.performance);
		}
	}
	
	/*
	 * Sort list by performance value
	 */
	public static Comparator<Performance> sortDescPerf = new Comparator<Performance>() {
		
		public int compare(Performance p1, Performance p2) {
			double res = p2.getPerformance() - p1.getPerformance(); //(p1-p2) is ascending and (p2-p1) is descending
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
