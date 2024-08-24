import java.util.ArrayList;

public class MinMax {
    public void minMaxMid(ArrayList<Inmatning.Elpris> sortedArray) {
        System.out.println("Lägsta pris: " + printHour(sortedArray.getFirst()));
        System.out.println("Högsta pris: " + printHour(sortedArray.getLast()));
        System.out.println("Medelpriset: " + midPrice(sortedArray) + " Öre");
    }

    private String printHour(Inmatning.Elpris elpris) {
        return elpris.fromTime + "-" + elpris.toTime + ": " + elpris.pris + " Öre";
    }

    private int midPrice(ArrayList<Inmatning.Elpris> sortedArray) {
        int sumOfPrices = 0;
        for (Inmatning.Elpris elpris : sortedArray) {
            sumOfPrices += elpris.pris;
        }
        return sumOfPrices / sortedArray.size();
    }

}
