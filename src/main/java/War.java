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
        System.out.println("ATTACK!");

    }
    

    public static void main(String[] args) {
        System.out.println("WAAAAAAAAARRRRRRRR!");

    }

}
