
public class Member {
	String id;
	String name;
	int numberOfBooks;
	int numberOfDVD;
	int numberOfCD;
	boolean bookStt;
	boolean dvdStt;
	boolean cdStt;
	
	public Member() {
		
	}
	
	public Member (String id, String name, int numberOfBooks, int numberOfDVD, int numberOfCD) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfBooks = numberOfBooks;
		this.numberOfDVD = numberOfDVD;
		this.numberOfCD = numberOfCD;
	}

	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	
	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}
	
	public boolean getBookStt() {
		int totalBook = this.numberOfBooks + 1;
		if (totalBook > 15) {
			this.bookStt = false;
		}
		else {
			this.bookStt = true;
		}
		return bookStt;
	}
	
	public void addNumberOfBooks() {
		this.numberOfBooks ++;
	}
	
	public int getNumberOfDVD() {
		return numberOfDVD;
	}
	
	public void setNumberOfDVD (int numberOfDVD) {
		this.numberOfDVD = numberOfDVD;
	}
	
	public boolean getDVDStt() {
		int totalDVD = this.numberOfDVD + 1;
		if (totalDVD > 10) {
			this.dvdStt = false;
		}
		else {
			this.dvdStt = true;
		}
		return dvdStt;
	}
	
	public void addNumberOfDVD() {
		this.numberOfDVD ++;
	}
	
	public int getNumberOfCD() {
		return numberOfCD;
	}
	
	public void setNumberOfCD(int numberOfCD) {
		this.numberOfCD = numberOfCD;
	}
	
	public boolean getCDStt() {
		int totalCD = this.numberOfCD + 1;
		if (totalCD > 5) {
			this.cdStt = false;
		}
		else {
			this.cdStt = true;
		}
		return cdStt;
	}
	
	public void addNumberOfCD() {
		this.numberOfCD ++;
	}
	
}

