package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    Map<String, String> mapData;

    public InMemoryKV(Map<String, String> map) {
        //this.map = map;
        this.mapData = new HashMap<>();
        map.forEach((key, value) -> {
           this.mapData.put(key, value);
        });
    }

    @Override
    public void set(String key, String value) {
        this.mapData.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.mapData.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.mapData.getOrDefault(key, defaultValue);
        //return null;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.mapData);
    }

}
// END
