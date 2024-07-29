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
 * methodName (parameter name and type) -> returnType: method description
 */

import java.util.ArrayList;

/**
 * The GameEngine class has associations with Board, Deck, Hand and a dependency on Card
 * GameEngine is responsible for the game structure and turn-based play
 *
 * Attributes:
 *  players [ArrayList<Player>]: ArrayList containing all the players currently at the table
 *  io [ioHandler]: stores ui communication medium
 *  potValue [int]: current value of the pot
 *  board [Board]: contains the game board
 *  deck [Deck]: the deck object
 *
 * Methods:
 *  startGame(): make the game ready for the flop; set player chip counts
 *  playNextHand(): start the next hand of gameplay
 *  dealHoleCard(): set each player's hand holeCard1 and holeCard2 attribute to nextCard() in deck
 *  setStartingPlayers(): set the value of the players list, with names and chip values
 *
 * Constants:
 *  STARTING_CHIPS [double]: amount of chips players start with
 */

public class GameEngine {
    private static double STARTING_CHIPS = 200;
    private static int NUM_PLAYERS = 4;
    private ioHandler io;
    private ArrayList<Player> players;
    private double potValue;
    private Deck deck;
    private Board board;

    private void startGame(){
        setStartingPlayers();
        playNextHand();
    }


    private void dealHoleCards(){
        for (Player player : players) {
            player.hand.setHoleCard1(deck.getNextCard());
            player.hand.setHoleCard2(deck.getNextCard());
        }
    }
    private void setStartingPlayers(){
        String[] names = {"Jack", "Jill", "John", "Jenny"}; // Players names used for testing

        for (int i = 0; i < NUM_PLAYERS; i++) {
            players.add(new Player(names[i], STARTING_CHIPS));
        }
    }

    private void playNextHand(){
        potValue = 0;

        // Preflop betting
        dealHoleCards();
        io.showState(potValue, board, players);
        // Flop Time
        board.dealFlop();
        io.showState(potValue, board, players);

        //

    }

    GameEngine(){
        // Define variables
        io = new ioHandler();
        players = new ArrayList<>();
        deck = new Deck();
        board = new Board(deck);
        players = new ArrayList<>();
        startGame();
    }
}
