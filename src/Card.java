import java.util.Objects;

enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES}

enum Rank {
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(2, "J"),
    QUEEN(3, "Q"),
    KING(4, "K"),
    ACE(11, "A");
    private final int weight;
    private final String symbol;

    Rank(int weight, String symbol) {
        this.weight = weight;
        this.symbol = symbol;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "weight=" + weight +
                ", symbol=" + symbol +
                '}';
    }
}

public class Card {
    public final Suit suit;
    public final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return getSuit() == card.getSuit() && getRank() == card.getRank();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getRank());
    }
}
