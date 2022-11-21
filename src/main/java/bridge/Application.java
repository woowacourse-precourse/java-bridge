package bridge;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeController bridgeController = new BridgeController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        bridgeController.startBridgeGame();

        bridgeController.moveBridge();
    }
}
