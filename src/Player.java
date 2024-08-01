
/**
 * The Player class contains information about players at a table; chipCount, name, hand
 *
 * Attributes:
 *  chipCount [double]: current amount of chips a player has
 *  playerName [String]: players name
 *  hand [Hand]: players current hand of two hole cards
 *  pip [double]; chips Put In Pot (pip) in current round
 *  inHand [boolean]: bool whether play is in current hand or not
 *
 * Methods:
 *  setChipCount(double chipCount): set the players chipCount to the input chipCount
 *  getPlayerName() -> String: return playerName
 *  getPlayerChipCount() -> double: return players chipCount
 *  getBetAmount() -> double: get the players bet amount, i.e. for human player get input of bet size and for computer get ai bet size
 *  getPip() -> double: return this.pip
 *  setPip(): set this.pip
 *  getInHand() -> boolean: return this.inHand
 *  setInHand(): set this.inHand
 */
class Player{
    private double chipCount;
    private String playerName;
    private double pip;
    public Hand hand;
    private boolean inHand;

    Player(String playerName, double chipCount){
        this.playerName = playerName;
        this.chipCount = chipCount;
        this.pip = 0;
        hand = new Hand();
    }

    public void setChipCount(double chipCount){
        this.chipCount = chipCount;
    }

    public String getPlayerName(){
        return this.playerName;

    }
    public double getPlayerChipCount(){
        return this.chipCount;
    }

    public double getAIBet(){
        // if human player then get input bet size
        return 0;
    }

    public void setPip(double pip){
        this.pip = pip;
    }

    public double getPip(){
        return this.pip;
    }

    public void setInHand(boolean inHand){
        this.inHand = inHand;
    }

    public boolean getInHand(){
        return this.inHand;
    }
}