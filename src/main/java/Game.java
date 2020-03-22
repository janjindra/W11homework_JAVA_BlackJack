import java.util.ArrayList;
import java.util.Collections;


public class Game {

    public ArrayList<Player> players;
    public Deck deck;
    public ArrayList<Integer> allHandTotals;
    public ArrayList<Integer> allHandTotalsLessThan21;


    public Game(){
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
        this.allHandTotals = new ArrayList<Integer>();
        this.allHandTotalsLessThan21 = new ArrayList<Integer>();

    }

    //Methods
    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public int countPlayers(){
       return players.size();
    }

    public void startGame(Deck deck){
        deck.add52cardsToDeck();
        deck.shuffleCards();
        for (Player player : this.players) {
            Card dealtCard1 = deck.dealACard();
            player.addCardToHand(dealtCard1);
            Card dealtCard2 = deck.dealACard();
            player.addCardToHand(dealtCard2);
        }
    }

    public void twist_dealOneMoreCard(Deck deck, Player player) {
        Card twistDealtCard1 = deck.dealACard();
        player.addCardToHand(twistDealtCard1);
    }

    public void pushAllHandTotalsToArray() {
        for ( Player player : this.players ) {
            this.allHandTotals.add(player.calculateHandTotal());
        }
    }

    public void removeAllHandTotalsGreaterThan21(){
        for (Integer element : this.allHandTotals){
            if (element <= 21) {
                this.allHandTotalsLessThan21.add(element);
            }
        }
    }

    public String findTheWinner(){
        pushAllHandTotalsToArray();
        removeAllHandTotalsGreaterThan21();
        for (Player player : this.players) {
            if (!this.allHandTotalsLessThan21.isEmpty()) {
                if ((player.calculateHandTotal() == (Collections.max(this.allHandTotalsLessThan21)))
                        && (allHandTotals.indexOf(Collections.max(allHandTotals)) == allHandTotals.lastIndexOf(Collections.max(allHandTotals)))) {
                    return "The winner is " + player.name + " with " + player.calculateHandTotal() + " points.";
                }
            }
        }
        if (this.allHandTotalsLessThan21.isEmpty()){
            return "Sorry, everybody lost...";
        }
        else {
            return "It's a draw.";
        }
    }

}
