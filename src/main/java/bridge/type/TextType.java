package bridge.type;

public enum TextType {

    UP("U"),
    DOWN("D");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
