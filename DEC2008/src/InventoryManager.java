import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class InventoryManager {
	List<Item> processedItemList;
	List<Item> sortedProcessedItemList;
	List<Item> itemList;
	List<Transaction> transactionList;
	
	public InventoryManager() {
		this.itemList = new ArrayList<Item>();
		this.transactionList = new ArrayList<Transaction>();
	}
	/*
	 * add Item to the itemList
	 */
	public void addItem(Item item) {
		itemList.add(item);
	}
	
	/*
	 * add Transaction to the transactionList
	 */
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}
	
	/*
	 * process Inventory (itemList)
	 */
	public void processInventory() {
		this.processedItemList = new ArrayList<Item>(itemList);
		for (Item item : processedItemList) {
			for (Transaction transaction : transactionList) {
				if (item.getID().equals(transaction.getItemID())) {
					item.setQuantity(transaction.getQuantity(), transaction.isSoldType());
				}
			}
		}
	}
	
	/*
	 * process OrderReport
	 */
	public void processOrderReport() {
		this.sortedProcessedItemList = new ArrayList<>(processedItemList);		
		Iterator<Item> iterator = sortedProcessedItemList.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			if (item.getQuantity() < item.getReorderPoint()) {
				item.processOrderAmount();
			}
			else {
				// Remove those item that do not need to order (OrderAmount >= 0)
				iterator.remove();
			}
			
		}
		// Sort processedItemList ascending by orderAmount
		Collections.sort(sortedProcessedItemList, Item.sortAscOrderAmount);
	}
	
	/*
	 * Display the result to screen
	 */
	public void displayResult() {
		StringBuilder output = new StringBuilder();
		for (Item item : processedItemList) {
			output.append(item.getID()).append("\t");
			output.append(item.getPrice()).append("\t");
			output.append(item.getQuantity()).append("\t");
			output.append(item.getReorderPoint()).append("\t");
			output.append(item.getMinimumOrder()).append("\t");
			output.append("\n");
		}
		System.out.println(output.toString());
		
		StringBuilder output2 = new StringBuilder();
		for (Item item : sortedProcessedItemList) {
			output2.append(item.getID()).append("\t");
			output2.append(item.getPrice()).append("\t");
			output2.append(item.getOrderAmount()).append("\t");
			output2.append("\n");
		}
		System.out.println(output2.toString());
	}
	
	/*
	 * Write to file
	 */
	public void writeToFile() throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter(new File("Newmast.txt"));
		StringBuilder output = new StringBuilder();
		for (Item item : processedItemList) {
			output.append(item.getID()).append("\t");
			output.append(item.getPrice()).append("\t");
			output.append(item.getQuantity()).append("\t");
			output.append(item.getReorderPoint()).append("\t");
			output.append(item.getMinimumOrder()).append("\t");
			output.append("\n");
		}
		printWriter.println(output.toString());
		printWriter.close();
	}
}
