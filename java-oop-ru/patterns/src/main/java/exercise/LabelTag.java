package exercise;

// BEGIN
class LabelTag implements TagInterface {

    private TagInterface tagL;
    private String textL;
    public LabelTag(String text, TagInterface tag) {
        tagL = tag;
        textL = text;
    }

    @Override
    public String render() {
        return "<label>" + textL +  tagL.render() + "</label>";
    }
}
// END
