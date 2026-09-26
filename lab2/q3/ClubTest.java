package lab2.q3;



public class ClubTest {

    public static void main(String[] args) {

        System.out.println("===== CLUB TEST =====");

        Club club = new Club("Computer Club", 10);

        System.out.println("Name: " + club.getName());
        System.out.println("Budget: " + club.determineBudget());

        club.advertise();

        club.addMember(5);
        System.out.println("Budget after adding 5 members: " + club.determineBudget());

        club.changeName("Coding Club");
        System.out.println("New name: " + club.getName());


        System.out.println();
        System.out.println("===== SPORTS CLUB TEST =====");

        SportsClub sportsClub = new SportsClub("Football Club", 10);

        System.out.println("Name: " + sportsClub.getName());
        System.out.println("Budget: " + sportsClub.determineBudget());

        sportsClub.advertise();

        sportsClub.addMember(5);
        System.out.println("Budget after adding 5 members: "
                + sportsClub.determineBudget());

        sportsClub.changeName("Basketball Club");
        System.out.println("Name after changeName: "
                + sportsClub.getName());


        System.out.println();
        System.out.println("===== MARKETING CLUB TEST =====");

        MarketingClub marketingClub =
                new MarketingClub("Marketing Club", 10, 1000);

        System.out.println("Name: " + marketingClub.getName());
        System.out.println("Budget: " + marketingClub.determineBudget());

        marketingClub.advertise();

        marketingClub.addMember(5);
        System.out.println("Budget after adding 5 members: "
                + marketingClub.determineBudget());

        marketingClub.changeName("Digital Marketing Club");
        System.out.println("New name: " + marketingClub.getName());

        boolean result1 = marketingClub.useBudget(300);
        System.out.println("Use 300 budget: " + result1);

        boolean result2 = marketingClub.useBudget(1000);
        System.out.println("Use 1000 budget: " + result2);


        System.out.println();
        System.out.println("===== MARKETING CLUB BUDGET > 1000 TEST =====");

        MarketingClub marketingClub2 =
                new MarketingClub("Business Club", 10, 1500);

        System.out.println("Name: " + marketingClub2.getName());
        System.out.println("Budget: " + marketingClub2.determineBudget());

        boolean result3 = marketingClub2.useBudget(600);
        System.out.println("Use 600 budget: " + result3);

        System.out.println("Budget after using money: "
                + marketingClub2.determineBudget());
    }
}