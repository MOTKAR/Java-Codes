class Student {
    // Private data members
    private String name;
    private int rollNo;
    private int[] marks = new int[5];
    private char[] subjectGrades = new char[5];
    private double[] subjectPercentage = new double[5];
    private double average;
    private char overallGrade;

    private String[] subjects = {
        "Mathematics", "Physics", "Chemistry", "English", "Computer Science"
    };

    // Constructor
    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        calculateSubjectGrades();
        calculateSubjectPercentage();
        calculateAverage();
        calculateOverallGrade();
    }

    // Calculate grade for each subject
    private void calculateSubjectGrades() {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 75)
                subjectGrades[i] = 'A';
            else if (marks[i] >= 60)
                subjectGrades[i] = 'B';
            else if (marks[i] >= 40)
                subjectGrades[i] = 'C';
            else
                subjectGrades[i] = 'F';
        }
    }

    // Calculate percentage for each subject
    private void calculateSubjectPercentage() {
        for (int i = 0; i < marks.length; i++) {
            subjectPercentage[i] = (marks[i] / 100.0) * 100;
        }
    }

    // Calculate average marks
    private void calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        average = sum / 5.0;
    }

    // Calculate overall grade
    private void calculateOverallGrade() {
        if (average >= 75)
            overallGrade = 'A';
        else if (average >= 60)
            overallGrade = 'B';
        else if (average >= 40)
            overallGrade = 'C';
        else
            overallGrade = 'F';
    }

    // Display student details
    public void displayDetails() {

        System.out.println("\n                    STUDENT RESULT CARD                     \n");

        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + rollNo);
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-25s %-10s %-15s %-10s\n", "Subject", "Marks", "Percentage", "Grade");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf(
                "%-25s %-10d %-14.2f%% %-10c\n",
                subjects[i], marks[i], subjectPercentage[i], subjectGrades[i]
            );
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("Average Marks : %.2f\n", average);
        System.out.println("Overall Grade : " + overallGrade);
        System.out.println("══════════════════════════════════════════════════════════════════════════\n");
    }
}

public class Lab_Assignment_1 {
    public static void main(String[] args) {

        System.out.println("\n           STUDENT MANAGEMENT SYSTEM - RESULTS            \n");

        int[] marks1 = {65, 50, 78, 88, 90};
        Student s1 = new Student("Swapnil Motkar", 101, marks1);
        s1.displayDetails();

        int[] marks2 = {78, 82, 75, 65, 85};
        Student s2 = new Student("Om Patni", 102, marks2);
        s2.displayDetails();

        int[] marks3 = {92, 55, 95, 91, 40};
        Student s3 = new Student("Sakshi Naikwade", 103, marks3);
        s3.displayDetails();

        int[] marks4 = {65, 70, 50, 72, 20};
        Student s4 = new Student("Pranav Mode", 104, marks4);
        s4.displayDetails();

        int[] marks5 = {45, 55, 48, 50, 52};
        Student s5 = new Student("Akash", 105, marks5);
        s5.displayDetails();

        System.out.println("                Total Students Processed: 5              \n");
    }
}
