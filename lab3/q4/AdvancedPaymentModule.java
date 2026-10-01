package lab3.q4;

import lab3.q3.Employee;
import lab3.q3.PaymentModule;

public class AdvancedPaymentModule extends PaymentModule {

    public void payment(Employee[] employees) {

        for (Employee employee : employees) {
            super.payment(employee);
        }
    }
}