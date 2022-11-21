package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();

        int size = bridgeGameController.start();
        boolean succeed = bridgeGameController.move(size);
    }
}
