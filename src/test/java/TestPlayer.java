import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPlayer {
    Player player;

    @Before
    public void setup() {
        List<Integer> cards = new ArrayList<Integer>();
        cards.add(1);
        cards.add(2);
        cards.add(3);
        cards.add(13);
        cards.add(15);
        player = new Player(cards);
    }

    @Test
    public void testCards() {
        assertEquals("Draw", 2, player.drawCard());
        assertEquals("Draw", 3, player.drawCard());
        player.addCard(9);
        player.addCard(8);
        assertEquals("Draw", 13, player.drawCard());
        assertEquals("Draw", 9, player.drawCard());
        assertEquals("Draw", 8, player.drawCard());
        assertEquals("Draw (empty)", 0, player.drawCard());
        assertEquals("Draw (empty)", 0, player.drawCard());
        assertEquals("Draw (empty)", 0, player.drawCard());
    }
}

