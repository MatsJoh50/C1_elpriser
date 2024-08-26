import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputData {
    private final ArrayList<Elpris> prices = new ArrayList<Elpris>();

    public static class Elpris implements Comparable<Elpris> {
        String fromTime;
        String toTime;
        double pris;

        Elpris(String inputFromTime, String inputToTime, double pris) {
            this.fromTime = inputFromTime;
            this.toTime = inputToTime;
            this.pris = pris;
        }

        @Override
        public int compareTo(Elpris o) {
            return (int) this.pris - (int) o.pris;
        }
    }


    public void inputDataUi() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("1: Manuell inmatning.");
        System.out.println("2: Inmatning från fil.");
        System.out.println("3: Automatisk inmatning.");
        System.out.println("B: Backa.");
        System.out.print("Välj: ");
        String inputCase1 = in.nextLine();
        if (!inputCase1.equals("1") && !inputCase1.equals("2") && !inputCase1.equals("3") && !inputCase1.equalsIgnoreCase("b")) {
            System.out.println("Vänligen välj ett korrekt alternativ.");
            inputDataUi();
        }
        if (inputCase1.equals("1")) {
            manual();
        } else if (inputCase1.equals("3")) {
            autoFill();
        } else if (inputCase1.equals("2")) {
            fetchFromFile();
        } else if (inputCase1.equalsIgnoreCase("b")) {
//            return;
        }
    }

    public void manual() {
//        prices.clear();
        System.out.println("Ange pris i hela ören:");
        String inputFromTime;
        String inputToTime;

        for (int i = 0; i < 24; i++) {
            inputFromTime = String.format("%02d", i);
            inputToTime = String.format("%02d", i + 1);

            System.out.print("Kl: " + inputFromTime + "-" + inputToTime + ": ");
            double inputPris = safeInput();
            Elpris elpris = new Elpris(inputFromTime, inputToTime, inputPris);
            prices.add(elpris);
        }
    }

    public void autoFill() {
        prices.clear();
        String inputFromTime;
        String inputToTime;

        for (int i = 0; i < 24; i++) {
            inputFromTime = String.format("%02d", i);
            inputToTime = String.format("%02d", i + 1);

            int inputPris = randomPrice();
            Elpris elpris = new Elpris(inputFromTime, inputToTime, inputPris);
            System.out.println(inputFromTime + "-" + inputToTime + ": " + inputPris);
            prices.add(elpris);
        }
        System.out.println("Lista fylld!");
    }

    private int randomPrice() {
        return (int) (Math.random() * 100);
    }

    public void fetchFromFile()  {
        try {
            System.out.println("läser från fil");
            String filename = "src/elpriser.csv";
            File fileElpriser = new File(filename);
            System.out.println("fil laddad");
            if (!fileElpriser.isFile()) {
                System.out.println("Kunde inte hitta filen");
            } else {
                System.out.println("fil godkänd");
                Scanner reader = new Scanner(fileElpriser);
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] tokens = line.split(",");
                    if (tokens[0].contains(":")) {
                        String timeFrom = tokens[0];
                        int formatTimeTo = Integer.parseInt(tokens[0].split(":")[0]) + 1;
                        String timeTo = String.format("%02d", formatTimeTo) + ":00";

                        if (Double.parseDouble(tokens[1]) < 0) {
                            prices.add(new Elpris(timeFrom, timeTo, (int) Double.parseDouble(tokens[1])));
                        } else {
                            prices.add(new Elpris(timeFrom, timeTo, Math.round(Float.parseFloat(tokens[1]))));
                        }


                    }

                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Elpris> getPrices() {
        return prices;
    }

    private int safeInput() {
        try {
            Scanner in = new Scanner(System.in);
            return Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ange bara i hela ören tack.");
            safeInput();
        }
        return 0;
    }
}

