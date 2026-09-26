package lab2.q2;



public class BaketballPlayer extends Player {

    public BaketballPlayer(String n, int jn) {
        super(n, jn);
    }

    public void changeJerseyNumber(int newNumber) {
    jerseyNumber = newNumber;
    System.out.println(name + "changes number to "+ jerseyNumber);
}
    
}

