package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final BridgeController bridgeController = new BridgeController();

        bridgeController.executeBridgeGame();
        bridgeController.finishBridgeGame();
    }
}
