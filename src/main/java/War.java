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
            System.out.println("WAAAAAAAARRRRRRRR!");
            System.out.println("PLAYER 1: " + player1.toString());
            System.out.println("PLAYER 2: " + player2.toString());
            war(card1);
        }

        System.out.println("P1: " + player1.getNumberOfCards() + " cards\t\tP2: "
                + player2.getNumberOfCards() + " cards\n");
    }

    private void war(int card) {
        int card1, card2;
        ArrayList<Integer> warCards1 = new ArrayList<Integer>();
        ArrayList<Integer> warCards2 = new ArrayList<Integer>();
        warCards1.add(card);
        warCards2.add(card);
        boolean warring = true;

        while (warring) {
            // "face down" cards
            card1 = player1.drawCard();
            card2 = player2.drawCard();
            if (outOfCards(card1, card2, warCards1, warCards2)) break;
            System.out.println("(face down: " + card1 + ", " + card2 + ")");
            warCards1.add(card1);
            warCards2.add(card2);

            card1 = player1.drawCard();
            card2 = player2.drawCard();
            System.out.println("PLAYER 1: " + player1.toString());
            System.out.println("PLAYER 2: " + player2.toString());
            if (outOfCards(card1, card2, warCards1, warCards2)) break;
            System.out.println("P1: " + card1 + "\tP2: " + card2);
            warCards1.add(card1);
            warCards2.add(card2);
            
            if (card1 < card2) {
                player2.addCards(warCards1);
                player2.addCards(warCards2);
                System.out.println("Player 2 wins this war.\n");
                warring = false;
            } else if (card2 < card1) {
                player1.addCards(warCards2);
                player1.addCards(warCards1);
                System.out.println("Player 1 wins this war.\n");
                warring = false;
            }

        }

    }
    
    private boolean outOfCards(int card1, int card2, ArrayList<Integer> warCards1, ArrayList<Integer> warCards2) {
        if (0 == card1) {
            player2.addCards(warCards1);
            player2.addCards(warCards2);
        }

        if (0 == card2) {
            player1.addCards(warCards2);
            player1.addCards(warCards1);
        }

        return outOfCards(card1, card2);

    }

    private boolean outOfCards(int card1, int card2) {
        if (0 == card1) {
            System.out.println("Player 1 ran out of cards. Player 2 wins!");
            player2.addCard(card2);
            return true;
        }

        if (0 == card2) {
            System.out.println("Player 2 ran out of cards. Player 1 wins!");
            player1.addCard(card1);
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println("WAAAAAAAAARRRRRRRR!");

    }

}
