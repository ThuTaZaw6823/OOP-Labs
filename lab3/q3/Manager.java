package lab3.q3;

public class Manager extends Fulltimer {

    private int workYear;

    public Manager(String n, double s, int w) {
        super(n, s);
        workYear = w;
    }

    @Override
    public double computePay() {
        return super.computePay() * workYear;
    }

    public int getWorkYear() {
        return workYear;
    }
}