import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (grades.size() > 0) ? (double) sum / grades.size() : 0.0;
    }

    int getHighest() {
        int highest = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return (grades.size() > 0) ? highest : 0;
    }

    int getLowest() {
        int lowest = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return (grades.size() > 0) ? lowest : 0;
    }

    void displaySummary() {
        System.out.println("\nStudent: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("----------------------------");
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = sc.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = sc.nextInt();
                student.addGrade(grade);
            }
            sc.nextLine(); // consume newline
            students.add(student);
        }

        // Display summary report for all students
        System.out.println("\n===== Summary Report =====");
        for (Student s : students) {
            s.displaySummary();
        }

        sc.close();
    }
}
