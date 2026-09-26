package lab2.q1;

public class Card {

    private Rank rank;
    private Suite suit;

    public Card(Rank rank, Suite suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suite getSuit() {
        return suit;
    }
}
