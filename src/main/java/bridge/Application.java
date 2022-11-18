package bridge;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        bridgeGame = bridgeGameStart();
    }

    private static BridgeGame bridgeGameStart() {
        int bridgeSize = inputBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        return bridgeGame;
    }

    private static int inputBridgeSize() {
        outputView.printStart();
        return inputView.readBridgeSize();
    }
}
