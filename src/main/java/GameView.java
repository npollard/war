
public class GameView {

    public void showGameStart() {
        System.out.println("\n\n*******************************************************************");
        System.out.println("***\t\t\t\t\t\t\t\t***");
        System.out.println("***\t\t\tWelcome to War!\t\t\t\t***");
        System.out.println("***\t\t\t\t\t\t\t\t***");
        System.out.println("***    INSTRUCTIONS: Press Enter to advance through the game.\t***");
        System.out.println("***\t\t\t\t\t\t\t\t***");
        System.out.println("*******************************************************************\n\n");

    }

    public void showDraw(int card1, int card2) {
        System.out.println("------------------------------------\n");
        System.out.println("P1 draws " + card1 + "\tP2 draws " + card2 + "\n");

    }
       
    public void showBattle(int winner) {
        System.out.println("Player " + winner + " wins this battle.");

    }

    public void showResult(int numOfCards1, int numOfCards2) {
        System.out.println("P1: " + numOfCards1 + " cards\t\tP2: " + numOfCards2 + " cards\n");

    }

    public void showWarStart() {
        System.out.println("################");
        System.out.println("It's a war!");
    
    }

    public void showWarDraw(int card1, int card2) {
        System.out.println("P1 draws " + card1 + "\tP2 draws " + card2);
    
    }

    public void showWarEnd(int winner) {
        System.out.println("Player " + winner + " wins this war.");
        System.out.println("################\n");

    }
    
    public void showGameOver(int winner) {
        System.out.println("\t\t\tPlayer " + winner + " wins!");
        System.out.println("\n\t\t\t**** GAME OVER ****\n");
    
    }

}
