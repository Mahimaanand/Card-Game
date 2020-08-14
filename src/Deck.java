import java.util.ArrayList;
/**
 * This class creates the deck from the card class which is to be used in the game
 * @author Mahima Anand
 * @version 1.2
 */
public class Deck {
    ArrayList<String> cardDeck = new ArrayList<String>();

    public Deck(){
        for (int i=1;i<=4;i++){
            for (int j=1;j<=13;j++){
                String s = ""+i;
                String r = ""+j;
                Cards tempCard = new Cards(s,r);
                cardDeck.add(tempCard.toString());
            }
        }
    }
}
