/**
 * This class contains the initial UI: the text UI
 * The text UI uses the game engine to show the user the current game state in the terminal
 * The user can interact with the game through the textUI
 *
 * Methods:
 *  initializeUI(): clearScreen() and print a welcome message
 *  clearScreen(): clear the terminal by printing ANSI escape codes
 */
public class TextUI {

    public TextUI(){
        initializeUI();
    }

    //
    private void initializeUI(){
        clearScreen();
        System.out.println("Welcome to PokerWithMates!");
    }

    private void clearScreen(){
        // Moves cursor to top left of screen and clears screen from cursor to end of screen
        System.out.print("\033[H\033[2J");
    }
}
