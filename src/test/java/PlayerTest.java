import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void before(){
        player1 = new Player("Jan");
        player2 = new Player("Peter");
        card1 = new Card(SuitType.CLUBS, RankType.KING);
        card2 = new Card(SuitType.CLUBS, RankType.JACK);
        card3 = new Card(SuitType.HEARTS, RankType.THREE);
        card4 = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void canGetName(){
        assertEquals("Jan", player1.getName());
    }

    @Test
    public void canGetPlayersHand(){
        player1.addCardToHand(card1);
        assertEquals(1,player1.getPlayersHand().size());
    }

    @Test
    public void canAddCardsToHand(){
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);
        player1.addCardToHand(card3);
        assertEquals(3, player1.countNumberOfCardsInHand());
    }

    @Test
    public void canCalculateHandTotal_NoAce(){
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);
        assertEquals(20, player1.calculateHandTotal());

    }

    @Test
    public void canCalculateHandTotal_AceAsOne(){
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);
        player1.addCardToHand(card4);
        assertEquals(21, player1.calculateHandTotal());
    }

    @Test
    public void canCalculateHandTotal_AceAsEleven(){
        player1.addCardToHand(card1);
        player1.addCardToHand(card4);
        assertEquals(21, player1.calculateHandTotal());
    }


}
