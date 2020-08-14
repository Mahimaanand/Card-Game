/**
 * This class creates the cards which form the deck
 * @author Mahima Anand
 * @version 1.2
 */
public class Cards {
    String suit;
    String rank;

    public Cards(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

        public String getSuit(){
            return suit;
        }

        public String getRank() {
            return rank;
        }
        public String toString(){
            return suit+rank;
        }

    }
