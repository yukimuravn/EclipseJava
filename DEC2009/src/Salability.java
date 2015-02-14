import java.util.Comparator;


public class Salability {
	Price prod_price;
	int num;
	double totalValue;
	
	public Salability(Price price)
	{
		super();
		this.prod_price = price;
		this.num = 0;
		this.totalValue = 0;
	}
	
	public void increaseNum(int i) {
		this.num += i;
	}
	
	public int getID() {
		return prod_price.getID();
	}

	public int getNum() {
		return num;
	}
	
	public void calTotalValue() {
		this.totalValue = num * prod_price.getPrice();
	}
	
	public double getTotalValue() {
		return totalValue;
	}
	
	/*
	 * Sort list by total value
	 */
	public static Comparator<Salability> sortDescTotal = new Comparator<Salability>() {
		
		public int compare(Salability s1, Salability s2) {
			double res = s2.getTotalValue() - s1.getTotalValue(); //(p1-p2) is ascending and (p2-p1) is descending
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
