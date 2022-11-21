package bridge;

public class BridgeGameService {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }
    public void intialSetting() {
        outputView.printGameStart();
    }
    public void makeBridge() {
        int bridgeSize = getBridgeLength();
        bridgeGame.makeAnswerBridge(bridgeSize);
    }

    public int getBridgeLength() {
        return inputView.readBridgeSize();
    }
}
