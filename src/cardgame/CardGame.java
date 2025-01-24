/*
 * @modifier dong nguyen
 * @student id 991756472
 */
package cardgame;
import java.util.Random;

public class CardGame {
      
    private Card[] hand;
    private static final int HAND_SIZE = 7;
    private static final Card.Suit[] suits = Card.Suit.values();

    public CardGame() {
        hand = new Card[HAND_SIZE];
        generateHand();
    }

    private void generateHand() {
        // Complete this for step 3
        Random rand = new Random();
        
        for (int i = 0; i < HAND_SIZE; i++) {
            Card.Suit randomSuit = suits[rand.nextInt(suits.length)];
            Card.Value randomValue = values[rand.nextInt(values.length)];
            hand[i] = new Card(randomValue, randomSuit);
        }
        
    }

    public void printHand() {
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }
    
    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();
    }
    
}
