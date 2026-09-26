package lab2.q4;


public class Child extends Person {

    protected Person guardian;
    protected int age;
    protected int height;
    protected double weight;

    public Child(String fn, String ln, int a, int h, double w) {
        super(fn, ln);
        age = a;
        height = h;
        weight = w;
    }

    public void setGuardian(Person p){
        guardian = p;
    }

    public Person getGuardian(){
        return guardian;
    }

}

