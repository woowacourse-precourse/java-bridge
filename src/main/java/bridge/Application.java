package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int size = inputView.readBridgeSize();
    }
}
