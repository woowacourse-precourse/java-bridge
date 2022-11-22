package bridge;

public class Application {

    private static final BridgeGameController bridgeGameController = new BridgeGameController();
    private static boolean retry = true;

    public static void main(String[] args) {
        int size = bridgeGameController.start();
        while (!bridgeGameController.play(size)) {
            retry = bridgeGameController.retry();
            if (!retry) {
                break;
            }
        }
        bridgeGameController.printResult(retry);
    }
}
