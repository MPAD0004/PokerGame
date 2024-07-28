/**
 * -- A NOTE ON COMMENT STYLE ---
 *
 * In this java class, comments are used consistently, and with a consistent structure\
 * The structure is as follows:
 * Each class has a comment above its definition with the subtitles; Attributes, Methods
 * Attributes:
 * attributeName [variable type]: description
 *
 * Methods:
 * methodName (parameter name and type): description
 */

import java.util.ArrayList;


public class GameEngine {

    // Contains players hand, chip count
    class Player{
        private double chipCount;
    }

    /**
     * This class holds the community cards, used as a parameter to determine players relative hand value
     * Attributes:
     *  cards [ArrayList<Card>]: contains the current community cards
     *
     * Methods:
     *  dealRiver():
     */
    class Board{
        private ArrayList<Card> cards;
        public Board(){

        }
    }

    // Contains the card not currently in play
    class Deck{
        // Stores all the current cards in the deck
        private ArrayList<Card> cards = new ArrayList<Card>();

        // Randomize the order of cards
        void shuffleDeck(){

        }

        // Return the next card in the deck
        Card getNextCard(){
            return cards.removeLast();
        }

    }




    // Card has a value and a suit
    class Card{
        private String rank;
        private String suit;

        // Initialize card data
        Card (String rank, String suit){
            this.rank = rank;
            this.suit = suit;
        }
    }
}
