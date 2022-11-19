package bridge;

public class GamePlayer {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private int retryCount;

    public GamePlayer() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame(readBridgeSize());
        retryCount = 0;
    }

    public void run() {
        String restartOrQuit = "";
        String upOrDown;
        boolean isNotMovalbe = false;
        BridgeLog log = null;

        do {
            upOrDown = inputView.readMoving();
            bridgeGame.move(upOrDown);

            if (bridgeGame.isEnd()) {
                break;
            }
            log = bridgeGame.getLog();
            outputView.printMap(log);

            if (!bridgeGame.isMovable()) {
                restartOrQuit = inputView.readGameCommand();

                if (restartOrQuit.equals(GameKeySet.RESTART.getKeySet())) {
                    bridgeGame.retry();
                    retryCount++;
                }
            }

        } while (restartOrQuit != GameKeySet.QUIT.getKeySet());
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize();
    }
}
