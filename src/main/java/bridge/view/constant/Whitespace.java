package bridge.view.constant;

public enum Whitespace {
    SPACE(" ");

    private final String whitespace;

    private Whitespace (String whitespace) {
        this.whitespace = whitespace;
    }

    public String get() {
        return whitespace;
    }
}
