package lab4.q2;

import java.util.Scanner;

public class PSUStudentTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter age: ");
            int age = input.nextInt();

            System.out.print("Enter GPA: ");
            double gpa = input.nextDouble();

            new UndergradStudent(age, gpa);
            new GradStudent(age, gpa);

            System.out.println("UndergradStudent created successfully.");
            System.out.println("GradStudent created successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }
}
