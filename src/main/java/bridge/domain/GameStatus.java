package bridge.domain;

public class GameStatus {

    private static final String FAILURE = "실패";

    private int tryCount;
    private String gameResult;

    public Bridge topBridge;
    public Bridge bottomBridge;

    public GameStatus() {
        this.tryCount = 1;
        this.gameResult = FAILURE;
        this.topBridge = new Bridge();
        this.bottomBridge = new Bridge();
    }

    public void resetGameStatus() {
        this.tryCount += 1;
        this.topBridge = new Bridge();
        this.bottomBridge = new Bridge();
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void setGameResult(String s) {
        this.gameResult = s;
    }

    public String getGameResult() {
        return this.gameResult;
    }

    public void addStringToTopBridge(String s) {
        this.topBridge.addString(s);
    }

    public void addStringToBottomBridge(String s) {
        this.bottomBridge.addString(s);
    }

    public Bridge getTopBridge() {
        return topBridge;
    }

    public Bridge getBottomBridge() {
        return bottomBridge;
    }
}
