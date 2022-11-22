package bridge.map;

public enum Crossing {

    SUCCESS("O"),
    FAIL("X"),
    EMPTY(" ");

    private final String letter;

    Crossing(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
