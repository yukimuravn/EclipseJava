import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CheckOutProcess {
	List<Member> memberList;
	List<Item> itemList;
	CheckOutInfo checkOutInfo;
	
	public CheckOutProcess() {
		memberList = new ArrayList<Member>();
		this.itemList = new ArrayList<Item>();
	}
	
	public void addMember (String id, String name, int numberOfBooks, int numberOfDVD, int numberOfCD) {
		Member member = new Member(id, name, numberOfBooks, numberOfDVD, numberOfCD);
		this.memberList.add(member);
	}
	
	public List<Member> getMemberList() {
		return memberList;
	}
	
	public void addItem (int id, int copies, String type, String title) {
		Item item = new Item(id, copies, type, title);
		this.itemList.add(item);
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	
	public void addCheckOutInfo (Member member, ArrayList<Item> itemList) {
		this.checkOutInfo = new CheckOutInfo(member, itemList);
	}
	
	public CheckOutInfo getCheckOutInfo() {
		return checkOutInfo;
	}
	
	/*	//No need this function
	public void processCheckedOutItem() {
		for (Member member : memberList) {
			if (checkOutInfo.memberID.equals(member.id)) {
				checkOutInfo.setCheckOutBooks(member.numberOfBooks);
				checkOutInfo.setCheckOutDVD(member.numberOfDVD);
				checkOutInfo.setCheckOutCD(member.numberOfCD);
				break;
			}
		}
	}
	*/
	
	public void processMemInv() {
		for (Member member : memberList) {
			if (checkOutInfo.getMember().id.equals(member.id)) {
				for (Item item : checkOutInfo.itemList) {
					if (item.itemCanCheckOut()) {
						//System.out.println("item.itemCanCheckOut()");
						if (item.type.equals("B")) {
							if (member.getBookStt() ) {
								member.addNumberOfBooks();
								item.decreaseCopies();
								//System.out.println("BBB");
								//System.out.println(item.type);
								//System.out.println(item.copies);
								//System.out.println(member.numberOfBooks);
							}
						}
						else if (item.type.equals("C")) {
							if (member.getCDStt()) {
								member.addNumberOfCD();
								item.decreaseCopies();
								//System.out.println("CCC");
								//System.out.println(item.type);
								//System.out.println(item.copies);
								//System.out.println(member.numberOfCD);
							}	
						}
						else if (item.type.equals("D")) {
							if (member.getDVDStt()) {
								member.addNumberOfDVD();
								item.decreaseCopies();
								//System.out.println("DDD");
								//System.out.println(item.type);
								//System.out.println(item.copies);
								//System.out.println(member.numberOfDVD);
							}
						}
					}
				}
				break;
			}
			
		}
	}
	
	/*	//No need this function
	public void processNewInv() {
		for (Item item : checkOutInfo.itemList) {
			for (Item item0 : itemList) {
				if (item.id == item0.id) {
					item0.setCopies(item.copies);
					break;
				}
			}
		}
	}
	*/
	
	public void displayCheckOutItemDetails() {		
		//Sort itemList in checkOutInfo by itemID
		ArrayList<Item> list = checkOutInfo.getItemList();
		Collections.sort(list, Item.sortID);
		
		System.out.println("Checked out items:");
		for (Item item : list) {
			if (item.getIsAlrCheckOutStt()) {
				System.out.printf("%s (%d) \n", item.title, item.id);
			}			
		}
		
		System.out.println();
		System.out.println("Not checked out items:");
		for (Item item : list) {
			if (!item.getIsAlrCheckOutStt()) {
				System.out.printf("%s (%d) \n", item.title, item.id);
			}			
		}
	}
	
	public void displayNewInv() {
		for (Item item : itemList) {
			System.out.printf("%d%3d%3s   %3s\n", item.id, item.copies, item.type, item.title);
		}
		System.out.println();
	}
	
	public void displayNewMem() {
		for (Member member : memberList) {
			System.out.printf("%s  %-10s %-3d%-3d%-3d\n", member.id, member.name, member.numberOfBooks, member.numberOfDVD, member.numberOfCD);
		}
		System.out.println();
	}
}
