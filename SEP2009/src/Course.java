import java.util.Comparator;


public class Course {
	int studentID;
	int score_1;
	int score_2;
	int score_3;
	int score_4;
	int score_5;
	double avrScore;
	String gradeRslt;
	
	public Course(int studentID, int score_1, int score_2, int score_3, int score_4, int score_5)
	{
		super();
		this.studentID = studentID;
		this.score_1 = score_1;
		this.score_2 = score_2;
		this.score_3 = score_3;
		this.score_4 = score_4;
		this.score_5 = score_5;
	}
	
	public int getStudentID()
	{
		return studentID;
	}
	
	public void setStudentID(int studentID)
	{
		this.studentID = studentID;
	}
	
	public int getScore_1()
	{
		return score_1;
	}
	
	public void setScore_1(int score_1)
	{
		this.score_1 = score_1;
	}

	public int getScore_2()
	{
		return score_2;
	}
	
	public void setScore_2(int score_2)
	{
		this.score_2= score_2;
	}
	
	public int getScore_3()
	{
		return score_3;
	}
	
	public void setScore_3(int score_3)
	{
		this.score_3= score_3;
	}

	public int getScore_4()
	{
		return score_4;
	}
	
	public void setScore_4(int score_4)
	{
		this.score_4= score_4;
	}

	public int getScore_5()
	{
		return score_5;
	}
	
	public void setScore_5(int score_5)
	{
		this.score_5 = score_5;
	}
	
	public void calAvrScore()
	{
		double scr = (score_1 + score_2 + score_3 + score_4 + score_5)/5.0d;
		this.avrScore = scr;
	}
	
	public double getAvrScore() 
	{
		return avrScore;
	}
	
	public void calGrade()
	{
		if (avrScore >= 90.0) {
			this.gradeRslt = "A";
		}
		else if (avrScore < 90 && avrScore >= 80.0) {
			this.gradeRslt = "B";
		}
		else if (avrScore < 80 && avrScore >= 70.0) {
			this.gradeRslt = "C";
		}
		else if (avrScore < 70.0 && avrScore >= 60.0) {
			this.gradeRslt = "D";
		}
		else {
			this.gradeRslt = "F";
		}
	}
	
	public String getGrade()
	{
		return gradeRslt;
	}
	
	public static Comparator<Course> sortDescAvr = new Comparator<Course>() 
	{		
		public int compare (Course item1, Course item2)
		{
			double scr1 = item1.getAvrScore();
			double scr2 = item2.getAvrScore();
			int i = Double.compare(scr2, scr1);
			return i;
		}
	}; 
}
