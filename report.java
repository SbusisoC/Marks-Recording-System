

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


	
// Creating a loop to the number of students.
	public class report {
		public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
			
			//Output
			System.out.print("Enrollment: ");
			
			//Wait for the user to enter something
			int numberOfTimesToRepeat = scanner.nextInt();
			scanner.nextLine();
			
			
			
			List<Student> studentList = new ArrayList<>();

			for(int i=0; i < numberOfTimesToRepeat; i++) {

        // Input from user and print
		String studentName = getInputAndPrint1("Mr/Miss", scanner);
        int english = getInputAndPrint("English", scanner);
        int isiZulu = getInputAndPrint("IsiZulu", scanner);
        int math = getInputAndPrint("Math", scanner);
        int physicalScience = getInputAndPrint("Physical Science", scanner);
        int socialScienceEMS = getInputAndPrint("Social Science & EMS", scanner);
        int history = getInputAndPrint("History", scanner);
        int lifeOrientation = getInputAndPrint("Life Orientation", scanner);
        int technology = getInputAndPrint("Technology", scanner);
        

        // Calculating the average performance
        double averagePerformance = calculateAveragePerformance(english, isiZulu, math, physicalScience,
                socialScienceEMS, history, lifeOrientation, technology);
        
        
        /*System.out.println("Overall Performance: " + averagePerformance);*/
        
        //Creating a student object and add it to the list
        
        Student student = new Student(studentName, averagePerformance, english, isiZulu, math, physicalScience,
                socialScienceEMS, history, lifeOrientation, technology);
        studentList.add(student);
	}
	scanner.close(); 
	
	for(Student student : studentList) {
		printStudentReport(student);
	}
		
	
	Collections.sort(studentList, Comparator.comparingDouble(Student::getAveragePerformance).reversed());

    System.out.println("\nTop-performing students (Positions in ascending order):");
    int position = 1; // Counter for positions

    for (Student student : studentList) {
        System.out.println(position + ". " + student.getName() + ": " + student.getAveragePerformance());
        position++;
        
     }
  }
		
		 private static void printStudentReport(Student student) {
		        System.out.println("------------------------------------------------------------");
		        System.out.println("Student Name: " + student.getName());
		        System.out.println("Overall Performance: " + student.getAveragePerformance());
		        System.out.println("Subject Performance:");
		        System.out.println("English: " + student.getEnglish());
		        System.out.println("IsiZulu: " + student.getIsiZulu());
		        System.out.println("Math: " + student.getMath());
		        System.out.println("Physical Science: " + student.getPhysicalScience());
		        System.out.println("Social Science & EMS: " + student.getSocialScienceEMS());
		        System.out.println("History: " + student.getHistory());
		        System.out.println("Life Orientation: " + student.getLifeOrientation());
		        System.out.println("Technology: " + student.getTechnology());
		        System.out.println("------------------------------------------------------------");
		    }
			
    private static String getInputAndPrint1(String student, Scanner scanner) {
	   System.out.print(student + ": ");
	   String studentName = scanner.next();
	   return studentName;   
    }
    
    private static int getInputAndPrint(String subject, Scanner scanner) {
        System.out.print(subject + ": ");
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                value = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
                System.out.print(subject + ": ");
            }
        }
        printGradeAndComment(value);
        return value;
    }

	            
	/*private static int getInputAndPrint(String subject, Scanner scanner) {
	   System.out.print(subject + ": ");
	   int value = scanner.nextInt();
	   printGradeAndComment(value);
	   return value;
	}*/
	            
    private static void printGradeAndComment(int value) {
        if (value >= 80) {
            System.out.println("Grade: A");
            System.out.println("Comment: Excellent performance.");
        } else if (value >= 70) {
            System.out.println("Grade: B");
            System.out.println("Comment: Good performance.");
        } else if (value >= 60) {
            System.out.println("Grade: C");
            System.out.println("Comment: Room for improvement.");
        } else if (value >= 50) {
            System.out.println("Grade: D");
            System.out.println("Comment: Apply yourself more.");
        } else {
            System.out.println("Grade: F");
            System.out.println("Comment: Poor performance. Homework.");
        }
        
        }

    private static double calculateAveragePerformance(int english, int isiZulu, int math, int physicalScience,
                                                      int socialScienceEMS, int history, int lifeOrientation, int technology) {
        int sum = english + isiZulu + math + physicalScience + socialScienceEMS + history + lifeOrientation + technology;
        return(double) sum / 8;
    }
}
	class Student {
		private String name;
	    private double averagePerformance;
	    private int english;
	    private int isiZulu;
	    private int math;
	    private int physicalScience;
	    private int socialScienceEMS;
	    private int history;
	    private int lifeOrientation;
	    private int technology;
	    
	    public Student(String name, double averagePerformance, int english, int isiZulu, int math, int physicalScience,
                int socialScienceEMS, int history, int lifeOrientation, int technology) {
     this.name = name;
     this.averagePerformance = averagePerformance;
     this.english = english;
     this.isiZulu = isiZulu;
     this.math = math;
     this.physicalScience = physicalScience;
     this.socialScienceEMS = socialScienceEMS;
     this.history = history;
     this.lifeOrientation = lifeOrientation;
     this.technology = technology;   
	}
	    
	 // Getters for subject-wise performance
	    public int getEnglish() {
	        return english;
	    }

	    public int getIsiZulu() {
	        return isiZulu;
	    }

	    public int getMath() {
	        return math;
	    }

	    public int getPhysicalScience() {
	        return physicalScience;
	    }

	    public int getSocialScienceEMS() {
	        return socialScienceEMS;
	    }

	    public int getHistory() {
	        return history;
	    }

	    public int getLifeOrientation() {
	        return lifeOrientation;
	    }

	    public int getTechnology() {
	        return technology;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getAveragePerformance() {
	        return averagePerformance;
	    }
	}
	
	   /* private String name;
	    private double averagePerformance;

	    public Student(String name, double averagePerformance) {
	        this.name = name;
	        this.averagePerformance = averagePerformance;
	    }

	    public String getName() {
	        return name;
	    }
	    
	    public double getAveragePerformance() {
	    	return averagePerformance;
	    }
	}*/

