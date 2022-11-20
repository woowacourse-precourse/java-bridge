package bridge.model;

public class BridgeGameResult {
    private String cleared;
    private int tried;

    public BridgeGameResult(String cleared, int tried) {
        this.cleared = cleared;
        this.tried = tried;
    }

    public String getCleared() {
        return cleared;
    }

    public int getTried() {
        return tried;
    }
}
