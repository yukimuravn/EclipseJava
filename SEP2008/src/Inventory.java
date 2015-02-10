import java.util.ArrayList;
import java.util.List;


public class Inventory {
	List<Appliance> allItems;
	int totalReorder;
	int numOfSales;
	
	public Inventory() {
		allItems = new ArrayList<Appliance>();
	}
	
	public void addItem(int id, int numOfStock) {
		Appliance ap = new Appliance(id, numOfStock);
		allItems.add(ap);
	}
	
	public void processSold(int id) {
		for(int i = 0; i < allItems.size(); i++) {
			Appliance ap = allItems.get(i);
			if(ap.getId() == id) {
				ap.incrementNumOfSold();
				this.numOfSales++;
				break;
			}
		}
	}
	
	public void processReorder() {
		for(int i = 0; i < allItems.size(); i++) {
			Appliance ap = allItems.get(i);
			// handles guideline 1
			if(ap.getNumInStock() == 0) {
				int numExtra =(int) (ap.getNumOfSold() * 0.2); 
				// ap.getNumOfSold()/5;
				if(numExtra < 2)
					numExtra = 2;
				ap.setReorder(numExtra+ap.getNumOfSold());
				totalReorder += numExtra+ap.getNumOfSold();
			}
			// handles the guideline 3
			else if(ap.getNumOfSold() > 0) {
				int numLess = (int) (ap.getNumOfSold() * 0.2);
				if(numLess < 1)
					numLess = 1;
				int numOfReorder = ap.getNumOfSold() - numLess;
				if(numOfReorder < 1)
					numOfReorder = 1;
				ap.setReorder(numOfReorder);
				totalReorder += numOfReorder;
			}
			// guideline 2 get handles automatically
		}
	}
}