package bridge.Enums;

public enum View {
    UPPER_POSITION("U"),
    LOWER_POSITION("D"),
    SUCCESS("| O "),
    FAIL("| X "),
    BLANK("|   ");

    private final String string;

    View(String string) {
        this.string = string;
    }

    public String toString() {
        return string;
    }
}
