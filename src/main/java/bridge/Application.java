package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.startBridgeGame();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
