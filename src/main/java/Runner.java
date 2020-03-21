import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Runner {

    public static void main(String[] args) {

        Deck deck = new Deck();
        Game game = new Game(deck);

        System.out.println("How many players are playing the game? ");
        Scanner numberOfPlayers = new Scanner(System.in);
        String number = numberOfPlayers.next();
        System.out.println("The number of players is: "+number);
//        numberOfPlayers.close();


        for (int i=0; i < parseInt(number); i++) {

            System.out.println("Enter the name of player " + (i+1)+": ");
            Scanner name = new Scanner(System.in);
            String playerName = name.next();
            Player playerInput = new Player(playerName);
            game.addPlayer(playerInput);
        }

        game.startGame(deck);

        System.out.println("--------------------------------");
        for (Player player : game.players)
        {
            System.out.println(player.getName() + " has been dealt the " + player.hand.get(0).getRank()
                    + " of " + player.hand.get(0).getSuit() + " and " + player.hand.get(1).getRank() + " of " + player.hand.get(1).getSuit());
            System.out.println(player.getName() + "'s hand total is "+player.calculateHandTotal());
            System.out.println("--------------------------------");
        }

        game.pushAllHandTotalsToArray();
        System.out.println(game.findTheWinner());


    }
}
