import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MainProgram {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		SlipManager slipManager = new SlipManager();
		
		Scanner scnSales = new Scanner(new File("slips.txt"));
		while (scnSales.hasNextLine()) {
			int perID = scnSales.nextInt();
			int proID = scnSales.nextInt();
			int num = scnSales.nextInt();
			Slip p = new Slip(perID, proID, num);
			slipManager.addSlip(p);
		}
		scnSales.close();
		
		Scanner scnPrice = new Scanner(new File("price.txt"));
		while (scnPrice.hasNextLine()) {
			int id = scnPrice.nextInt();
			double price = scnPrice.nextDouble();
			Price p = new Price(id, price);
			slipManager.addPrice(p);			
		}
		scnPrice.close();
		
		slipManager.addPerIDList();
		slipManager.addIDPerformance();
		slipManager.processProductList();
		slipManager.processTotalPerfList();
		slipManager.displayResult();
	}

}
