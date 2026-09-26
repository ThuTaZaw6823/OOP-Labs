package lab1.q3;

import lab1.q2.Employee;

public class EmployeeTeam {

    private Employee boss;
    private Employee employee;

    public EmployeeTeam(Employee boss, Employee employee) {
        this.boss = boss;
        this.employee = employee;
    }

    private void printDetails(Employee e) {
        System.out.println("First name: " + e.getFirstName());
        System.out.println("Last name: " + e.getLastName());
        System.out.println("Salary: " + e.getMonthlySalary());
    }

    public void printEmployeeDetails() {
        printDetails(employee);
    }

    public void printAllEmployeesDetails() {

        System.out.println("Boss:");
        printDetails(boss);

        System.out.println();

        System.out.println("Employee:");
        printDetails(employee);
    }

    public void updateSalaryOfEmployee(
        String firstname,
        double newSalary
    ) {

        if (newSalary > 0) {

            if (boss.getFirstName().equals(firstname)) {
                boss.setMonthlySalary(newSalary);
            }

            if (employee.getFirstName().equals(firstname)) {
                employee.setMonthlySalary(newSalary);
            }
        }
    }

    public void giveRaiseToAllEmployees() {
        boss.giveRaise();
        employee.giveRaise();
    }
}
