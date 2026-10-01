package lab3.q3;

public class Hourly extends Employee {

    private double rate;
    private int hour;

    public Hourly(String n, double r, int h) {
        name = n;
        hour = h;
        rate = r;
    }

    @Override
    public double computePay() {
        return hour * rate;
    }
}