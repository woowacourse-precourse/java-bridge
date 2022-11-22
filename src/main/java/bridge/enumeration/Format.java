package bridge.enumeration;

public enum Format {
    WRONG(" X "),
    CORRECT(" O "),
    BLANK("   "),
    FIRST_BRAKET("["),
    LAST_BRAKET("]"),
    SEPARATOR("|");

    private final String format;

    Format(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
