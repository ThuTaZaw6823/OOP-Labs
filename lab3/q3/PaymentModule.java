package lab3.q3;

public class PaymentModule {

    protected double totalPay;

    public PaymentModule() {
        totalPay = 0;
    }

    public void payment(Employee employee) {

        double pay = employee.computePay();

        if (employee instanceof Manager) {
            Manager manager = (Manager) employee;

            if (manager.getWorkYear() > 10) {
                pay = pay * 2;
            }
        }

        totalPay = totalPay + pay;
    }

    public double getTotalPay() {
        return totalPay;
    }
}