import java.util.Arrays;
import java.util.Random;

public class Deck {
    private int count = 24;
    private final Card deck[] = new Card[count];

    public Deck() {
        int i = 0;
        for (var suit: Suit.values()) {
            for (var rank: Rank.values()) {
                deck[i] = new Card(suit, rank);
                i++;
            }
        }
    }

    public Card randomCard()
    {
        Random rand = new Random();
//        rand.nextInt(count + 1);
        return  deck[rand.nextInt(count + 1)];
    }

    public void deleteCard(Card card_to_delete)
    {

        int del_ind = -1;
       for(int i = 0; i < count; i++)
       {
           if(deck[i].equals(card_to_delete))
           {
                del_ind = i;
                break;
           }
       }

       if(del_ind != -1)
       {
            for(int i = del_ind; i < count - 1; i++)
            {
                deck[i] = deck[i + 1];
            }

            deck[count - 1] = null;
            count--;
       }

    }

    @Override
    public String toString() {
        return "Deck{" +
                "count=" + count +
                ", deck=" + Arrays.toString(deck) +
                '}';
    }
}
