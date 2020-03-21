public class Card {

    //Declaration
    public SuitType suit;
    public RankType rank;

    //Constructor
    public Card(SuitType suit, RankType rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //Methods
    public SuitType getSuit(){
        return this.suit;
    }

    public RankType getRank(){
        return this.rank;
    }

    public int getValuesFromRankType(){
        return rank.getValue();
    }


}
