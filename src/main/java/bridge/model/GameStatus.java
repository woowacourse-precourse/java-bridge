package bridge.model;

public class GameStatus {

    private int bridgeSize;
    private int bridgeIndex;
    private int tryCount;
    private boolean gameResult;

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
