package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int n) {
        //var sortedList = new ArrayList<Home>();
        if (list.isEmpty()) {
            List<String> returnListEmpty = new ArrayList<>();
            return returnListEmpty;
        }
        var sortedList = list.stream().sorted(Comparator.comparingDouble(Home::getArea)).toList();
        return sortedList.subList(0, n).stream().map(home -> home.toString()).toList();

    }
}
// END
