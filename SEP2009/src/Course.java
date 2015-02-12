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

	public void calAvrScore()
	{
		double scr = (score_1 + score_2 + score_3 + score_4 + score_5)/5.0d;
		
		if (scr >= 90.0) {
			this.gradeRslt = "A";
		}
		else if (scr < 90 && scr >= 80.0) {
			this.gradeRslt = "B";
		}
		else if (scr < 80 && scr >= 70.0) {
			this.gradeRslt = "C";
		}
		else if (scr < 70.0 && scr >= 60.0) {
			this.gradeRslt = "D";
		}
		else {
			this.gradeRslt = "F";
		}
		
		this.avrScore = scr;
	}
	
	public double getAvrScore() 
	{
		return avrScore;
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
			//double res = scr1 - scr2; //Sort by ascending 
			double res = scr2 - scr1; //Sort by descending
			if(res > 0) {
				return 1;
			}
			else if (res == 0) {
				return 0;
			}
			else {
				return -1;
			}
		}

	}; 
}
