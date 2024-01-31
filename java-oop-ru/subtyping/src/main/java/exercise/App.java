package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storege) {
        Map<String, String> currentMap = new HashMap<String, String>(storege.toMap());

        currentMap.forEach((key, value) -> {
            //changeMap.remove(key);
            //currentMap.put(value, key);
            storege.unset(key);
            storege.set(value, key);

        });
    }
}
// END
