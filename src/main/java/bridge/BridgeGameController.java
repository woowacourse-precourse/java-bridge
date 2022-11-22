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
            bridgeGame.newGameSimulation();
            start();
        } while (retry());
        outputView.printResult(gameResult.getGameResult(), gameResult.getCount());
    }

    private boolean retry() {
        if (checkEnd()) {
            return false;
        }
        try {
            outputView.printRetry();
            return bridgeGame.retry(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            retry();
        }
        return true;
    }

    public void init() {
        try {
            outputView.printSize();
            int bridgeSize = inputView.readBridgeSize();
            bridgeGame.generateBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            init();
        }
    }

    private void start() {
        try {
            move();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            start();
        }
    }

    private boolean checkEnd() {
        gameResult.save(bridgeGame.getGameSimulation());
        if (bridgeGame.success()) return true;
        return false;
    }

    private void move() {
        String compare;
        do {
            outputView.printMoveInput();
            compare = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getGameSimulation());
        } while (bridgeGame.fail(compare));
    }
}
