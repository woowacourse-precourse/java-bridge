package bridge;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.ready();

        boolean isRetry = true;
        while (isRetry) {
            boolean canContinue = bridgeGame.move();
            isRetry = bridgeGame.retry(canContinue);
        }
    }
}
