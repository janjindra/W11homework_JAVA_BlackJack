import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {

    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void canCountCardsInDeck_Zero(){
        assertEquals(0, deck.countCardsInDeck());
    }

    @Test
    public void canGetCards(){
        deck.add52cardsToDeck();
        assertEquals(52, deck.getCards().size());
    }
    @Test
    public void canAdd52cardsToDeck(){
        deck.add52cardsToDeck();
        assertEquals(52, deck.countCardsInDeck());
    }

    @Test
    public void canShuffleCards_NotShuffled(){
        deck.add52cardsToDeck();
        assertEquals(deck.getCards().get(0).getValuesFromRankType(),1);
    }

    @Test
    public void canShuffleCards_Shuffled(){
        deck.add52cardsToDeck();
        deck.shuffleCards();
        assertNotEquals(deck.getCards().get(0).getValuesFromRankType(),1);
    }
    @Test
    public void canRemoveDealtCardFromDeck(){
        deck.add52cardsToDeck();
        deck.shuffleCards();
        deck.dealACard();
//        deck.removeDealtCardFromDeck(deck.getCards().get(0));
        assertEquals(51, deck.countCardsInDeck());
    }



}
