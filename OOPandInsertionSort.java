import java.util.*;
class Student {
	
	private String name;
	private int rollNumber;
	private int marks;
	
	public Student (String name, int rollNumber, int marks) {
		
		this.name = name;
		this.rollNumber = rollNumber;
		setMarks(marks);
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public int getRollNumber() {
		
		return rollNumber;
		
	}
	
	public void setMarks(int marks) {
		
		if (marks >= 0 && marks <= 100) {
			
			this.marks = marks;
			return;
			
		}
		
		System.out.println ("Marks should be less than or equal to 100 and greater than or equal to 0");
		
	}
	
	public int getMarks() {
		
		return marks;
		
	}
	
	public String toString() {

		return "Student name : "+name+", rollNumber : "+rollNumber+", marks : "+marks;
		
	}
	
}

public class OOPandInsertionSort {
	public static void main (String...args) {
		
		Scanner sc = new Scanner (System.in);
		
		String continueProgram;
		
		ArrayList<Student> students = new ArrayList<>();
		
		do {
			
			System.out.print("Enter your name : ");
			String name = sc.nextLine();
			
			System.out.print("Enter your rollnumber : ");
			int rollNumber = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter your marks : ");
			int marks = Integer.parseInt(sc.nextLine());
			
			Student st = new Student(name,rollNumber,marks);
			
			students.add(st);
			
			System.out.print("Do you want to continue this program : (y || n) : ");
			continueProgram = sc.next();
			sc.nextLine();
			System.out.println();
			
		} while (continueProgram.equalsIgnoreCase("y"));
		
		
		//Insertion sort part

		for (int i = 1; i < students.size(); i++) {

			Student keyStudent = students.get(i);
			
			int j = i - 1;
			
			while (j >= 0 && students.get(j).getMarks() > keyStudent.getMarks()) {
				
				students.set(j + 1, students.get(j));
				j--;
				
			}
			
			students.set(j + 1, keyStudent);
			
		}
		
		System.out.println ("Sorted student list by marks");
		System.out.println ("____________________________")
		
		for (int k = 0; k < students.size(); k++) {
			
			System.out.println (students.get(k));
			System.out.println();
		}
		
	}
	
}
			
			
			

			