package bridge;


public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMap bridgeMap;
    private BridgeGame bridgeGame;
    private int tryCount = 1;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMap = new BridgeMap();
    }

    public void makeBridgeGame() {
        int bridgeSize;
        outputView.printStartGame();
        outputView.printBridgeSizeQuestion();
        bridgeSize = inputView.readBridgeSize();

        this.bridgeGame = new BridgeGame(bridgeSize);
        outputView.printNewLine();
    }

    public void playBridgeGame() {
        for (int currentStep = 0; currentStep < bridgeGame.getBridgeSize(); currentStep++) {
            playRound();
            if (!bridgeGame.equalLastMove() && manageRetry()) {
                currentStep = -1;
                continue;
            }
            if (!bridgeGame.equalLastMove()) {
                break;
            }
        }
    }

    public void playRound() {
        String currentMoving;
        outputView.printMoveQuestion();
        currentMoving = inputView.readMoving();
        bridgeGame.move(currentMoving);
        String[] map = bridgeMap.makeMap(bridgeGame);
        outputView.printMap(map);
    }

    public boolean manageRetry() {
        outputView.printRetryQuestion();
        String retryString = inputView.readGameCommand();
        if (retryString.equals("R")) {
            bridgeGame.retry();
            tryCount++;
            return true;
        }
        return false;
    }

    public void sumUpBridgeGame() {
        String[] map = bridgeMap.makeMap(bridgeGame);
        boolean success = bridgeGame.equalLastMove();

        outputView.printResult(map, success, tryCount);
    }
}
