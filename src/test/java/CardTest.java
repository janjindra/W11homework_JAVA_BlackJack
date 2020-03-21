import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CardTest {

    //Declaration
    Card card;

    @Before
    public void before(){
        card = new Card(SuitType.CLUBS, RankType.FIVE);
    }
    @Test
    public void canGetSuitType(){
        assertEquals(SuitType.CLUBS, card.getSuit());
    }
    @Test
    public void canGetRankType(){
        assertEquals(RankType.FIVE, card.getRank());
    }
    @Test
    public void canGetValuesFromRankType(){
        assertEquals(5,card.getValuesFromRankType());
    }



}
