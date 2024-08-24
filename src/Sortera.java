import java.util.ArrayList;
import java.util.Collections;

public class Sortera {
    private ArrayList<Inmatning.Elpris> sortedList;

    public void sortList(ArrayList<Inmatning.Elpris> lista) {
        sortedList = new ArrayList<>(lista);
        Collections.sort(sortedList);

    }

    public ArrayList<Inmatning.Elpris> getSortedList(ArrayList<Inmatning.Elpris> lista) {
        sortList(lista);
        return sortedList;
    }

    public void printList() {
        for (Inmatning.Elpris el : sortedList) {
            System.out.println(el.fromTime + "-" + el.toTime + ": " + el.pris + " öre");
        }
    }
}
