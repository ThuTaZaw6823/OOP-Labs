package lab2.q4;



public class Person {
    protected String firstname;
    protected String lastname;

    public Person(String fn, String ln){
        firstname = fn;
        lastname = ln;
    }

    public void setFirstname(String aung){
        firstname = aung;
    }
    public String getFirstname(){
        return firstname;
    }


    public void setLastname(String myo){
        lastname = myo;
    }
    public String getLastname(){
        return lastname;
    }
}

