package lab1.q2;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee employee1 =
            new Employee("John", "Smith", 30000);

        System.out.println("First name: " + employee1.getFirstName());
        System.out.println("Last name: " + employee1.getLastName());
        System.out.println("Monthly salary: " + employee1.getMonthlySalary());

        employee1.setFirstName("Peter");
        employee1.setLastName("Brown");
        employee1.setMonthlySalary(35000);

        System.out.println();
        System.out.println("After modification:");

        System.out.println("First name: " + employee1.getFirstName());
        System.out.println("Last name: " + employee1.getLastName());
        System.out.println("Monthly salary: " + employee1.getMonthlySalary());

        Employee employee2 =
            new Employee("Alice", "Green", 40000);

        System.out.println();
        System.out.println("Yearly salaries:");

        System.out.println(
            employee1.getFirstName() + ": " +
            employee1.getYearlySalary()
        );

        System.out.println(
            employee2.getFirstName() + ": " +
            employee2.getYearlySalary()
        );

        employee1.giveRaise();
        employee2.giveRaise();

        System.out.println();
        System.out.println("After 10% raise:");

        System.out.println(
            employee1.getFirstName() + ": " +
            employee1.getYearlySalary()
        );

        System.out.println(
            employee2.getFirstName() + ": " +
            employee2.getYearlySalary()
        );
    }
}   
