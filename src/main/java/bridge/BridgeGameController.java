package bridge;

public class BridgeGameController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static GameResult gameResult = new GameResult();

    public void run() {
        outputView.printStart();
        init();
        do {
            gameResult.setCount(gameResult.getCount() + 1);
            bridgeGame.newGame();
            start();
        } while (retry());
    }

    private boolean retry() {
        if (checkEnd()) return false;
        try {
            outputView.printRetry();
            return bridgeGame.retry(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            outputView.printError();
            retry();
        }
        return true;
    }

    public void init() {
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.createBridge(bridgeSize);
        while (checkEnd()) ;
    }

    private static void start() {
        try {
            move();
        } catch (IllegalArgumentException e) {
            outputView.printError();
            start();

        }
    }

    private boolean checkEnd() {
        gameResult.save(bridgeGame.getGame());
        if (bridgeGame.success()) {
            outputView.printResult(gameResult.getResult(), gameResult.getCount());
            return true;
        }
        return false;
    }

    private static void move() {
        String match;
        do {
            outputView.printMove();
            match = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getGame());
        } while (bridgeGame.fail(match));

    }
}
