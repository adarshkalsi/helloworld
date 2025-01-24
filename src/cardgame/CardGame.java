
/*@modifier Dong Nguyen
  Student Id : 991756472
 */
package cardgame;
import java.util.Random;

public class CardGame {
      
    private Card[] hand;
    private static final int HAND_SIZE = 7;
    private static final Card.Suit[] suits = Card.Suit.values();
    private static final Card.Value[] values = Card.Value.values();  // Added values array to generate random cards

    public CardGame() {
        hand = new Card[HAND_SIZE];
        generateHand();
    }

    private void generateHand() {
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

    public boolean checkLuckyCard(Card luckyCard) {
        for (Card card : hand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit() == luckyCard.getSuit()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();
        
        // Hardcoded lucky card
        Card luckyCard = new Card(Card.Value.ACE, Card.Suit.HEARTS);
        
        if (game.checkLuckyCard(luckyCard)) {
            System.out.println("Congratulations! Your lucky card " + luckyCard.getValue()
                    + " of " + luckyCard.getSuit() + " is in the hand.");
        } else {
            System.out.println("Sorry! Your lucky card " + luckyCard.getValue()
                    + " of " + luckyCard.getSuit() + " is not in the hand.");
        }
    }
}
