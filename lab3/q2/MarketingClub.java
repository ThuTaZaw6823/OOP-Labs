package lab3.q2;



public class MarketingClub extends Club{

    protected int budget;
    public MarketingClub(String c, int m, int b) {
        super(c, m);
        budget = b;
    }
    public boolean useBudget(int b){
        if(budget >= b){
            budget = budget - b;
            return true;
        }
        else{
            return false;
        }
    }
    @Override 
    public int determineBudget(){
        if(budget > 1000){
            return 0;
        }
        else{
            return (numMember * 1000);
        }
    }

    
}