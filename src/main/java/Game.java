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

    public void pushAllHandTotalsToArray() {
        for ( Player player : this.players ) {
            this.allHandTotals.add(player.calculateHandTotal());
        }
    }

    public String findTheWinner(){
        String winnerName;
        int winnerHandTotal;
        for (Player player : this.players) {
            if ( player.calculateHandTotal() == Collections.max(allHandTotals) &&
                    (allHandTotals.indexOf(Collections.max(allHandTotals)) == allHandTotals.lastIndexOf(Collections.max(allHandTotals)))) {
                String winnerAnnouncement = "The winner is "+player.name;
                winnerName = player.getName();
                winnerHandTotal = player.calculateHandTotal();
                return winnerAnnouncement;
            }
        }
        String draw = "It's a draw.";
        return draw;
    }

}
