public class Main {
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack.Builder("player").build();
//        System.out.println(blackjack.getDeck());
        blackjack.readInput();
//        System.out.println(blackjack.getDeck());
    }
}
