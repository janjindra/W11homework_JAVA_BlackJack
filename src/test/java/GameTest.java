import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameTest {

    Game game;
    Player player1;
    Player player2;
    Deck deck;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before(){
        deck = new Deck();
        game = new Game(deck);
        player1 = new Player("Jan");
        player2 = new Player("Peter");
        card1 = new Card(SuitType.CLUBS, RankType.KING);
        card2 = new Card(SuitType.CLUBS, RankType.JACK);
        card3 = new Card(SuitType.HEARTS, RankType.THREE);

    }

    @Test
    public void canGetPlayers(){
        assertEquals(0,game.getPlayers().size());
    }
    @Test
    public void canAddPlayer(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(2,game.countPlayers());
    }
    @Test
    public void canStartGame(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.startGame(deck);
        assertEquals(2, game.countPlayers());
        assertEquals(2, player1.countNumberOfCardsInHand());
        assertEquals(48, deck.getCards().size());
    }

    @Test
    public void twist_dealOneMoreCard(){
        game.addPlayer(player1);
        game.startGame(deck);
        game.twist_dealOneMoreCard(deck, player1);
        assertEquals(1, game.countPlayers());
        assertEquals(3, player1.countNumberOfCardsInHand());
        assertEquals(49, deck.getCards().size());
    }

    @Test
    public void canPushAllHandTotalsToArray(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        player1.addCardToHand(card2);
        player2.addCardToHand(card1);
        game.pushAllHandTotalsToArray();
        assertEquals(2, game.allHandTotals.size());
        assertFalse(game.allHandTotals.isEmpty());
        assertEquals(10, game.allHandTotals.get(0),0.01);
    }

    @Test
    public void canFindTheWinner_Peter(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        player1.addCardToHand(card3);
        player1.addCardToHand(card2);
        player2.addCardToHand(card1);
        player2.addCardToHand(card2);
        game.pushAllHandTotalsToArray();
        game.removeAllHandTotalsGreaterThan21();
        assertEquals(13, game.allHandTotals.get(0),0.01);
        assertEquals(20, game.allHandTotals.get(1),0.01);
        assertEquals(20, Collections.max(game.allHandTotalsLessThan21),0.01);
        assertEquals("The winner is Peter with 20 points.", game.findTheWinner());
    }

    @Test
    public void canFindTheWinner_Draw(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        player1.addCardToHand(card3);
        player1.addCardToHand(card2);
        player2.addCardToHand(card3);
        player2.addCardToHand(card2);
        game.pushAllHandTotalsToArray();
        game.removeAllHandTotalsGreaterThan21();
        assertEquals(13, game.allHandTotals.get(0),0.01);
        assertEquals(13, game.allHandTotals.get(1),0.01);
        assertEquals(13, Collections.max(game.allHandTotalsLessThan21),0.01);
        assertEquals("It's a draw.", game.findTheWinner());
    }

}
