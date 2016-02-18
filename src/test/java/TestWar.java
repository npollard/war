import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestWar {
    Player player1, player2;
    War war;

    @Test
    public void testBattle() {
        List<Integer> player1Cards = new List<Integer>();
        player1Cards.add(5);
        player1Cards.add(2);

        List<Integer> player2Cards = new List<Integer>();
        player2Cards.add(3);
        player2Cards.add(4);

        // [5, 2] vs. [3, 4]
        player1 = new Player(player1Cards);
        player2 = new Player(player2Cards);
        war = new War(player1, player2);
 
        assertEquals("Start", 2, player1.getNumberOfCards());
        assertEquals("Start", 2, player2.getNumberOfCards());
        war.battle();
        assertEquals("Battle", 3, player1.getNumberOfCards());
        assertEquals("Battle", 1, player2.getNumberOfCards());
        war.battle();
        war.battle();
        war.battle();
        assertEquals("Done", 4, player1.getNumberOfCards());
        assertEquals("Done", 0, player2.getNumberOfCards());

    }

    @Test
    public void testShortWar() {
        List<Integer> player1Cards = new List<Integer>();
        player1Cards.add(3);
        player1Cards.add(2);
        player1Cards.add(6);

        List<Integer> player2Cards = new List<Integer>();
        player2Cards.add(4);
        player2Cards.add(2);
        player2Cards.add(5);

        // [3, 2, 6] vs. [4, 2, 5]
        player1 = new Player(player1Cards);
        player2 = new Player(player2Cards);
        war = new War(player1, player2);

        assertEquals("Start", 3, player1.getNumberOfCards());
        assertEquals("Start", 3, player2.getNumberOfCards());
        war.battle();
        assertEquals("Battle", 2, player1.getNumberOfCards());
        assertEquals("Battle", 4, player2.getNumberOfCards());
        war.battle();
        assertEquals("War - Done", 0, player1.getNumberOfCards());

    }

    @Test
    public void testWar() {
        List<Integer> player1Cards = new List<Integer>();
        player1Cards.add(3);
        player1Cards.add(2);
        player1Cards.add(6);
        player1Cards.add(11);

        List<Integer> player2Cards = new List<Integer>();
        player2Cards.add(4);
        player2Cards.add(2);
        player2Cards.add(5);
        player2Cards.add(10);

        // [3, 2, 6, 11] vs. [4, 2, 5, 10]
        player1 = new Player(player1Cards);
        player2 = new Player(player2Cards);
        war = new War(player1, player2);

        assertEquals("Start", 4, player1.getNumberOfCards());
        assertEquals("Start", 4, player2.getNumberOfCards());
        war.battle();
        assertEquals("Battle", 3, player1.getNumberOfCards());
        assertEquals("Battle", 5, player2.getNumberOfCards());
        war.battle();
        assertEquals("War", 6, player1.getNumberOfCards());
        assertEquals("War", 2, player2.getNumberOfCards());
        war.battle();
        assertEquals("Battle", 5, player1.getNumberOfCards());
        assertEquals("Battle", 3, player2.getNumberOfCards());

    }

    @Test
    public void testMultiWar() {
        List<Integer> player1Cards = new List<Integer>();
        List<Integer> player2Cards = new List<Integer>();
        for (int i = 0; i < 8; i++) {
            player1Cards.add(2);
            player2Cards.add(2);
        }

        player1Cards.set(6, 8);
        player1Cards.set(7, 8);

        // [2, 2, 2, 2, 2, 2, 8, 8] vs. [2, 2, 2, 2, 2, 2, 2, 2]
        player1 = new Player(player1Cards);
        player2 = new Player(player2Cards);
        war = new War(player1, player2);

        assertEquals("Start", 8, player1.getNumberOfCards());
        assertEquals("Start", 8, player2.getNumberOfCards());
        war.battle();
        assertEquals("War * 3", 15, player1.getNumberOfCards());
        assertEquals("War * 3", 1, player2.getNumberOfCards());
        war.battle();
        assertEquals("Done", 16, player1.getNumberOfCards());
        assertEquals("Done", 0, player2.getNumberOfCards());

    }
}

