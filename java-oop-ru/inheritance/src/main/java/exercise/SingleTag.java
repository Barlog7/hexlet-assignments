package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    SingleTag(String tag, Map<String, String> map) {
        //super();
        setMainTag(tag);
        setMapTag(map);
        returnText = String.format("<%s%s>", mainTag, mapTag);
        //return tagHtml;
    }
}
// END
