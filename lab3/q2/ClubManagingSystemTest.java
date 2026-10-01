package lab3.q2;

public class ClubManagingSystemTest {

    public static void main(String[] args) {

        Club c1 = new Club("Student", 200);
        SportsClub c2 = new SportsClub("Football", 40);
        ESportClub c3 = new ESportClub("RoV", 5);
        MarketingClub c4 = new MarketingClub("Advertising", 10, 100);

        Club[] clubs = {c1, c2, c3, c4};

        ClubManagingSystem system = new ClubManagingSystem(clubs);

        System.out.println("Highest member club: "
                + system.getHighestMemberClub().getName());

        System.out.println("Total budget: "
                + system.determineAllBudget());

        System.out.println("Total members: "
                + system.getAllMembers());
    }
}