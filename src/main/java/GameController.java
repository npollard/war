import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    Player player1, player2;
    GameView gameView;
    boolean gameOver;

    public GameController() {
        this.gameView = new GameView();
        this.gameOver = false;
    }

    public boolean gameIsOver() {
        return gameOver;
    }

    public void startGame() {
        List<Integer> shuffledCards = getShuffledCards();
        List<Integer> player1Cards = new ArrayList<Integer>(shuffledCards.subList(0, 26));
        List<Integer> player2Cards = new ArrayList<Integer>(shuffledCards.subList(26, 52));
        Player player1 = new Player(player1Cards);
        Player player2 = new Player(player2Cards);
        startGame(player1, player2);

    }


    public void startGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        gameView.showGameStart();

    }

    public void playGame() {

        while (!gameOver) {

            // wait for Enter to continue
            try {
                System.in.read();
            } catch (Exception e) {
                System.err.println("ERROR: " + e.getLocalizedMessage());
            }
            
            battle();
        }

    }

    public void battle() {
        int card1 = player1.drawCard();
        int card2 = player2.drawCard();
        if (outOfCards(card1, card2)) {
            return;
        }

        gameView.showDraw(card1, card2);
       
        if (card1 < card2) {
            player2.addCard(card1);
            player2.addCard(card2);
            gameView.showBattle(1);
        } else if (card2 < card1) {
            player1.addCard(card2);
            player1.addCard(card1);
            gameView.showBattle(2);
        } else {
            war(card1); 
        }

        if (!gameOver) {
            gameView.showResult(player1.getNumberOfCards(), player2.getNumberOfCards());
        }

    }

    private void war(int card) {
        int card1, card2;
        List<Integer> warCards1 = new ArrayList<Integer>();
        List<Integer> warCards2 = new ArrayList<Integer>();
        warCards1.add(card);
        warCards2.add(card);
        boolean warring = true;
        gameView.showWarStart();

        while (warring) {
            // "face down" cards
            card1 = player1.drawCard();
            card2 = player2.drawCard();
            if (outOfCards(card1, card2, warCards1, warCards2)) break;
            warCards1.add(card1);
            warCards2.add(card2);

            card1 = player1.drawCard();
            card2 = player2.drawCard();
            if (outOfCards(card1, card2, warCards1, warCards2)) break;
            gameView.showWarDraw(card1, card2);
            warCards1.add(card1);
            warCards2.add(card2);
            
            if (card1 < card2) {
                player2.addCards(warCards1);
                player2.addCards(warCards2);
                warring = false;
                gameView.showWarEnd(2);
            } else if (card2 < card1) {
                player1.addCards(warCards2);
                player1.addCards(warCards1);
                warring = false;
                gameView.showWarEnd(1);
            }

        }

    }
    
    private boolean outOfCards(int card1, int card2, List<Integer> warCards1, List<Integer> warCards2) {
        if (0 == card1 && 0 < card2) {
            player2.addCards(warCards1);
            player2.addCards(warCards2);
        }

        if (0 == card2 && 0 < card1) {
            player1.addCards(warCards2);
            player1.addCards(warCards1);
        }

        return outOfCards(card1, card2);

    }

    private boolean outOfCards(int card1, int card2) {
        // both players are out of cards, choose winner at random
        if (0 == card1 && 0 == card2) {
            int winner = (Math.random() < .5 ? 1 : 2); 
            gameView.showGameOver(winner);
            gameOver = true;
            return true;
        }

        if (0 == card1) {
            player2.addCard(card2);
            gameOver = true;
            gameView.showGameOver(2);
            return true;
        }

        if (0 == card2) {
            player1.addCard(card1);
            gameOver = true;
            gameView.showGameOver(1);
            return true;
        }

        return false;

    }

    private List<Integer> getShuffledCards() {
        List<Integer> cards = new ArrayList<Integer>();
        for (int suit = 0; suit < 4; suit++) {
            for (int num = 2; num <= 14; num++) {
                cards.add(num);
            }
        }
        Collections.shuffle(cards);
        return cards;
    }

    public static void main(String[] args) {
        GameController gameOfWar = new GameController();
        gameOfWar.startGame();
        gameOfWar.playGame();

    }

}
