package bridge;

public class Application {

    private static final BridgeGameController bridgeGameController = new BridgeGameController();

    public static void main(String[] args) {
        boolean retry = true;
        bridgeGameController.start();
        while (!bridgeGameController.play()) {
            retry = bridgeGameController.retry();
            if (!retry) {
                break;
            }
        }
        bridgeGameController.printResult(retry);
    }
}
