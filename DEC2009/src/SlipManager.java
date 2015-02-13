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
	
	public SlipManager() {
		slipList = new ArrayList<Slip>();
		priceList = new ArrayList<Price>();
		performanceList = new ArrayList<Performance>();
		sortedPerformanceList = new ArrayList<Performance>();
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
	 * Display result to screen
	 */
	public void displayResult() {
		this.sortPerfList();
		for (Performance performance : sortedPerformanceList) {
			StringBuilder output = new StringBuilder();
			output.append(performance.getPersonID()).append("\t");
			for (Product product : performance.getProductList()) {
				output.append(product.getNumOfsales()).append("\t");				
			}
			output.append(performance.getPerformance());
			System.out.println(output.toString());
		}
	}
	
	
}

