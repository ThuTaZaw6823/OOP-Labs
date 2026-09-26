package lab2.q2;

public class Player{
    protected String name;
    protected int jerseyNumber;
    protected int minutesPlayed;

    public Player(String n, int jn){
        name = n;
        jerseyNumber = jn;
        minutesPlayed = 0;
    }

    public void print() {
        System.out.println(name + ": " +jerseyNumber);
    }

    public void playGame() {
        minutesPlayed = minutesPlayed +90;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

}
