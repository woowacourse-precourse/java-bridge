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
        bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize);
        System.out.println("bridgeGame.getBridge() = " + bridgeGame.getBridge());
    }

    public void playBridgeGame() {
        for (int currentStep = 0; currentStep < bridgeGame.getBridgeSize(); currentStep++) {
            playRound();
            if (bridgeGame.checkLastMove() && manageRetry()) {
                currentStep = -1;
                continue;
            }
            if (bridgeGame.checkLastMove()) {
                break;
            }
        }
    }

    public void playRound() {
        outputView.printMoveQuestion();
        String currentMoving = inputView.readMoving();
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


}
