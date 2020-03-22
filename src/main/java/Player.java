import java.util.ArrayList;

public class Player {

    //Declaration
    public String name;
    public ArrayList<Card> hand;
//    public int handTotal;

    //Constructor
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
//        this.handTotal = handTotal;
    }

    //Methods
    public String getName(){
        return this.name;
    }

    public ArrayList<Card> getPlayersHand(){
        return this.hand;
    }

    public int countNumberOfCardsInHand(){
        return hand.size();
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public int calculateHandTotal(){
        int handTotal = 0;
        for (Card card : this.hand ) {
            handTotal = handTotal + card.getValuesFromRankType();
            for (Card checkAllCardsAgain : this.hand) {
                if (checkAllCardsAgain.getRank().equals(RankType.ACE) && (handTotal > 21)) {
                    handTotal = handTotal - 10;
                }
            }
        }
        return handTotal;
    }


}
