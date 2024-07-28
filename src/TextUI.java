import java.util.ArrayList;

/**
 * This class contains the initial UI: the text UI
 * The text UI uses the game engine to show the user the current game state in the terminal
 * The user can interact with the game through the textUI
 *
 * Methods:
 *  initializeUI(): clearScreen() and print a welcome message
 *  clearScreen(): clear the terminal by printing ANSI escape codes
 *  showGameFrame(): print players, deck, community cards, chip counts
 *  setCommCardsStr(Board currBoard): generate and set the string for the community cards game board
 */
public class TextUI {

    public TextUI(){
        initializeUI();
    }

    // clear screen and welcome
    private void initializeUI(){
        clearScreen();
        System.out.println("Welcome to PokerWithMates!");
    }

    public void showGameState(double potValue, Board board, ArrayList<Player> players){
        clearScreen();
        // Print board header with substituted values
        System.out.printf(strGameHeader, potValue);
        // Set board string and print
        setCommCardsStr(board);
        System.out.println(strGameCommCards);
    }


    private void setCommCardsStr(Board currBoard){
        String baseStr = "|";
        for (int i = 0; i < currBoard.getCards().size(); i++){
            Card currCard = currBoard.getCards().get(i);
            String strCard = String.format("[%s%s] ", currCard.getRank(), currCard.getSuitSymbol());
            baseStr += strCard;
        }
        strGameCommCards = baseStr;
    }

    private void clearScreen(){
        // Moves cursor to top left of screen and clears screen from cursor to end of screen
        System.out.print("\033[H\033[2J");
    }


    final private String strGameHeader =
            """
            ===========================
            |     POKER WITH MATES    |
            ===========================
            | Pot: $ %f               |
            |-------------------------|
            \n""";

    private String strGameCommCards = "";
}
