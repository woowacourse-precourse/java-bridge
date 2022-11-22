package bridge.domain;

public class GameStatus {

    private static final String FAILURE = "실패";

    private int numberOfTry;
    private String gameResult;
    private Bridge topBridge;
    private Bridge bottomBridge;

    public GameStatus() {
        this.numberOfTry = 1;
        this.gameResult = FAILURE;
        this.topBridge = new Bridge();
        this.bottomBridge = new Bridge();
    }

    public void resetGameStatus() {
        this.numberOfTry += 1;
        this.topBridge = new Bridge();
        this.bottomBridge = new Bridge();
    }

    public int getTryCount() {
        return this.numberOfTry;
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
