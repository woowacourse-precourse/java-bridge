package bridge.constant;

public enum Deck {
    MATCH("O"),
    WRONG("X"),
    BLANK(" ");

    private final String displayCharacter;

    Deck(String displayCharacter) {
        this.displayCharacter = displayCharacter;
    }

    public String getDisplayCharacter() {
        return displayCharacter;
    }
}
