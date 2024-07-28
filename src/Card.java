/**
 * Card class describes the basic object of a card, which has only a rank and a suit
 *
 * Attributes:
 *  rank [String]: stores card rank, i.e. 10, J, Q, K, A, 2...
 *  suit [String]: stores card suit, i.e. C, H, S, D
 *
 * Methods:
 *  getSuitSymbol() -> String: return the symbol of the current card, i.e. ♣, ♥, ♠, ♦
 *  getRank() -> String: return card rank, i.e. 10, J, Q, K, A, 2...
 */
class Card{
    private String rank;
    private String suit;

    // Initialize card data
    Card (String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuitSymbol(){
        //System.out.println(this.suit + this.rank);
        return switch (this.suit) {
            case "C" -> "♣";
            case "H" -> "♥";
            case "S" -> "♠";
            case "D" -> "♦";
            default -> "m";
        };
    }
    public String getRank(){
        return this.rank;
    }
}