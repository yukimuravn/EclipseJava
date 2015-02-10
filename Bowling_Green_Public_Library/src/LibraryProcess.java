import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class LibraryProcess {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		CheckOutProcess checkOutProcess = new CheckOutProcess();
		
		//Read input file members.txt
		Scanner scnMembers = new Scanner(new File("members.txt"));
		while (scnMembers.hasNextLine()) {
			String memberID = scnMembers.next();
			String name = scnMembers.next();
			int numberOfBooks = scnMembers.nextInt();
			int numberOfDVD = scnMembers.nextInt();
			int numberOfCD = scnMembers.nextInt();
			checkOutProcess.addMember(memberID, name, numberOfBooks, numberOfDVD, numberOfCD);
		}
		scnMembers.close();
		/*
		for (Member member : checkOutProcess.memberList) {
			System.out.println(member.id);
			System.out.println(member.name);
			System.out.println(member.numberOfBooks);
			System.out.println(member.numberOfDVD);
			System.out.println(member.numberOfCD);
		}
		*/
		
		//Read input file inventory.txt
		Scanner scnInv = new Scanner(new File("inventory.txt"));
		while (scnInv.hasNextLine()) {
			int itemID = scnInv.nextInt();
			int copies = scnInv.nextInt();
			String type = scnInv.next();
			String title = scnInv.next();
			checkOutProcess.addItem(itemID, copies, type, title);
		}
		scnInv.close();
		/*
		for (Item item : checkOutProcess.itemList) {
			System.out.println(item.id);
			System.out.println(item.copies);
			System.out.println(item.type);
			System.out.println(item.title);
		}
		*/
		
		//Read input file checkout.txt		
		Scanner scnChckOut = new Scanner(new File("checkout.txt"));
		ArrayList<Item> itemList = new ArrayList<>();
		String memberID = scnChckOut.nextLine();
		Member checkOutMember = new Member();
		
		for (Member member : checkOutProcess.getMemberList()) {
			if (memberID.equals(member.id)) {
				checkOutMember = new Member(member.id, member.name, member.numberOfBooks, member.numberOfDVD, member.numberOfCD);
				break;
			}
		}
		while (scnChckOut.hasNextLine()) {
			int itemID = scnChckOut.nextInt();
			for (Item item : checkOutProcess.getItemList()) {
				if (itemID == item.id) {
					itemList.add(item);
					break;
				}
			}
		}
		checkOutProcess.addCheckOutInfo(checkOutMember, itemList);
		scnChckOut.close();
		/*
		System.out.println(checkOutProcess.checkOutInfo.memberID);
		for (Integer list : checkOutProcess.checkOutInfo.itemList) {
			System.out.println(list);
		}
		*/
		
		//Process 
		//checkOutProcess.processCheckedOutItem();
		/*
		System.out.println(checkOutProcess.checkOutInfo.memberID);
		for (Item item : checkOutProcess.checkOutInfo.itemList) {
			System.out.println(item.id);
			System.out.println(item.copies);
			System.out.println(item.type);
			System.out.println(item.title);
		}
		System.out.println(checkOutProcess.checkOutInfo.chckOutBooks);
		System.out.println(checkOutProcess.checkOutInfo.chckOutDVD);
		System.out.println(checkOutProcess.checkOutInfo.chckOutCD);
		*/
		
		checkOutProcess.processMemInv();
		/*
		for (Member member : checkOutProcess.memberList) {
			System.out.printf("%s %s %d %d %d \n",member.id, member.name, member.numberOfBooks, member.numberOfDVD, member.numberOfCD);

		}
		*/
		
		//checkOutProcess.processNewInv();
		
		//Print out the result
		checkOutProcess.displayNewInv();
		checkOutProcess.displayNewMem();
		checkOutProcess.displayCheckOutItemDetails();
	}

}
