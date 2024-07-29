
/**
 * The Player class contains information about players at a table; chipCount, name, hand
 *
 * Attributes:
 *  chipCount [double]: current amount of chips a player has
 *  playerName [String]: players name
 *  hand [Hand]: players current hand of two hole cards
 *
 * Methods:
 *  setChipCount(double chipCount): set the players chipCount to the input chipCount
 *  getPlayerName() -> String: return playerName
 *  getPlayerChipCount() -> double: return players chipCount
 */
class Player{
    private double chipCount;
    private String playerName;
    public Hand hand;

    public void setChipCount(double chipCount){
        this.chipCount = chipCount;
    }

    public String getPlayerName(){
        return this.playerName;

    }
    public double getPlayerChipCount(){
        return this.chipCount;
    }

    Player(String playerName, double chipCount){
        this.playerName = playerName;
        this.chipCount = chipCount;
        hand = new Hand();
    }
}