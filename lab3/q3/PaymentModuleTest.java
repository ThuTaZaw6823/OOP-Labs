package lab3.q3;

public class PaymentModuleTest {

    public static void main(String[] args) {

        PaymentModule module = new PaymentModule();

        Employee e1 = new Fulltimer("John", 20000);
        Employee e2 = new Hourly("Mike", 100, 20);
        Employee e3 = new Manager("David", 5000, 5);
        Employee e4 = new Manager("Robert", 5000, 12);

        module.payment(e1);
        module.payment(e2);
        module.payment(e3);
        module.payment(e4);

        System.out.println("Total pay: " + module.getTotalPay());
    }
}