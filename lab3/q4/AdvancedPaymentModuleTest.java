package lab3.q4;

import lab3.q3.Employee;
import lab3.q3.Fulltimer;
import lab3.q3.Hourly;
import lab3.q3.Manager;

public class AdvancedPaymentModuleTest {

    public static void main(String[] args) {

        AdvancedPaymentModule module = new AdvancedPaymentModule();

        Employee[] employees = {
            new Fulltimer("John", 20000),
            new Hourly("Mike", 100, 20),
            new Manager("David", 5000, 5),
            new Manager("Robert", 5000, 12)
        };

        module.payment(employees);

        System.out.println("Total pay: " + module.getTotalPay());
    }
}