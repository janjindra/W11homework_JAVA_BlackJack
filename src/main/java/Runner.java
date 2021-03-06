import java.util.*;
import static java.lang.Integer.parseInt;

public class Runner {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Game game = new Game();

        System.out.println(" ____  _            _        _            _ ");
        System.out.println("|  _ `| |          | |      | |          | | ");
        System.out.println("| |_) | | __ _  ___| | __   | | __ _  ___| | __ ");
        System.out.println("|  _ <| |/ _` |/ __| |/ /   | |/ _` |/ __| |/ / ");
        System.out.println("| |_) | | (_| | (__|   < |__| | (_| | (__|   < ");
        System.out.println("|____/|_|`__,_|``___|_|`_`____/ `__,_|`___|_|`_` ");
        System.out.println(" ");

        String play = "YES";
        while (play.matches("(?i)YES|Y")) {

            //clear all arrays if the game is to be played again:
            deck.cards.clear();
            game.players.clear();
            game.allHandTotals.clear();
            game.allHandTotalsLessThan21.clear();

            Scanner in = new Scanner(System.in);
            System.out.println("How many players are playing the game? ");
            String numberOfPlayers = in.nextLine();
            System.out.println(numberOfPlayers + " players are playing this game.");


            for ( int i = 0; i < parseInt(numberOfPlayers); i++ ) {
                System.out.println("Enter the name of player " + (i + 1) + ": ");
                Scanner name = new Scanner(System.in);
                String playerName = name.next();
                Player playerInput = new Player(playerName);
                game.addPlayer(playerInput);
            }

            game.startGame(deck);

            System.out.println("--------------------------------");
            for ( Player player : game.players ) {
                System.out.println(player.getName() + " has been dealt the " + player.hand.get(0).getRank()
                        + " of " + player.hand.get(0).getSuit() + " and " + player.hand.get(1).getRank() + " of " + player.hand.get(1).getSuit());
                System.out.println(player.getName() + "'s hand total is " + player.calculateHandTotal());

                //Twist or Stick logic here
                System.out.println(player.getName() + ", do you want to twist or stick?");
                Scanner twistOrStick = new Scanner(System.in);
                String twistOrStickInput = twistOrStick.nextLine();

                while (twistOrStickInput.equals("twist")) {
                    //deal one more card
                    game.twist_dealOneMoreCard(deck, player);

                    System.out.println(player.getName() + " has now been dealt the "
                            + player.hand.get((player.hand.size() - 1)).getRank() + " of " + player.hand.get((player.hand.size() - 1)).getSuit());
                    System.out.println(player.getName() + "'s hand total is now " + player.calculateHandTotal());


                    if (player.calculateHandTotal() <= 21) {
                        System.out.println(player.getName() + ", do you want to twist or stick?");
                        Scanner twistOrStickAgain = new Scanner(System.in);
                        twistOrStickInput = twistOrStickAgain.nextLine();
                    } else {
                        System.out.println("You are over 21. You lost...");
                        twistOrStickInput = "lost";
                    }
                }
                System.out.println("--------------------------------");
            }

            //Find the winner
            System.out.println(game.findTheWinner());

            //Wanna play again?
            Scanner again = new Scanner(System.in);
            System.out.println("Do you want to play Back Jack again? Enter YES or NO");
            play = again.nextLine();
        }
    }
}
