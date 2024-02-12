package exercise;

// BEGIN
class InputTag implements TagInterface {
    String type;
    String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String render() {
        String retStr = "<input type=\"" + type + "\" value=\"" + value +"\">";
        return retStr;
    }
}
// END
