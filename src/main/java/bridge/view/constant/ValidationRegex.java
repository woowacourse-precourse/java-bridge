package bridge.view.constant;

public enum ValidationRegex {
    EMPTY_VALUE("^$"),
    NUMBER("^[0-9]+$"),
    VALID_PANEL("^[UD]+$");

    private final String regex;

    private ValidationRegex (String regex) {
        this.regex = regex;
    }

    public String get() {
        return regex;
    }
}
