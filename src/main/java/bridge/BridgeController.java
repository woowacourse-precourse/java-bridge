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

    public boolean proceedGame() {
        for (int index = 0; index < bridgeGame.getBridgeSize(); index++) {
            String moving = inputView.readMoving();
            if (bridgeGame.move(index, moving)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
