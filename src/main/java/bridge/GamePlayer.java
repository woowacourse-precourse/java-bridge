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
        do {
            move();

            if (bridgeGame.isEnd()) {
                break;
            }

        } while (!movable().equals(GameKeySet.QUIT.getKeySet()));

        outputView.printResult(bridgeGame.getLog(), bridgeGame.isEnd(), retryCount);
    }

    private void move() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getLog());
    }

    private String movable() {
        String restartOrQuit = "";

        if (!bridgeGame.isMovable()) {
            restartOrQuit = inputView.readGameCommand();

            if (restartOrQuit.equals(GameKeySet.RESTART.getKeySet())) {
                retry();
            }
        }

        return restartOrQuit;
    }

    private void retry() {
        bridgeGame.retry();
        retryCount++;
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize();
    }
}
