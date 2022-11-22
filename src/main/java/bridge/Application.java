package bridge;

public class Application {

    private static final BridgeGameController bridgeGameController = new BridgeGameController();
    private static boolean retry = true;
    private static int cnt = 1;

    public static void main(String[] args) {
        bridgeGameController.start();
        while (!bridgeGameController.play()) {
            cnt++;
            retry = bridgeGameController.retry();
            if (!retry) {
                break;
            }
        }
        bridgeGameController.printResult(retry, cnt);
    }
}
