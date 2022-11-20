package bridge;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
    public void makeBridgeGame() {
        int bridgeSize;
        outputView.printStartGame();
        bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize);
    }


}
