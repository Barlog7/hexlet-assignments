package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {

    public PairedTag(String tag, Map<String, String> map, String text, List<Tag> list) {

        setMainTag(tag);
        setMapTag(map);
        getListTaxt(list);
        returnText = String.format("<%s%s>%s%s</%s>", mainTag, mapTag, text, listTag, mainTag);
    }
    public void getListTaxt(List<Tag> list) {
        listTag = "";
        for (var text : list) {
            listTag = listTag + text.returnText;
        }

    }
}
// END
