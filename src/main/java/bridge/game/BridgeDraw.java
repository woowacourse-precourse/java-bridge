package bridge.game;

public enum BridgeDraw {
    START("["),
    FINISH("]"),
    DIVIDE("|"),
    EMPTY(" "),
    SUCCESS("O"),
    FAIL("X"),
    ;

    private final String letter;

    BridgeDraw(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}