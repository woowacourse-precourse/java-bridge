package bridge;

public class BridgeGameCount {

    public static final int COUNT_PLUS_CRITERIA = 1;

    private final int gameCount;

    public BridgeGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public BridgeGameCount addCount() {
        return new BridgeGameCount(this.gameCount + COUNT_PLUS_CRITERIA);
    }

    public int getGameCount() {
        return this.gameCount;
    }

}
