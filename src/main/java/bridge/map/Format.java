package bridge.map;

public enum Format {

    BEGIN("[ "),
    END(" ]"),
    DIVISION(" | ");

    private final String letters;

    Format(String letters) {
        this.letters = letters;
    }

    public String getLetters() {
        return letters;
    }
}
