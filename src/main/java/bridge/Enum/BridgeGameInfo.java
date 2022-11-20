package bridge.Enum;

public enum BridgeGameInfo {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q"),
    CORRECT(" O "),
    WRONG(" X "),
    BLANK("   ");
    private final String word;

    BridgeGameInfo(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
