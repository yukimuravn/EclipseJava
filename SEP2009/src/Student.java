import java.util.Comparator;


public class Student {
	int stdID;
	String lastName;
	int creditHours;
	double curGPA;
	String grade;
	
	public Student(int stdID, String lastName, int creditHours, float curGPA)
	{
		super();
		this.stdID = stdID;
		this.lastName = lastName;
		this.creditHours = creditHours;
		this.curGPA = curGPA;
	}
	
	public int getStdID()
	{
		return stdID;
	}
	
	public void setStdID(int stdID)
	{
		this.stdID = stdID;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public int getCreditHours()
	{
		return creditHours;
	}
	
	public void setCreditHours(int creditHours)
	{
		this.creditHours = creditHours;
	}
	
	public double getCurGPA()
	{
		return curGPA;
	}
	
	public void setCurGPA(float curGPA)

	{
		this.curGPA = curGPA;
	}
	
	public static Comparator<Student> sortIncID = new Comparator<Student>() 
			{		
				public int compare (Student item1, Student item2)
				{
					int id1 = item1.getStdID();
					int id2 = item2.getStdID();
					return id1 - id2;
				}
			}; 
}
