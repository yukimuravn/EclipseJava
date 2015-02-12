import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MainProgram {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Report report = new Report();
		
		//Read input file ("courseGrade.txt")
		Scanner scnCourse = new Scanner(new File("courseGrade.txt"));
		while (scnCourse.hasNext()) {
			int id = scnCourse.nextInt();
			int test1 = scnCourse.nextInt();
			int test2 = scnCourse.nextInt();
			int test3 = scnCourse.nextInt();
			int test4 = scnCourse.nextInt();
			int test5 = scnCourse.nextInt();
			Course course = new Course(id, test1, test2, test3, test4, test5);
			course.calAvrScore();
			report.addCourse(course);
		}
		scnCourse.close();
		
		//Read input file ("studentRecords.txt")
		Scanner scnStd = new Scanner(new File("studentRecords.txt"));
		while (scnStd.hasNextLine()) {
			int id = scnStd.nextInt();
			String name = scnStd.next();
			int credit = scnStd.nextInt();
			float gpa = scnStd.nextFloat();
			Student student = new Student(id, name, credit, gpa);
			report.addStudent(student);
		}
		scnStd.close();
		
		report.calClassAvr();
		report.processGrade();
		report.processNewGPA();
	}

}
