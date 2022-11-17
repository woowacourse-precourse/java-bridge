package bridge.domain;

public class BridgeGameResult {

    private boolean isMatched;
    private String userMoving;

    public BridgeGameResult(boolean isMatched, String userMoving) {
        this.isMatched = isMatched;
        this.userMoving = userMoving;
    }

    public boolean getIsMatched() {
        return this.isMatched;
    }

    public String getUserMoving() {
        return this.userMoving;
    }
}
