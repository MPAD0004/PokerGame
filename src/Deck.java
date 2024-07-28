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
 *
 */

class Deck{
    // Stores all the current cards in the deck
    private ArrayList<Card> cards = new ArrayList<Card>();

    // Randomize the order of cards
    void shuffleDeck(){

    }

    // Return the next card in the deck
    public Card getNextCard(){
        return cards.removeLast();
    }

}