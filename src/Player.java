
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
 */
class Player{
    private double chipCount;
    private String playerName;
    private Hand hand;

    public void setChipCount(double chipCount){
        this.chipCount = chipCount;
    }

}