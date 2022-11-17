package bridge;

public class BridgeController {
    private OutputView outputView;
    private InputView inputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void setGame() {
        outputView.printStartMessage();

        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public void proceedGame() {
        String moving = inputView.readMoving();
    }
}
