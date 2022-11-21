package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();

        int size = bridgeGameController.start();
        boolean retry = true;
        while (retry) {
            boolean succeed = bridgeGameController.move(size);
            if (succeed) {
                bridgeGameController.printResult();
                break;
            }
            retry = bridgeGameController.retry();
            if (!retry) {
                bridgeGameController.printResult();
            }
        }
    }
}
