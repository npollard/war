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
    public void testWar1() {
        ArrayList<Integer> player1Cards = new ArrayList<Integer>();
        player1Cards.add(1);
        player1Cards.add(2);
        player1Cards.add(4);
        player1Cards.add(8);

        ArrayList<Integer> player2Cards = new ArrayList<Integer>();
        player2Cards.add(3);
        player2Cards.add(2);
        player2Cards.add(2);
        player2Cards.add(2);

        // [ 1, 2, 4, 8] vs. [3, 2, 2, 2]
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
        assertEquals("Battle", 7, war.getNumberOfCards(1));
        assertEquals("Battle", 1, war.getNumberOfCards(2));
        war.battle();
        assertEquals("Battle", 6, war.getNumberOfCards(1));
        assertEquals("Battle", 2, war.getNumberOfCards(2));
        war.battle();
        assertEquals("Done", 8, war.getNumberOfCards(1));
        assertEquals("Done", 0, war.getNumberOfCards(2));

    }

    @Test
    public void testWar2() {
        ArrayList<Integer> player1Cards = new ArrayList<Integer>();
        ArrayList<Integer> player2Cards = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            player1Cards.add(1);
            player2Cards.add(1);
        }

        player1Cards.set(6, 2);
        player1Cards.set(7, 2);

        // [2, 2, 2, 2, 2, 2, 8, 8] VS. [2, 2, 2, 2, 2, 2, 2, 2]
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

