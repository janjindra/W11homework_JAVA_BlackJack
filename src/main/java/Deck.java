import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    //Declaration
    public ArrayList<Card> cards;

    //Constructor
    public Deck(){
        cards = new ArrayList<Card>();
    }

    //Methods

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public int countCardsInDeck(){
        return getCards().size();
    }

    public void add52cardsToDeck() {
        for (SuitType s : SuitType.values()) {
            for (RankType r : RankType.values()) {
                cards.add(new Card(s,r));
            }
        }
    }
    public void shuffleCards(){
        Collections.shuffle(this.cards);
    }

    public Card dealACard(){
        Card chosenCard = this.cards.get(0);
        removeDealtCardFromDeck(chosenCard);
        return chosenCard;

    }
    public void removeDealtCardFromDeck(Card chosenCard) {
        cards.remove(chosenCard);
    }

}
