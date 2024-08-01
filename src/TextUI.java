import java.util.ArrayList;
import java.util.Scanner;

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
 *  getBetAmount() -> double: allow user to type in bet size
 *  canConvertToString() -> boolean: checks if a string can be converted into a integer
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

    public void showGameState(double potValue, Board board, ArrayList<Player> players, int youPlayerIndex, int dealerPlayerIndex){
        clearScreen();
        // Print board header with substituted values

        System.out.printf(getGameHeaderStr(potValue));
        // Set community cards (board) string and print
        System.out.println(getCommCardsStr(board));
        // Set players string and print
        System.out.println(getPlayersString(players, youPlayerIndex, dealerPlayerIndex));

    }

    private String getPlayersString(ArrayList<Player> players, int youPlayerIndex, int dealerPlayerIndex){
        int sbIndex = ((dealerPlayerIndex+1) % players.size() + players.size()) % players.size();
        int bbIndex = ((dealerPlayerIndex+2) % players.size() + players.size()) % players.size();


        String baseStr = "";
        String basePlayerStr =
                """
                ------------------------------
                |%s                          |
                | Hand: %s                   |
                | Chips: $%f                 |
                | PIP: $%f                   |
                """;
        for (Player p : players){
            // if player is not in hand then skip
            if (!p.getInHand()){
                continue;
            }

            String nameStr = p.getPlayerName();

            // check if players is dealer, sb, bb and update name in ui
            if (players.indexOf(p) == sbIndex) nameStr = "[SMALL BLIND]" + nameStr;
            if (players.indexOf(p) == bbIndex) nameStr = "[BIG BLIND]" + nameStr;
            if (players.indexOf(p) == dealerPlayerIndex) nameStr = "[DEALER]" + nameStr;

            // If the player is you, then show the cards
            if (players.indexOf(p) == youPlayerIndex){
                // Format hand string
                String yourHandCards = String.format("[%s%s] [%s%s]", p.hand.getHoleCard1().getRank(),
                        p.hand.getHoleCard1().getSuitSymbol(), p.hand.getHoleCard2().getRank(),
                        p.hand.getHoleCard2().getSuitSymbol());

                baseStr += String.format(basePlayerStr, nameStr + "(YOU)", yourHandCards, p.getPlayerChipCount(), p.getPip());
            }else{
                baseStr += String.format(basePlayerStr, nameStr, "🂠 🂠", p.getPlayerChipCount(), p.getPip());
            }

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

    public double getBetAmount() {
        // Create a single Scanner object
        Scanner scanner = new Scanner(System.in);
        String userAction = "";

        // Determine user's action, repeat until user enters a valid string
        while (true) {
            System.out.println("Enter Action (0 = Check/Fold) or type amount of bet/call: ");
            if (scanner.hasNextLine()) {
                userAction = scanner.nextLine();
                System.out.println("You entered: " + userAction);

                if (canConvertToDouble(userAction)) {
                    break; // Exit loop if input is valid
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            } else {
                System.out.println("No input available. Please try again.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Return the valid double value
        return Double.parseDouble(userAction);
    }


    private boolean canConvertToDouble(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
