package bridge;

public class Application {
    private static final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        bridgeGame.init();
        int tryCount = 0;
        do {
            bridgeGame.move();
            tryCount++;
            if (bridgeGame.getSuccess()) {
                break;
            }
        } while (bridgeGame.retry());
        bridgeGame.quit(tryCount);
    }
}
