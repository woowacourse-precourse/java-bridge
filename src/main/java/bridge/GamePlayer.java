package bridge;

public class GamePlayer {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private int retryCount;

    public GamePlayer() {
        this.inputView = new InputViewAdapter();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame(readBridgeSize());
        retryCount = 1;
    }

    public void run() {
        String restartOrQuit = "";
        boolean isNotMovalbe = false;

        do {
            bridgeGame.move(inputView.readMoving());

            outputView.printMap(bridgeGame.getLog());

            if (bridgeGame.isEnd()) {
                break;
            }

            if (!bridgeGame.isMovable()) {
                restartOrQuit = inputView.readGameCommand();

                if (restartOrQuit.equals(GameKeySet.RESTART.getKeySet())) {
                    bridgeGame.retry();
                    retryCount++;
                }
            }

        } while (restartOrQuit != GameKeySet.QUIT.getKeySet());

        outputView.printResult(bridgeGame.getLog(), true, retryCount);
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize();
    }
}
