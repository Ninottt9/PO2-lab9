import java.util.Scanner;

public class Blackjack {
    private final String player_name;
    private final int max_iteration_count;
    private int player_score;
    private int ai_score;
    private final Deck deck;

    public static class Builder{
        private final String player_name;
        private int max_iteration_count = 100;
        private int player_score = 0;
        private int ai_score = 0;
        private final Deck deck = new Deck();
        public Builder(String player_name)
        {
            this.player_name = player_name;
//            deck = new Deck();

        }
        public Builder setMaxIterationCount(int max_iteration_count){
            this.max_iteration_count = max_iteration_count;
            return this;
        }

        public Builder setPlayerScore(int player_score)
        {
            this.player_score = player_score;
            return this;
        }

        public Builder setAiScore(int ai_score)
        {
            this.ai_score = ai_score;
            return this;
        }

        public Blackjack build() {
            return new Blackjack(this);
        }
    }
    private Blackjack(Builder builder)
    {
        player_name = builder.player_name;
        max_iteration_count = builder.max_iteration_count;
        player_score = builder.player_score;
        ai_score = builder.ai_score;
        deck = builder.deck;
    }

    void play(){
        Card player_card = deck.randomCard();
        deck.deleteCard(player_card);

        Card ai_card = deck.randomCard();
        deck.deleteCard(ai_card);

        player_score += player_card.getRank().getWeight();
        ai_score += ai_card.getRank().getWeight();
    }
    void stop(){

    }

    void readInput()
    {
        Boolean quit = false;
        for(int i = 0; i < max_iteration_count && !quit; i++ )
        {
            System.out.println("Please choose the game option: 'p' to PLAY, 's' to STOP, 'q' to QUIT");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next())
            {
                case "p" : play(); break;
                case "s" : stop(); break;
                case "q" : quit = true; break;
                default: System.out.println("Wrong input"); break;
            }

            System.out.println(player_name + " score: " + player_score);
            System.out.println("ai + score: " + ai_score);
        }
    }
}
