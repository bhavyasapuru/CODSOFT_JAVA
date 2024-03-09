import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();

        int[] marks = new int[subjects];
        int totalMarks = 0;

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / subjects;
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        
        String averagePercentageString = String.format("%.2f", averagePercentage);

        System.out.println("\nResults:");
        System.out.println("Total Obtained Marks: " + totalMarks+ "/"+(subjects*100));
        System.out.println("Average Percentage: " + averagePercentageString+"%");
        System.out.println("Grade: " + grade);

        
    }
}
