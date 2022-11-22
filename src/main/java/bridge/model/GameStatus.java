package bridge.model;

public class GameStatus {

    private int bridgeSize;
    private int bridgeIndex;
    private int tryCount;
    private boolean gameResult;
    private static final int INIT_INDEX = 0;
    private static final int INIT_TRY_COUNT = 1;
    private static final boolean INIT_GAME_RESULT = true;

    public void initStatus(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        this.bridgeIndex = INIT_INDEX;
        this.tryCount = INIT_TRY_COUNT;
        this.gameResult = INIT_GAME_RESULT;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public void setBridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public int getBridgeIndex() {
        return bridgeIndex;
    }

    public void setBridgeIndex(int bridgeIndex) {
        this.bridgeIndex = bridgeIndex;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean isGameResult() {
        return gameResult;
    }

    public void setGameResult(boolean gameResult) {
        this.gameResult = gameResult;
    }
}
