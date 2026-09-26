package lab1.q3;

import lab1.q2.Employee;

public class EmployeeTeamTest {

    public static void main(String[] args) {

        Employee boss =
            new Employee("John", "Smith", 50000);

        Employee employee =
            new Employee("Alice", "Brown", 30000);

        EmployeeTeam team =
            new EmployeeTeam(boss, employee);

        System.out.println("Employee details:");
        team.printEmployeeDetails();

        System.out.println();
        System.out.println("All employee details:");
        team.printAllEmployeesDetails();

        System.out.println();
        System.out.println("After updating Alice salary:");

        team.updateSalaryOfEmployee("Alice", 35000);
        team.printAllEmployeesDetails();

        System.out.println();
        System.out.println("After 10% raise:");

        team.giveRaiseToAllEmployees();
        team.printAllEmployeesDetails();
    }
}
