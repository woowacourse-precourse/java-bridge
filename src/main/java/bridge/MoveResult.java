package bridge;

public class MoveResult {
    private final String controlKey;
    private final boolean matchResult;

    public MoveResult(String controlKey, boolean matchResult) {
        this.controlKey = controlKey;
        this.matchResult = matchResult;
    }

    public String getControlKey() {
        return controlKey;
    }

    public boolean isMatchResult() {
        return matchResult;
    }
}
