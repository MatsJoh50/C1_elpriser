import java.util.ArrayList;

public class BestPrice {
    private ArrayList<InputData.Elpris> bestWindowPrice = new ArrayList<InputData.Elpris>();

    public void priceWindow(ArrayList<InputData.Elpris> prices, int windowSize) {
        if (prices.isEmpty()) {
            return;
        }
        int sumHigh = 0;
        for (int i = 0; i < prices.size() - windowSize; i++) {
            int newSumHigh = 0;
            for (int j = i; j < i + windowSize; j++) {
                newSumHigh += prices.get(j).pris;
            }
            if ((newSumHigh < sumHigh) || (i == 0)) {
                sumHigh = newSumHigh;
                pushNewPriceArray(prices, i, windowSize);
            }
        }
        printBestWindowPrice();
    }

    private void pushNewPriceArray(ArrayList<InputData.Elpris> priser, int index, int size) {
        bestWindowPrice.clear();
        for (int i = index; i < index + size; i++) {
            bestWindowPrice.add(priser.get(i));
        }
    }

    private void printBestWindowPrice() {
        if (!bestWindowPrice.isEmpty()) {

            System.out.println("Skriver ut elpriser");
            for (InputData.Elpris elpris : bestWindowPrice) {
                System.out.println(elpris.fromTime + "-" + elpris.toTime + ": " + elpris.pris + " Öre");
            }
        } else {
            System.out.println("Hittade inget fönster");
        }
    }
}
