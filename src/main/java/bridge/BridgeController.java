package bridge;


public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        this.bridgeGame = new BridgeGame(inputView.readBridgeSize());
        while (true) {
            boolean moveResult = bridgeGame.move(inputView.readMoving());
            boolean retryResult = true;
            outputView.printMap(bridgeGame.getBridgeUpMemory(), bridgeGame.getBridgeDownMemory());
            if (check(moveResult, retryResult)) break;
        }
        outputView.printResult(bridgeGame, bridgeGame.isEnd(), bridgeGame.getGameTryCount());
    }

    private boolean check(boolean moveResult, boolean retryResult) {
        if (!moveResult) {
            retryResult = bridgeGame.retry(inputView.readGameCommand());
        }
        if (retryResult == false) {
            return true;
        }
        if (bridgeGame.isEnd()) {
            return true;
        }
        return false;
    }
}
