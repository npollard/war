import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestWar {
    War war;

    @Before
    public void setup() {
        war = new War();
    }

    @Test
    public void testBattle() {
        ArrayList<Integer> player1Cards = new ArrayList<Integer>();
        player1Cards.add(5);
        player1Cards.add(2);

        ArrayList<Integer> player2Cards = new ArrayList<Integer>();
        player2Cards.add(3);
        player2Cards.add(4);

        // [5, 2] vs. [3, 4]
        war.setCards(player1Cards, player2Cards);
 
        assertEquals("Start", 2, war.getNumberOfCards(1));
        assertEquals("Start", 2, war.getNumberOfCards(2));
        war.battle();
        assertEquals("Battle", 3, war.getNumberOfCards(1));
        assertEquals("Battle", 1, war.getNumberOfCards(2));
        war.battle();
        war.battle();
        assertEquals("Battle", 1, war.getNumberOfCards(1));
        assertEquals("Battle", 3, war.getNumberOfCards(2));
        war.battle();
        assertEquals("Done", 0, war.getNumberOfCards(1));
        assertEquals("Done", 4, war.getNumberOfCards(2));

    }

    @Test
    public void testShortWar() {
        ArrayList<Integer> player1Cards = new ArrayList<Integer>();
        player1Cards.add(3);
        player1Cards.add(2);
        player1Cards.add(6);

        ArrayList<Integer> player2Cards = new ArrayList<Integer>();
        player2Cards.add(4);
        player2Cards.add(2);
        player2Cards.add(5);

        // [3, 2, 6] vs. [4, 2, 5]
        war.setCards(player1Cards, player2Cards);
 
        assertEquals("Start", 3, war.getNumberOfCards(1));
        assertEquals("Start", 3, war.getNumberOfCards(2));
        war.battle();
        assertEquals("Battle", 4, war.getNumberOfCards(1));
        assertEquals("Battle", 2, war.getNumberOfCards(2));
        war.battle();
        assertEquals("War - Done", 6, war.getNumberOfCards(1));
        assertEquals("War - Done", 0, war.getNumberOfCards(2));

    }

    @Test
    public void testWar() {
        ArrayList<Integer> player1Cards = new ArrayList<Integer>();
        player1Cards.add(3);
        player1Cards.add(2);
        player1Cards.add(6);
        player1Cards.add(11);

        ArrayList<Integer> player2Cards = new ArrayList<Integer>();
        player2Cards.add(4);
        player2Cards.add(2);
        player2Cards.add(5);
        player2Cards.add(10);

        // [3, 2, 6, 11] vs. [4, 2, 5, 10]
        war.setCards(player1Cards, player2Cards);
 
        assertEquals("Start", 4, war.getNumberOfCards(1));
        assertEquals("Start", 4, war.getNumberOfCards(2));
        war.battle();
        assertEquals("Battle", 3, war.getNumberOfCards(1));
        assertEquals("Battle", 5, war.getNumberOfCards(2));
        war.battle();
        assertEquals("War", 6, war.getNumberOfCards(1));
        assertEquals("War", 2, war.getNumberOfCards(2));
        war.battle();
        assertEquals("Battle", 5, war.getNumberOfCards(1));
        assertEquals("Battle", 3, war.getNumberOfCards(2));

    }

    @Test
    public void testMultiWar() {
        ArrayList<Integer> player1Cards = new ArrayList<Integer>();
        ArrayList<Integer> player2Cards = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            player1Cards.add(2);
            player2Cards.add(2);
        }

        player1Cards.set(6, 8);
        player1Cards.set(7, 8);

        // [2, 2, 2, 2, 2, 2, 8, 8] vs. [2, 2, 2, 2, 2, 2, 2, 2]
        war.setCards(player1Cards, player2Cards);
 
        assertEquals("Start", 8, war.getNumberOfCards(1));
        assertEquals("Start", 8, war.getNumberOfCards(2));
        war.battle();
        assertEquals("War * 3", 15, war.getNumberOfCards(1));
        assertEquals("War * 3", 1, war.getNumberOfCards(2));
        war.battle();
        assertEquals("Done", 16, war.getNumberOfCards(1));
        assertEquals("Done", 0, war.getNumberOfCards(2));

    }
}

