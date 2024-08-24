import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Inmatning inmatning = new Inmatning();
        Sortera sortera = new Sortera();
        MinMax minMax = new MinMax();
        BestPrice priceWindow = new BestPrice();

        String[] menuChoises = {"Inmatning", "Min, Max, Medel", "Sortera", "Bästa Laddningstid (4h)"};
        String[] inputOptions = fetchInputOptions(menuChoises);
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            printMenu(menuChoises);
            System.out.print("Välj: ");
            String input = sc.nextLine().toLowerCase();
//            Dynamic input handler to for correct choises
            if (Arrays.stream(inputOptions).noneMatch(input::equals)) {
                System.out.println("!!! Vänligen välj ett korrekt menyval !!!\n\n");
            }
            switch (input) {
                case "1":
                    inmatning.inmatningUi();
                    break;
                case "2":
                    System.out.println("Skriver ut min max");
                    if (inmatning.getElpriser().isEmpty()) {
                        System.out.println("Finns inget att sortera");
                    } else {
                        minMax.minMaxMid(sortera.getSortedList(inmatning.getElpriser()));
                    }
                    break;
                case "3":
                    System.out.println("Sorterar listan av priser");
                    if (inmatning.getElpriser().isEmpty()) {
                        System.out.println("Finns inget att sortera!");
                    } else {
                        sortera.sortList(inmatning.getElpriser());
                        sortera.printList();
                    }
                    break;

                case "4":
                    System.out.println("Visar bästa laddningstid");
                    priceWindow.priceWindow(inmatning.getElpriser(), 4);
                    break;
                case "e":
                    isRunning = false;
            }
        }
    }

    static String[] fetchInputOptions(String[] menuChoises) {
        String[] returnValues = new String[menuChoises.length + 1];
        for (int i = 0; i < menuChoises.length + 1; i++) {
            returnValues[i] = String.valueOf(i + 1);
        }
        returnValues[menuChoises.length] = "e";
        return returnValues;
    }

    //    Method to print menu options
    static void printMenu(String[] menuChoises) {
        int index = 1;
        for (String option : menuChoises) {
            System.out.println(index + ": " + option);
            index++;
        }
        System.out.println("e: Avsluta");
    }
}