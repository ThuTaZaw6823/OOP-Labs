package lab3.q1;

public class ESportsClubTest {
    public static void main(String[] args) {

        ESportClub e = new ESportClub("Esport", 100);

        System.out.println("=== ESportsClub e ===");
        System.out.println("Club name: " + e.getName());
        System.out.println("Number of members: " + e.getNumMember());

        e.advertise();

        System.out.println("Budget: " + e.determineBudget());


        System.out.println();


        Club c = new ESportClub("Esport", 100);

        System.out.println("=== Club c = new ESportsClub(...) ===");
        System.out.println("Club name: " + c.getName());

        c.advertise();

        System.out.println("Budget: " + c.determineBudget());
    }
}