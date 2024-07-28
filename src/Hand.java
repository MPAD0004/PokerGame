/**
 * This class is used to define the strength of a players hand (hole cards + community cards)
 * Input Variables:
 *  Board boardState: used to define the value of a hand in addition to the players hole cards
 *
 * Attributes:
 *  HandRank [int]: the numerical rank of a hand, with 0 being High Card (weakest hand) and 9 being royal flush (strongest hand)
 *  HighCardRank [int] : highest individual card, used to determine winner when HandRank of multiple hands is the same
 *  board [Board]: reference to the games Board variable
 *
 * Methods:
 *  Hand(): [constructor] attach the Board class to a variable for use in hand calculation
 *  setHandValue(): update the variables HandRank and HighCardRank based on the current Board object
 *  getHandName (): returns the string name of a hand for user to read, ie "7 high diamond flush"
 */
class Hand{
    private int HandRank;
    private int HighCardRank;
    private Board board;

    private Hand(Board currentBoard){
        board = currentBoard;
    }
    // update HandRank, HighCardRank based on current board
    private String setHandValue(){
        return "";
    }

    private String getHandName(){

        return "";
    }


}