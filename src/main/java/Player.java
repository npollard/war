import java.util.Iterator;
import java.util.List;

public class Player {
    List<Integer> cards;

    public Player(List<Integer> cards) {
        this.cards = cards;
        validateCards();
    }

    public int getNumberOfCards() {
        return cards.size();

    }

    public int drawCard() {
        if (0 == cards.size()) {
            return 0;
        }

        return cards.remove(0);

    }

    public void addCard(int card) {
        if (card < 2 || 14 < card) {
            System.err.println("ERROR: invalid card " + card + " not added.");
            return;
        }

        cards.add(card);

    }

    public void addCards(List<Integer> newCards) {
        cards.addAll(newCards);
        validateCards();

    }

    private void validateCards() {
        for (Iterator<Integer> iterator = cards.iterator(); iterator.hasNext();) {
            int card = iterator.next();
            if (card < 2 || 14 < card) {
                iterator.remove();
            }
        }

    }

    public String toString() {
        return cards.toString();
    
    }

}
