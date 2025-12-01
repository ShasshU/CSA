// FRQ 3: Memory Lane

public class MemoryLane {

    private Card[] cards;
    private int numCards;

    // Part (a)
    public boolean isValidArrangement() {
        int i = 0;
        while (i < numCards) {
            int matches = 0;

            int j = 0;
            while (j < numCards) {
                if (j != i && cards[i].equals(cards[j])) {
                    matches++;
                }
                j++;
            }
            if (matches != 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    // Part (b)
    public void removeCard(int k) {
        int i = k;

        while (i < numCards - 1) {
            cards[i] = cards[i + 1];
            i++;
        }
        numCards--;
    }

    // Part (c)
    public boolean openTwoCards(int k1, int k2) {
        if (cards[k1].equals(cards[k2])) {
            if (k2 > k1) {
                removeCard(k2);
                removeCard(k1);
            } else {
                removeCard(k1);
                removeCard(k2);
            }
            return true;
        }

        return false;
    }

}
