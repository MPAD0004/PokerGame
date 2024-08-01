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
 *  preflopBetting(): run the preflop betting round
 *  getBlinds(): take the blinds from each player
 *  setPot(double): set the value of the pot
 *  resetCurrentBet(): set the currentBet variable to 0
 *  resetPlayersPip(): set each players pip to 0
 *  setAllPlayersInHand(boolean): set all players in hand to bool
 *  bettingRound(): run a round of betting
 *  runPreflop(): take the blinds
 *
 * Constants:
 *  STARTING_CHIPS [double]: amount of chips players start with
 */

public class GameEngine {
    private static double STARTING_CHIPS = 200;
    private static int NUM_PLAYERS = 4;
    private static int BB_AMOUNT = 2;
    private static int SB_AMOUNT = BB_AMOUNT / 2;
    private ioHandler io;
    private ArrayList<Player> players;
    private double potValue;
    private Deck deck;
    private Board board;
    private int dealerPlayerIndex = 2;
    private double currentBet;
    private boolean handComplete;
    private boolean actionClosed;
    private Player youPlayer;

    private void startGame(){
        youPlayer = players.getFirst();  // set user to first player in arraylist
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

    // change the value of the pot
    void setPot(double newPotValue){
        potValue = newPotValue;
    }
    private void resetCurrentBet(){
        currentBet = 0;
    }

    void resetPlayersPip(){
        for (Player p: players){
            p.setPip(0);
        }
    }
    void setAllPlayersInHand(boolean inHand){
        for (Player p: players){
            p.setInHand(inHand);
        }
    }

    private void playNextHand(){
        potValue = 0;
        handComplete = false;

        // Preflop Action
        setAllPlayersInHand(true);
        dealHoleCards();
        io.showState(potValue, board, players, youPlayer, dealerPlayerIndex);
        resetCurrentBet();
        resetPlayersPip();


        // Preflop betting
        runPreflop();
        bettingRound();

        // Run flop
        if (!handComplete){
            runFlop();
            resetCurrentBet();
            resetPlayersPip();
            io.showState(potValue, board, players, youPlayer, dealerPlayerIndex);
            bettingRound();
        }



        //

    }

    private void bettingRound(){

        // Create new copied list of players in hand
        ArrayList<Player> playersInHand = (ArrayList<Player>) players.clone();
        actionClosed = false;

        // Sort players by their order of play


        // while there is action, each player must respond
        while (!actionClosed){
            // Iterate over each player
            for (Player currPlayer: playersInHand){
                if (!currPlayer.getInHand()) continue;
                // Check if player is user or AI
                if (currPlayer == youPlayer){

                }
            }
        }




















        // create local reference to yourplayer
        Player youReference = playersInHand.get(youPlayerIndex);


        // Calculate index of first up player
        int firstupIndex = ((dealerPlayerIndex+3) % playersInHand.size() + playersInHand.size()) % playersInHand.size();
        // Add blinds to pot
        io.showState(potValue, board, playersInHand, youPlayerIndex, dealerPlayerIndex);

        // get the bet from each player starting with the player left of BB (firstupIndex)
        // use circular loop starting from firstupPlayer
        // TODO: update to active players in hand, instead of players
        int playerIndex = firstupIndex; // circular index
        double playerAction;


        for (int i = 0; i < playersInHand.size(); i++) {
            int localYouIndex = playersInHand.indexOf(youReference);

            Player currPlayer = playersInHand.get(playerIndex);
            // if player is not in hand skip
//            if (!currPlayer.getInHand()){
//                continue;
//            }

            // Get input from user on action
            if (currPlayer == youReference){
                playerAction = io.getAction();
            }
            // Get AI action
            else{
                playerAction = currPlayer.getAIBet();
            }

            /* Update the players status based on the bet */

            // Fold
            if (playerAction == 0 && currPlayer.getPip() < currentBet){
                currPlayer.setInHand(false);
                // remove player from playersInHand Array
                playersInHand.remove(currPlayer);

                io.reportAction(String.format("%s Folds", currPlayer.getPlayerName()));
            }
            // Check
            else if (playerAction == 0 && currPlayer.getPip() == currentBet){
                io.reportAction(String.format("%s Checks", currPlayer.getPlayerName()));
            }
            // Call
            else if (playerAction == currentBet && currPlayer.getPlayerChipCount() >= currentBet){
                // update potValue and subtract call value from players chips
                double callDifferential = currentBet - currPlayer.getPip();
                setPot(potValue + callDifferential);
                currPlayer.setPip(currentBet);
                currPlayer.setChipCount(currPlayer.getPlayerChipCount() - callDifferential);
                io.reportAction(String.format("%s Calls $%f", currPlayer.getPlayerName(), currentBet));
            }
            // Raise
            else if(playerAction > currentBet && currPlayer.getPlayerChipCount() >= playerAction){
                double raiseDifferential = playerAction - currPlayer.getPip();
                setPot(potValue + raiseDifferential);
                currPlayer.setPip(playerAction);
                currPlayer.setChipCount(currPlayer.getPlayerChipCount() - raiseDifferential);
                currentBet = playerAction;
                io.reportAction(String.format("%s Raises to $%f", currPlayer.getPlayerName(), currentBet));
            }

            // BAD INPUT
            else{
                System.out.println("ERROR: BAD INPUT IN PLAYER ACTION in preflopBetting()");
            }

            // TODO: update the ioHandler class to store reference to variables; board, players, youPlayerIndex,
            io.showState(potValue, board, playersInHand, localYouIndex, dealerPlayerIndex);
            // update the player index
            playerIndex = ((playerIndex + 1) % playersInHand.size() + players.size()) % players.size();

            // update your position index in the player list
            //TODO Rewrite with players in Hand list



        }
        // check if only one is still in the hand, in which case the hand is over
        int inHandCount = 0;
        Player winner = null;

        for (int j = 0; j < players.size(); j++) {
            if (players.get(j).getInHand()){
                inHandCount++;
                winner = players.get(j);
            }
        }

        if (inHandCount == 1){
            handComplete = true;
            // add chips to winner
            winner.setChipCount(winner.getPlayerChipCount() + potValue);
            System.out.printf("Winner: %s, +$%f", winner.getPlayerName(), potValue);
        }

    }


    private void runFlop(){
        board.dealFlop();
        System.out.println("Flop Dealt!");
    }


    private void runPreflop(){
        // calculate list index of each position, treating the list as if it is circular
        int sbIndex = ((dealerPlayerIndex+1) % players.size() + players.size()) % players.size();
        int bbIndex = ((dealerPlayerIndex+2) % players.size() + players.size()) % players.size();
        // Add blinds to pot
        addBlindsToPot(sbIndex, bbIndex);
        io.showState(potValue, board, players, youPlayerIndex, dealerPlayerIndex);
    }

    void addBlindsToPot(int sbIndex, int bbIndex){
        Player playerSB = players.get(sbIndex);
        Player playerBB = players.get(bbIndex);

        // if player in small blind cannot pay the blind put all their chips in pot
        if (playerSB.getPlayerChipCount() < SB_AMOUNT){
            setPot(playerSB.getPlayerChipCount() + potValue);
            playerSB.setPip(playerSB.getPlayerChipCount());
            playerSB.setChipCount(0);

        // SB Can afford blind
        }else if (playerSB.getPlayerChipCount() >= SB_AMOUNT){
            setPot(potValue + SB_AMOUNT);
            playerSB.setChipCount(playerSB.getPlayerChipCount() - SB_AMOUNT);
            playerSB.setPip(SB_AMOUNT);
        }

        // BB cannot afford blind
        if (playerBB.getPlayerChipCount() < BB_AMOUNT){
            setPot(playerBB.getPlayerChipCount() + potValue);
            playerBB.setPip(playerBB.getPlayerChipCount());
            playerBB.setChipCount(0);

        // BB can afford blind
        }else if (playerBB.getPlayerChipCount() >= BB_AMOUNT){
            setPot(potValue + BB_AMOUNT);
            playerBB.setPip(BB_AMOUNT);
            playerBB.setChipCount(playerBB.getPlayerChipCount() - BB_AMOUNT);
        }
        // update current bet
        currentBet = BB_AMOUNT;
        io.reportAction("Added blinds to pot!");

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
