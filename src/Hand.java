/**
 * This class is used to define the strength of a players hand (hole cards + community cards)
 * Input Variables:
 *  Board boardState: used to define the value of a hand in addition to the players hole cards
 *
 * Attributes:
 *  holeCard1 [Card]: holds the first hole card
 *  holeCard2 [Card]: holds the second hole card
 *
 * Methods:
 *  Hand(): [constructor] attach the Board class to a variable for use in hand calculation
 *  setHoleCard1(): set holeCard1 value
 *  setHoleCard2(): set holeCard2 value
 *
 */
class Hand{
    private Card holeCard1;
    private Card holeCard2;


    public Hand(){
    }


    // update HandRank, HighCardRank based on current board
    private String setHandValue(){
        return "";
    }

    private String getHandName(){

        return "";
    }

    public void setHoleCard1(Card holeCard1) {
        this.holeCard1 = holeCard1;
    }

    public void setHoleCard2(Card holeCard2){
        this.holeCard2 = holeCard2;
    }
}