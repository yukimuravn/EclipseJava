import java.util.ArrayList;


public class CheckOutInfo {
	Member member;
	ArrayList<Item> itemList;
	//int chckOutBooks;
	//int chckOutDVD;
	//int chckOutCD;
	
	public CheckOutInfo(Member member, ArrayList<Item> itemList) {
		super();
		this.member = member;
		this.itemList = itemList;
		//this.chckOutBooks = 0;
		//this.chckOutDVD = 0;
		//this.chckOutCD = 0;
	}

	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
	/*
	public int getCheckOutBooks() {
		return chckOutBooks;
	}
	
	public void setCheckOutBooks(int chckOutBooks) {
		this.chckOutBooks = chckOutBooks;
	}
	
	public int getCheckOutDVD() {
		return chckOutDVD;
	}
	
	public void setCheckOutDVD(int chckOutDVD) {
		this.chckOutDVD = chckOutDVD;
	}
	
	public int getCheckOutCD() {
		return chckOutCD;
	}
	
	public void setCheckOutCD(int chckOutCD) {
		this.chckOutCD = chckOutCD;
	}
	*/
}
