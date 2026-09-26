package lab1.q4;

public class Account {

    private String name;
    private double balance;

    public Account(String name, double balance) {

        this.name = name;

        if (balance > 0) {
            this.balance = balance;
        }
        else {
            this.balance = 0;
        }
    }

    public void deposit(double depositAmount) {

        if (depositAmount > 0) {
            balance = balance + depositAmount;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
}
