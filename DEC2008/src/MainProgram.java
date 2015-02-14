import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MainProgram {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		/*
		 * Init InventoryManager
		 */
		InventoryManager inventoryManager = new InventoryManager();
		
		/*
		 * Read the input file "Invmast.txt"
		 */
		Scanner scnItem = new Scanner(new File("Invmast.txt"));
		while (scnItem.hasNextLine()) {
			String id = scnItem.next();
			double price = scnItem.nextDouble();
			int quantity = scnItem.nextInt();
			int reorder = scnItem.nextInt();
			int min = scnItem.nextInt();
			Item item = new Item(id, price, quantity, reorder, min);
			inventoryManager.addItem(item);
		}
		scnItem.close();
		
		/*
		 * Read the input file "Transact.txt"
		 */
		
		Scanner scnTrans = new Scanner(new File("Transact.txt"));
		while (scnTrans.hasNextLine()) {
			String id = scnTrans.next();
			int quantity = scnTrans.nextInt();
			String isSold = scnTrans.next();
			Transaction transaction = new Transaction(id, quantity, isSold);
			inventoryManager.addTransaction(transaction);
		}
		scnTrans.close();
		
		/*
		 * Processing
		 */
		inventoryManager.processInventory();
		inventoryManager.processOrderReport();
		inventoryManager.writeToFile();
		inventoryManager.displayResult();
	}

}
