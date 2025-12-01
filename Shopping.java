
public class Shopping {

    int maxDistance;
    double totalPrice;
    int numOptions;
    String bestStore;
    double bestPrice;
    int bestDistance;

    public Shopping(int maxDistance) {
        totalPrice = 0.0;
        numOptions = 0;
        bestStore = "";
        bestPrice = Double.MAX_VALUE;
        bestDistance = Integer.MAX_VALUE;
        this.maxDistance = maxDistance;

    }

    public void addShoppingOption(String store, double price, int distance) {
        totalPrice += price;
        numOptions++;
        if (distance <= maxDistance && price < bestPrice) {
            bestStore = store;
            bestPrice = price;
            bestDistance = distance;
        }
    }

    public double streetPrice() {
        double averagePrice = totalPrice / numOptions;
        return averagePrice;
    }

    public String toString() {

        return bestStore + " " + bestPrice + " " + bestDistance;

    }
}