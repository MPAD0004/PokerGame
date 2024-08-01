import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * The ioHandler acts as an intermediary between the GameEngine and TextUI
 * The GameEngine will have an association to ioHandler, as it will use functions from ioHandler to update visual game state,
 *  and also to collect user input
 * This class forces the GameEngine to have only a dependency on TextUI, rather than an Association
 * This means that if the game was updated to have a GUI, we could simply update the ioHandler instead of
 *  complex and painful updating of the game engine
 * This decoupling of GameEngine from TextUI promotes modularity and flexibility and separation of concerns
 *
 * Methods:
 *  showState(double potValue, Board board, ArrayList<Player> players, int youPlayerIndex): show the current game state; players, chipcounts, community cards, yourhand
 *  ioInit(): initialize the io device, by calling its constructor
 *  getAction(): get the players action; check, call, raise, fold
 *  reportAction(): print a string to screen
 */

public class ioHandler {
    private TextUI io;

    ioHandler(){
        ioInit();
    }

    public void ioInit(){
        io = new TextUI();
    }

    public void showState(double potValue, Board board, ArrayList<Player> players, int youPlayerIndex, int dealerPlayerIndex){
        io.showGameState(potValue, board, players, youPlayerIndex, dealerPlayerIndex);
    }

    public double getAction(){
        return io.getBetAmount();
    }

    public void reportAction(String action){
        System.out.println(action);
    }
}
