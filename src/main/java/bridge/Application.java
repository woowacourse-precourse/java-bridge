package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        try {
            int size = inputView.readBridgeSize();
            bridgeGame.run(size);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] " + error.getMessage());
        }
    }
}
