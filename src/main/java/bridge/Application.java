package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeGameController bridgeGameController = new BridgeGameController();
        try {
            int size = inputView.readBridgeSize();
            bridgeGameController.run(size);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] " + error.getMessage());
        }
    }
}
