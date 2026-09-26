package lab2.q4;



public class Parent extends Person{

    protected Child child;
    protected int money;

    public Parent(String fn, String ln, int m) {
        super(fn, ln);
        money = m;
    }
    
    public void setChild(Child c){
        child = c;
    }

    public Child getChild(){
        return child;
    }
}

