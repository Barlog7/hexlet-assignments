package exercise;

import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage{
    String pathToFile;
    Map<String, String> mapData;

    public FileKV(String pathToFile, Map<String, String> mapData) {
        this.pathToFile = pathToFile;
        this.mapData = mapData;
        putStringToFile();
    }

    @Override
    public void set(String key, String value) {
        this.mapData.put(key, value);
        putStringToFile();
    }

    @Override
    public void unset(String key) {
        this.mapData.remove(key);
        putStringToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        getDataToMap();
        return this.mapData.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        getDataToMap();
        return this.mapData;
    }
    public  void putStringToFile() {
        String stringData = Utils.serialize(this.mapData);
        Utils.writeFile(pathToFile, stringData);
    }
    public  void getDataToMap() {
        String getData = Utils.readFile(pathToFile);
        mapData = Utils.unserialize(getData);
    }
}
// END
