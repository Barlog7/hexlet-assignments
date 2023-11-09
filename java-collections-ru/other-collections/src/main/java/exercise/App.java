package exercise;

import java.util.*;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        LinkedHashMap<String, String> returnMap = new LinkedHashMap<>();
        Set<String> index = new HashSet<>();
        map1.entrySet().stream()
                .forEach(x -> {
                    index.add(x.getKey());
                }
        );
        map2.entrySet().stream()
                .forEach(x -> {
                    index.add(x.getKey());
                });
        index.stream().forEach(x -> {
            Object o1 = map1.getOrDefault(x, "not found");
            Object o2 = map2.getOrDefault(x, "not found");
            String sReturn = returnStatus(o1, o2);
            returnMap.put(x, sReturn);
        });
        return returnMap;
    }
    public static String returnStatus(Object o1, Object o2) {
        if (o1.equals(o2)) {
            return "unchanged";
        } else if (o1.equals("not found")) {
            return "added";
        } else if (o2.equals("not found")) {
            return "deleted";
        } else {
            return "changed";
        }
    }
}
//END
