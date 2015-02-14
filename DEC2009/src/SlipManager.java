import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SlipManager {
	List<Slip> slipList;
	List<Price> priceList;
	List<Performance> performanceList;
	List<Performance> sortedPerformanceList;
	List<Salability> salesList;
	List<Salability> sortedSalesList;
	
	public SlipManager() {
		slipList = new ArrayList<Slip>();
		priceList = new ArrayList<Price>();
		performanceList = new ArrayList<Performance>();
		salesList = new ArrayList<Salability>();
	}
	
	public void addSlip(Slip p) {
		slipList.add(p);
	}
	
	public void addPrice(Price p) {
		priceList.add(p);
	}

	/*
	 * Add person ID to performance in performanceList
	 */
	public void addPerIDList() {
		List<Integer> list = new ArrayList<>();
		for (Slip slip : slipList) {
			list.add(slip.getPersonID());
		}
		Set<Integer> set = new HashSet<Integer>(list);
		List<Integer> idList = new ArrayList<>(set);
		Collections.sort(idList);
		
		for (Integer i : idList) {
			Performance p = new Performance(i);
			performanceList.add(p);
		}
	}
	
	/*
	 * Add product ID to performance in performanceList
	 */
	public void addIDPerformance() {
		for (Performance performance : performanceList) {
			performance.setProductID(priceList);
		}	
	}
	
	/*
	 * Process each product in productList of each person in performanceList
	 */	
	public void processProductList() {
		for (Performance performance : performanceList) {
			for (Slip slip : slipList) {
				if (performance.getPersonID() == slip.getPersonID()) {
					performance.processProductList(slip);
				}
			}
		}
	}
	
	/*
	 * Process performance of each person in performanceList
	 */	
	public void processTotalPerfList() {
		for (Performance performance : performanceList) {
			performance.calculatePerformance();
		}
	}
	
	/*
	 * Copy performanceList to sortedPerformanceList and sort descending by performance
	 */	
	public void sortPerfList() {
		sortedPerformanceList = new ArrayList<>(performanceList);
		Collections.sort(sortedPerformanceList, Performance.sortDescPerf);
	}
	
	/*
	 * Copy salesList to sortedSalesList and sort descending by totalValue
	 */
	public void sortSalesList() {
		sortedSalesList = new ArrayList<>(salesList);
		Collections.sort(sortedSalesList, Salability.sortDescTotal);
	}
	/*
	 * add Salary to SalabilityList
	 */
	public void addSalability() {
		for (Price price : priceList) {
			Salability s = new Salability(price);
			salesList.add(s);
		}		
	}
	
	/*
	 * process SalabilityList
	 */
	public void processSalability() {
		for (Salability salability : salesList) {
			for (Slip slip : slipList) {
				if (salability.getID() == slip.getProductID()) {
					salability.increaseNum(slip.getNumOfsales());
				}
			}
			salability.calTotalValue();
		}
	}
	
	/*
	 * Display result to screen
	 */
	public void displayResult() {
		//Display "salespersonPerformance.txt" to screen
		StringBuilder output = new StringBuilder();
		for (Performance performance : sortedPerformanceList) {			
			output.append(performance.getPersonID()).append("\t");
			for (Product product : performance.getProductList()) {
				output.append(product.getNumOfsales()).append("\t");				
			}
			output.append(performance.getPerformance());
			output.append("\n");			
		}
		System.out.println(output.toString());
		System.out.println();
		
		//Display "salability.txt" to screen
		StringBuilder output2 = new StringBuilder();
		for (Salability salability : sortedSalesList) {			
			output2.append(salability.getID()).append("\t");
			output2.append(salability.getNum()).append("\t");
			output2.append(salability.getTotalValue()).append("\t");
			output2.append("\n");
		}
		System.out.println(output2.toString());
	}
	
	/*
	 * write the result to file
	 */
	public void writeToFile() throws FileNotFoundException {
		//Write to file "salespersonPerformance.txt"
		PrintWriter printWriter = new PrintWriter(new File("salespersonPerformance.txt"));
		StringBuilder output = new StringBuilder();
		for (Performance performance : sortedPerformanceList) {			
			output.append(performance.getPersonID()).append("\t");
			for (Product product : performance.getProductList()) {
				output.append(product.getNumOfsales()).append("\t");				
			}
			output.append(performance.getPerformance());
			output.append("\n");
		}
		printWriter.println(output.toString());
		printWriter.close();
		
		//Write to file "salability.txt"
		PrintWriter printWriter2 = new PrintWriter(new File("salability.txt"));
		StringBuilder output2 = new StringBuilder();
		for (Salability salability : sortedSalesList) {	
			output2.append(salability.getID()).append("\t");
			output2.append(salability.getNum()).append("\t");
			output2.append(salability.getTotalValue()).append("\t");
			output2.append("\n");
		}
		printWriter2.println(output2.toString());
		printWriter2.close();
	}
}

