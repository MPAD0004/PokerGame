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
 *  getGameHeaderStr(double potValue) -> String: generate and return string for header of display
 *  getCommCardsStr(Board currBoard) -> String: generate and return the string for the community cards game board
 *  setPlayersString(ArrayList<Player> players) -> String: generate and set string value for players in hand
 *
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


        System.out.printf(getGameHeaderStr(potValue));
        // Set community cards (board) string and print
        System.out.println(getCommCardsStr(board));
        // Set players string and print
        System.out.println(getPlayersString(players));

    }

    private String getPlayersString(ArrayList<Player> players){
        String baseStr = "";
        String basePlayerStr =
                """
                ------------------------------
                |%s                          |
                | Hand: 🂠 🂠                  |
                | Chips: $%f                 |
                """;
        for (Player p : players){
            baseStr += String.format(basePlayerStr, p.getPlayerName(), p.getPlayerChipCount());
        }

        return baseStr;
    }

    private String getGameHeaderStr(double potValue){
        String baseStr = """
                ===========================
                |     POKER WITH MATES    |
                ===========================
                | Pot: $ %f               |
                |-------------------------|
                """;
        return String.format(baseStr, potValue);
    }
    private String getCommCardsStr(Board currBoard){
        String baseStr = "|";
        for (int i = 0; i < currBoard.getCards().size(); i++){
            Card currCard = currBoard.getCards().get(i);
            String strCard = String.format("[%s%s] ", currCard.getRank(), currCard.getSuitSymbol());
            baseStr += strCard;
        }
        return baseStr + " |";
    }

    private void clearScreen(){
        // Moves cursor to top left of screen and clears screen from cursor to end of screen
        System.out.print("\033[H\033[2J");
    }

}
