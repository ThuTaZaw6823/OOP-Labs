package lab3.q2;

public final class ESportClub extends SportsClub{
    
    public ESportClub(String c, int m){
            super(c,m);
            minNumMember = 1;
    }

    @Override 
    public final void advertise(){
        System.out.println("No need to advertise");
    }
    
    

}
