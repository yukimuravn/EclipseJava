import java.util.Comparator;


public class Appliance {
	int id;
	int numInStock;
	
	int numOfSold;
	int reorder;
	


	public Appliance(int id, int numInStock) {
		super();
		this.id = id;
		this.numInStock = numInStock;
		this.numOfSold = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	public int getNumOfSold() {
		return numOfSold;
	}

	public void setNumOfSold(int numOfSold) {
		this.numOfSold = numOfSold;
	}
	
	public int getReorder() {
		return reorder;
	}

	public void setReorder(int reorder) {
		this.reorder = reorder;
	}
	
	public void incrementNumOfSold() {
		this.numOfSold ++;
	}
	
	public static Comparator<Appliance> sortID = new Comparator<Appliance>() {
		
		public int compare (Appliance item1, Appliance item2)
		{
			int id1 = item1.getId();
			int id2 = item2.getId();
			
			return id1 - id2;
		}
	};
	
	public static Comparator<Appliance> sortNumOfSold = new Comparator<Appliance>() {
		
		public int compare (Appliance item1, Appliance item2)
		{
			int id1 = item1.getNumOfSold();
			int id2 = item2.getNumOfSold();
			
			return id2 - id1;
		}
	};

}