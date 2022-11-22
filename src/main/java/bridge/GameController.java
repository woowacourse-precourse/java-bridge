package bridge;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private int bridgeSize;

    public GameController() {
        this.inputView = new InputView();
        this.outputView= new OutputView();
    }

    public void startGame() {
        bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        runGame(bridgeGame);
    }

    public void runGame(BridgeGame bridgeGame) {
        do {
            bridgeGame.addPlayerBridge(inputView.readMoving());
            outputView.printMap(bridgeGame.getPlayerBridge());
            bridgeGame.move();
        } while (bridgeGame.checkCanMove());
    }
}
