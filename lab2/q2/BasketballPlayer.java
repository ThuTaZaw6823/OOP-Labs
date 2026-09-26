package lab2.q2;

public class BasketballPlayer extends Player{

    public BasketballPlayer(String n, int jn) {
        super(n, jn);
        
    }
        public void changeJerseyNumber(int newNumber) {
            jerseyNumber = newNumber;
            System.out.println(name + "changes number to "+ jerseyNumber);
    }

    @Override
    public void playGame() {
        minutesPlayed = minutesPlayed +48;
    }

}