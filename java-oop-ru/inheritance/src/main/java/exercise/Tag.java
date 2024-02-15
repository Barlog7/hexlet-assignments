package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag {
    String mainTag;
    String mapTag;
    //String textTag;
    String listTag;
    String returnText;
    //String textHtml;

    public void setMainTag(String mainTag) {
        this.mainTag = mainTag;
    }

    public void setMapTag(Map<String, String> map) {
        mapTag ="";
        map.forEach((key, value) -> {
            mapTag = mapTag + String.format(" %s=\"%s\"", key, value);
        });
    }
    @Override
    public String toString() {
        return returnText;
    }

}
// END
