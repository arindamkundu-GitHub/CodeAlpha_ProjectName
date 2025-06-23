import java.util.Scanner;

public class StudentGradeTracker1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hello, Enter the Number of Subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;
	int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                i--;
                continue;
            }

            totalMarks += marks[i];
            if (marks[i] > highest) {
                highest = marks[i];
            }
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        System.out.println("\nYour Result is Here:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
	System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
        String grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);
        scanner.close();
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
