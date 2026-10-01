package lab3.q2;

public class Club {
    protected String clubName;
    protected int minNumMember;
    protected int numMember;

    public Club(String c, int m) {
        clubName = c;
        minNumMember = m;
        numMember = m;
    }

    public void addMember(int num) {
        numMember = numMember + num;
    }

    public void changeName(String newName) {
        clubName = newName;
    }

    public String getName() {
        return clubName;
    }

    public int determineBudget() {
        return (numMember * 1000);
    }

    public void advertise() {
        System.out.println("Please join club: " + clubName);
    }

    public int getNumMember() {
        return numMember;
    }
}

