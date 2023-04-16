import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TwentyNineBestMove {
    private static final String ACE = "A";
    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String JACK = "J";
    private static final String TEN = "Ten";
    private static final String NINE = "Nine";
    private static final String EIGHT = "Eight";
    private static final String SEVEN = "Seven";
    private static final String SIX = "Six";
    private static final String FIVE = "Five";
    private static final String FOUR = "Four";
    private static final String THREE = "Three";
    private static final String TWO = "Two";
    private static final String ONE = "ONE";

    // Card Types literal
    private static final String SPADES = "Spades";
    private static final String CLUBS = "Clubs";
    private static final String HEARTS = "Hearts";
    private static final String DIAMONDS = "Diamonds";

    // Players
    private static final String PL_NORTH = "PlayerNorth";
    private static final String PL_SOUTH = "PlayerSouth";
    private static final String PL_EAST = "PlayerEast";
    private static final String PL_WEST = "PlayerWest";

    public static HashMap<String, Integer> cardValues;
    public HashMap<String, List<Card>> playerCards;

    public static class Card {
        public int id;
        public String name;
        public String cardType;
        public int value;

        public Card () {}

        public Card (String name, String cardType, int value) {
            this.name = name;
            this.cardType = cardType;
            this.value = value;
        }
    }

    public void initializeCardValues() {
        cardValues = new HashMap<>();
        cardValues.put(ACE, 1);
        cardValues.put(KING, 0);
        cardValues.put(QUEEN, 0);
        cardValues.put(JACK, 3);
        cardValues.put(TEN, 1);
        cardValues.put(NINE, 2);
        cardValues.put(EIGHT, 0);
        cardValues.put(SEVEN, 0);
    }

    public void distributeCards() {
        String[] cards = new String[] {
                SEVEN, TEN, JACK, ACE, NINE, KING, EIGHT, QUEEN
        };

        String[] players = new String[] {
                PL_NORTH, PL_SOUTH, PL_EAST, PL_WEST
        };
        Random randomNumber = new Random();

        for (String player : players) {
            for (int i = 0; i < 8; i++) {

            }
        }
    }

    public void func() {
        initializeCardValues();
        distributeCards();
//        System.out.println(nextMove(board, 'x', false));
    }

    public static void main(String[] args) {
        TwentyNineBestMove obj = new TwentyNineBestMove();
        obj.func();
    }
}
