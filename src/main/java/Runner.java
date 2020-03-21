import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Runner {

    public static void main(String[] args) {

        Deck deck = new Deck();
        Game game = new Game(deck);

        Scanner in = new Scanner(System.in);
        System.out.println("How many players are playing the game? ");
        String number = in.nextLine();
        System.out.println(number + " players are playing this game.");


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

            //Twist or Stick logic here

            System.out.println(player.getName() + ", do you want to twist or stick?");
            Scanner twistOrStick = new Scanner(System.in);
            String twistOrStickInput = twistOrStick.nextLine();

            while (twistOrStickInput.equals("twist")) {
                //deal one more card
                game.twist_dealOneMoreCard(deck, player);

                System.out.println(player.getName() + " has now been dealt the "
                            + player.hand.get((player.hand.size()-1)).getRank() + " of " + player.hand.get((player.hand.size()-1)).getSuit());
                System.out.println(player.getName() + "'s hand total is now "+player.calculateHandTotal());

                System.out.println(player.getName() + ", do you want to twist or stick?");
                Scanner twistOrStickAgain = new Scanner(System.in);
                String twistOrStickInputAgain = twistOrStickAgain.nextLine();
                twistOrStickInput = twistOrStickInputAgain;
            }

            System.out.println("--------------------------------");
        }


        game.pushAllHandTotalsToArray();
        System.out.println(game.findTheWinner());


    }
}
