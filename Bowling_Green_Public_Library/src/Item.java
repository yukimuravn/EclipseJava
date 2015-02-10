import java.util.Comparator;


public class Item {
	int id;
	int copies;
	String type;
	String title;
	boolean isAlrCheckOut = false;
	
	public Item(int id, int copies, String type, String title) {
		super();
		this.id = id;
		this.copies = copies;
		this.type = type;
		this.title = title;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getCopies() {
		return copies;
	}
	
	public boolean itemCanCheckOut() {
		int decreaseCopies = this.copies - 1;
		//System.out.println(decreaseCopies);
		if (decreaseCopies >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setCopies(int copies) {
		this.copies = copies;
	}
	
	public void decreaseCopies() {
		this.isAlrCheckOut = true;
		this.copies --;
	}
	
	public boolean getIsAlrCheckOutStt() {
		return isAlrCheckOut;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public static Comparator<Item> sortID = new Comparator<Item>() {
		
		public int compare (Item item1, Item item2)
		{
			int id1 = item1.getID();
			int id2 = item2.getID();
			
			return id1 - id2;
		}
	};
}
