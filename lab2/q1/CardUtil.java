package lab2.q1;

public class CardUtil {

    public static final Rank HIGHEST_RANK = Rank.ACE;
    public static final Suite HIGHEST_SUITE = Suite.SPADES;

    public static boolean isHighestCard(Card card) {
        return card.getRank() == HIGHEST_RANK &&
               card.getSuit() == HIGHEST_SUITE;
    }
}
