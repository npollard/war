import java.util.ArrayList;

public class War {
    Player player1, player2;

    public War() {
        player1 = new Player();
        player2 = new Player();
    }

    public void setCards(ArrayList<Integer> player1Cards, ArrayList<Integer> player2Cards) {
        player1.setCards(player1Cards);
        player2.setCards(player2Cards);
    }

    public int getNumberOfCards(int playerNumber) {
        if (1 != playerNumber && 2 != playerNumber) {
            System.err.println("ERROR: invalid player.");
            return 0;
        }

        if (1 == playerNumber) {
            return player1.getNumberOfCards();
        } else {
            return player2.getNumberOfCards();
        }

    }

    public void battle() {
        System.out.println("---------------------");
        int card1 = player1.drawCard();
        int card2 = player2.drawCard();
        System.out.println("P1: " + card1 + "\tP2: " + card2 + "\n");
       
        if (card1 < card2) {
            player2.addCard(card1);
            player2.addCard(card2);
            System.out.println("Player 1 wins this battle.\n");
        } else if (card2 < card1) {
            player1.addCard(card2);
            player1.addCard(card1);
            System.out.println("Player 2 wins this battle.\n");
        } else {
            // WAR!
        }

        System.out.println("P1: " + player1.getNumberOfCards() + " cards\t\tP2: "
                + player2.getNumberOfCards() + " cards\n");
    }
    

    public static void main(String[] args) {
        System.out.println("WAAAAAAAAARRRRRRRR!");

    }

}
