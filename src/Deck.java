import java.util.ArrayList;

/**
 * The deck class stores all the current cards that are not in players hand and in the board
 * Card can only be removed from the deck, they cannot be added
 * Attributes:
 *  cards ArrayList<Card>: contains all the cards in the deck
 *
 * Methods:
 *  shuffleDeck(): randomizes the order of the deck
 *  getNextCard() -> Card: removes the last card in the deck and returns it
 *  initDeck(): initialize all values in the deck (standard 52 card poker deck)
 *
 */

class Deck{
    // Stores all the current cards in the deck
    final static String[] CARD_SUITS = {"C","H","S","D"};
    final static String[] CARD_RANKS = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
    private ArrayList<Card> cards = new ArrayList<Card>();

    Deck(){
        initDeck();
        shuffleDeck();
    }

    void initDeck(){
        for (String suit: CARD_SUITS){
            for (String rank: CARD_RANKS){
                cards.add(new Card(rank,suit));
            }
        }
    }
    // Randomize the order of cards
    void shuffleDeck(){

    }

    // Return the next card in the deck
    public Card getNextCard(){
        return cards.removeLast();
    }

}