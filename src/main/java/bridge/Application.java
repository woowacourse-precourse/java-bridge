package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(new InputView(), new OutputView());
        bridgeGameController.start();
    }
}
