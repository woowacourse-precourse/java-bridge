package bridge;

public class BridgeGameController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        init();
        do {
            bridgeGame.newGame();
            start();
        } while (retry());
    }

    private boolean retry() {
        if (checkEnd()) return false;
        return bridgeGame.retry(inputView.readGameCommand());
    }

    public void init() {
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.createBridge(bridgeSize);
        while (checkEnd());
    }

    private static void start() {
        move();
    }

    private boolean checkEnd() {
        if (bridgeGame.success()) {
            return true;
        }
        return false;
    }

    private static void move() {
        String match = bridgeGame.move(inputView.readMoving());

    }
}
