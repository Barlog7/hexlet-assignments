package exercise;

import java.time.LocalDate;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        return list.stream()
                .filter(man -> man.get("gender").equals("male"))
                .sorted((name1, name2) -> toLocalDate(name1.get("birthday")).compareTo(toLocalDate(name2.get("birthday"))))
                .map(man -> man.get("name"))
                .collect(Collectors.toList());
    }
    public static LocalDate toLocalDate(String s) {
        return LocalDate.parse(s);
    }
}
// END
