package lab3.q1;

public class SportsClub extends Club{

    public SportsClub(String c, int m) {
        super(c, m);
    }

    @Override 
    public int determineBudget(){
       return (numMember * 1000) + (numMember - minNumMember) * 100;
    }

    @Override 
    public void changeName(String cl){
        System.out.println("Can't be modified");
    }

    public int getNumMember() {
    return numMember;
}
    
}
