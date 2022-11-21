package bridge.Model;

public class BridgeGame {


    private static int bridgeSize;
    private static int gameCount = 0;

    public static void setBridgeSize(int bridgeSize) {
        BridgeGame.bridgeSize = bridgeSize;
    }

    public static int getBridgeSize() {
        return bridgeSize;
    }

    public static int getGameCount() {
        return gameCount;
    }

    public static void increaseGameCount() {
        gameCount++;
    }

    public void move() {
    }

    public void retry() {
    }
}