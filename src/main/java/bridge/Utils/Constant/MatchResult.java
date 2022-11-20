package bridge.Utils.Constant;

public enum MatchResult {

    CORRECT("O"),
    INCORRECT("X"),
    BLANK(" ");

    private final String result;

    MatchResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }
}
