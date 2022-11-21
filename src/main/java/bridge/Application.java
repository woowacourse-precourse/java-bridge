package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();

        int size = bridgeGameController.start();
        boolean retry = true;
        int cnt = 0;
        while (retry) {
            boolean succeed = bridgeGameController.move(size);
            cnt++;
            if (succeed) {
                bridgeGameController.printResult(true, cnt);
                break;
            }
            retry = bridgeGameController.retry();
            if (!retry) {
                bridgeGameController.printResult(false, cnt);
            }
        }
    }
}
