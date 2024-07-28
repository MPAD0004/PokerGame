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
 *
 * Methods:
 *  startGame(): make the game ready for the flop; set player chip counts
 *  setStartingChips(): set each player's chipCount to STARTING_CHIPS
 *
 * Constants:
 *  STARTING_CHIPS [double]: amount of chips players start with
 */

public class GameEngine {
    private static double STARTING_CHIPS = 200;

    private ArrayList<Player> players;

    private void startGame(){
        setStartingChips();

    }

    private void setStartingChips(){
        // Set player starting chip counts
        for (Player player : players) {
            player.setChipCount(STARTING_CHIPS);
        }
    }
}
