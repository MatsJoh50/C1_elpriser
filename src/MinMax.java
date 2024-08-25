import java.util.ArrayList;

public class MinMax {
    public void minMaxMid(ArrayList<InputData.Elpris> sortedArray) {
        System.out.println("Lägsta pris: " + printHour(sortedArray.getFirst()));
        System.out.println("Högsta pris: " + printHour(sortedArray.getLast()));
        System.out.println("Medelpriset: " + midPrice(sortedArray) + " Öre");
    }

    private String printHour(InputData.Elpris elpris) {
        return elpris.fromTime + "-" + elpris.toTime + ": " + elpris.pris + " Öre";
    }

    private int midPrice(ArrayList<InputData.Elpris> sortedArray) {
        int sumOfPrices = 0;
        for (InputData.Elpris elpris : sortedArray) {
            sumOfPrices += elpris.pris;
        }
        return sumOfPrices / sortedArray.size();
    }

}
