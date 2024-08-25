import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    private ArrayList<InputData.Elpris> sortedList;

    public void sortList(ArrayList<InputData.Elpris> lista) {
        sortedList = new ArrayList<>(lista);
        Collections.sort(sortedList);

    }

    public ArrayList<InputData.Elpris> getSortedList(ArrayList<InputData.Elpris> lista) {
        sortList(lista);
        return sortedList;
    }

    public void printList() {
        for (InputData.Elpris el : sortedList) {
            System.out.println(el.fromTime + "-" + el.toTime + ": " + el.pris + " öre");
        }
    }
}
