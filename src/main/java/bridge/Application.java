package bridge;

public class Application {
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        try {
            inputView.readBridgeSize();
            bridgeGame.move();
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
