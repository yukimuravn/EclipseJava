import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Report {
	List<Course> courseList;
	List<Student> studentList;
	float classAvrScore;
	
	public Report()
	{
		courseList = new ArrayList<Course>();
		studentList = new ArrayList<Student>();
	}
	
	public void addCourse(Course course)
	{
		courseList.add(course);
	}
	
	public void addStudent(Student student)
	{
		studentList.add(student);
	}
	
	public void calClassAvr()
	{
		float total = 0;
		int studentNo = 0;
		for (Course course : courseList) {
			total += course.getAvrScore();
			studentNo++;
		}
		this.classAvrScore = total/studentNo;
	}
	
	public void processGrade() throws FileNotFoundException 
	{
		Collections.sort(courseList, Course.sortDescAvr);
		PrintWriter printWriter = new PrintWriter(new File("gradeReport.txt"));
		for (Course course : courseList) {
			for (Student student : studentList) {
				if (course.getStudentID() == student.stdID) {
					System.out.printf("%d %s %.2f %s \n", course.getStudentID(), student.getLastName(), course.getAvrScore(), course.getGrade());
					printWriter.printf("%d %s %.2f %s \n", course.getStudentID(), student.getLastName(), course.getAvrScore(), course.getGrade());
					break;
				}
			}
		}
		System.out.printf("\nClass average = %.2f \n", classAvrScore);
		printWriter.printf("\nClass average = %.2f \n", classAvrScore);
		printWriter.close();
	}
	
	public void processNewGPA() throws FileNotFoundException
	{
		Collections.sort(studentList, Student.sortIncID);
		PrintWriter printWriter = new PrintWriter(new File("GPA_Report.txt"));
		System.out.println();
		System.out.println("	Overall Student GPA Report \n");
		printWriter.println("	Overall Student GPA Report \n");
		System.out.println("ID  	 Name	Credit Hrs.	GPA");
		printWriter.println("ID	 	 Name	Credit Hrs.	GPA");
		
		for (Student student : studentList) {
			int newCreditHours = student.getCreditHours() + 3;
			double newGradePoints = 0;
			if (student.getCurGPA() > 3.0) 
			{
				newGradePoints = student.getCreditHours() * student.getCurGPA() + 3*4.0;
			}
			else if (student.getCurGPA() <= 3.0 && student.getCurGPA() > 2.0) 
			{
				newGradePoints = student.getCreditHours() * student.getCurGPA() + 3*3.0;
			}
			else if (student.getCurGPA() <= 2.0 && student.getCurGPA() > 1.0) {
				newGradePoints = student.getCreditHours() * student.getCurGPA() + 3*2.0;
			}
			else {
				newGradePoints = student.getCreditHours() * student.getCurGPA() + 3*1.0;
			}
			double newGPA = newGradePoints/newCreditHours;
			
			System.out.printf("%-8d %-10s %d		%-1.2f\n", student.getStdID(), student.getLastName(), newCreditHours, newGPA);
			printWriter.printf("%-8d %-10s %d		%-1.2f\n", student.getStdID(), student.getLastName(), newCreditHours, newGPA);
		}
		printWriter.close();
	}
}
