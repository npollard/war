import java.util.ArrayList;

public class Player {
    ArrayList<Integer> cards;

    public void setCards(ArrayList<Integer> cards) {
        this.cards = cards;

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) < 2 || 13 < cards.get(i)) {
                System.err.println("ERROR: invalid card " + cards.get(i) + " removed.");
                cards.remove(i);
            }
        }

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
        if (card < 2 || 13 < card) {
            System.err.println("ERROR: invalid card.");
            return;
        }

        cards.add(card);

    }

}
