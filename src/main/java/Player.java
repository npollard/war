import java.util.ArrayList;

public class Player {
    ArrayList<Integer> cards;

    public void setCards(ArrayList<Integer> cards) {
        this.cards = cards;
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
        cards.add(card);
    }

}
