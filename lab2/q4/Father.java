package lab2.q4;



public class Father extends Parent{

    protected Mother wife;
    public Father(String fn, String ln, int m, Mother w) {
        super(fn, ln, m);
        wife = w;
    }
    
    public Mother getWife(){
        return wife;
    }
}

