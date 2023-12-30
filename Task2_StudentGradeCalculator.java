import  java.util.Scanner;

public class Task2_StudentGradeCalculator {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator ");
        System.out.println("-----------------------");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Input marks for each subject and calculate total marks
        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in  Subject " + i + ": ");
            int subjectMarks = scanner.nextInt();
            totalMarks += subjectMarks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Assign grades based on the average percentage
        char Grade;
        if (averagePercentage>=90){
            Grade ='O';
        }
        else if (averagePercentage>=80){
            Grade ='A';
        }
        else if (averagePercentage>=70){
            Grade ='B';
        }
        else if (averagePercentage>=60){
            Grade ='C';
        }
        else if (averagePercentage>=50){
            Grade ='D';
        }
        else {
            Grade ='F';
        }

        // Display results
        System.out.println("Total Marks Scored is "+totalMarks);
        System.out.println("Average Percentage Gained is "+averagePercentage+"%");
        System.out.println("Grade :"+Grade);
        scanner.close();

    }
}



