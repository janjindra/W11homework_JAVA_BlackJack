import java.util.ArrayList;
import java.util.Collections;


public class Game {

    public ArrayList<Player> players;
    public Deck deck;
    public ArrayList<Integer> allHandTotals;


    public Game (Deck deck){
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
        this.allHandTotals = new ArrayList<Integer>();

//        deck.add52cardsToDeck();
//        deck.shuffleCards();
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

    public ArrayList<Integer> removeAllHandTotalsGreaterThan21(){
        ArrayList<Integer> allHandTotalsGreaterThan21 = this.allHandTotals;
        for (Integer i : allHandTotalsGreaterThan21){
            if (i > 21) {
                allHandTotalsGreaterThan21.remove(i);
            }
        }
        return allHandTotalsGreaterThan21;
    }

    public String findTheWinner(){
        String winnerName;
        int winnerHandTotal;
        int bust = 21;
//        removeAllHandTotalsGreaterThan21();
        for (Player player : this.players) {
            if ( (player.calculateHandTotal() == Collections.max(removeAllHandTotalsGreaterThan21()) &&
            (allHandTotals.indexOf(Collections.max(allHandTotals)) == allHandTotals.lastIndexOf(Collections.max(allHandTotals))))) {
                String winnerAnnouncement = "The winner is "+player.name +" with "+player.calculateHandTotal()+" points.";
                winnerName = player.getName();
                winnerHandTotal = player.calculateHandTotal();
                return winnerAnnouncement;
            }
        }
        String draw = "It's a draw.";
        return draw;
    }

}
