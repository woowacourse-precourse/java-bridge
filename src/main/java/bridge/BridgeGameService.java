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

    public GameStatus getGameStatus() {
        return bridgeGame.getGameStatus();
    }

    public GameStatus moveBridge() {
        for (int i = 0; i < bridgeGame.getAnswerBridgeSize(); i++) {
            bridgeGame.move(getMoving(), i);
            if (bridgeGame.getGameStatus() == GameStatus.LOSE) return bridgeGame.getGameStatus();
        }
        bridgeGame.setGameStatus(GameStatus.SUCCESS);
        return bridgeGame.getGameStatus();
    }

    public String getMoving() {
        return inputView.readMoving();
    }
}
