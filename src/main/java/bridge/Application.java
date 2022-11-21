package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new BridgeValidator());
        OutputView outputView = new OutputView();
        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView);
        bridgeGameController.playGame();
    }

}
