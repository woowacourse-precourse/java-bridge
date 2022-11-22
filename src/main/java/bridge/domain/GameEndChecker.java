package bridge.domain;

public class GameEndChecker {
    private boolean isEnd;

    public GameEndChecker() {
        this.isEnd = false;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
    public boolean getEnd() {
        return this.isEnd;
    }
}
