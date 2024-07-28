import java.util.ArrayList;

/**
 * This class holds the community cards, used as a parameter to determine players relative hand value
 * Attributes:
 *  cards [ArrayList<Card>]: contains the current community cards
 *  deck [Deck]: reference to current deck variable
 *
 * Methods:
 *  dealFlop(): add 3 cards from the deck to the cards list
 */
class Board{
    private ArrayList<Card> cards;
    private Deck deck;


    public Board(Deck currentDeck){
        deck = currentDeck;
    }

    private void dealFlop(){
        // set the first 3 cards in ArrayList to cards dealt from the deck
        for (int i = 0 ; i < 3; i++){
            Card nextCard = deck.getNextCard();
            cards.add(nextCard);

        }
    }
}