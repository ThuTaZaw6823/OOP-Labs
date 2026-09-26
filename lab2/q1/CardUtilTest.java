package lab2.q1;

public class CardUtilTest {

    public static void main(String[] args) {

        Card card1 = new Card(Rank.ACE, Suite.SPADES);
        Card card2 = new Card(Rank.KING, Suite.HEARTS);

        System.out.println(CardUtil.HIGHEST_RANK);
        System.out.println(CardUtil.HIGHEST_SUITE);

        System.out.println(CardUtil.isHighestCard(card1));
        System.out.println(CardUtil.isHighestCard(card2));
    }
}
