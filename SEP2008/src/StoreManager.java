import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;


public class StoreManager {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// read in inventory
		Inventory inv = new Inventory();
		Scanner invInput = new Scanner(new File("inventory.txt"));
		while(invInput.hasNextLine()) {
			int id = invInput.nextInt();
			int numOfStock = invInput.nextInt();
			inv.addItem(id, numOfStock);
		}
		invInput.close();
		
		// process sales
		Scanner salesInput = new Scanner(new File("sold.txt"));
		while(salesInput.hasNextLine()) {
			inv.processSold(salesInput.nextInt());
		}
		salesInput.close();
		
		// process reorder and output
		inv.processReorder();
		
		System.out.printf("Total number of items sold: %d \n", inv.numOfSales);
		System.out.printf("Total number of items to reorder: %d \n",inv.totalReorder);
		
		PrintWriter printWriter = new PrintWriter(new File("output.txt"));
		printWriter.printf("Total number of items sold: %d \n", inv.numOfSales);
		printWriter.printf("Total number of items to reorder: %d \n",inv.totalReorder);
		
		printWriter.println();
		printWriter.println("Sorted list of items to re-order:");		
		Collections.sort(inv.allItems, Appliance.sortID);
		for (Appliance app : inv.allItems) {
			if (app.getReorder() > 0) {
				printWriter.printf("%d %d \n", app.getId(), app.getReorder());
			}
		}
		
		printWriter.println();
		printWriter.println("Sorted list of items sold:");
		Collections.sort(inv.allItems, Appliance.sortNumOfSold);
		for (Appliance app : inv.allItems) {
			if (app.getNumOfSold() > 0) {
				printWriter.printf("%d %d \n", app.getId(), app.getNumOfSold());
			}
		}
		
		printWriter.close();
	}

}