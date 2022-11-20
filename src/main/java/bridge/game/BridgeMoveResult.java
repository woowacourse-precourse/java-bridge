package bridge.game;

public enum BridgeMoveResult {
    NONE(" "),
    CORRECT("O"),
    WRONG("X"),
    ;

    private final String text;

    BridgeMoveResult(String text) {
        this.text = text;
    }

    public String text() {
        return this.text;
    }
}
