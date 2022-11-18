package bridge;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    public BridgeGameController() {
    }

    private void printError(String message) {
        System.out.println(message);
    }

    public void run() {
        outputView.printGameStart();
        init();
        int status = BridgeGame.KEEP_GOING;
        while (status == BridgeGame.KEEP_GOING) {
            status = play();
        }
        outputView.printResult(bridgeGame, status);
    }

    public void init() {
        while (true) {
            try {
                bridgeGame = new BridgeGame(createBridge());
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private Bridge createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = inputBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private int inputBridgeSize() {
        return inputView.readBridgeSize();
    }

    private int play() {
        int result = goForward();
        outputView.printMap(bridgeGame.getFootPrintsLog());
        if (result == BridgeGame.LOSE) {
            result = retry();
        }
        return result;
    }

    private int goForward() {
        while (true) {
            try {
                String direction = inputView.readMoving();
                return bridgeGame.move(direction);
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private int retry() {
        while (true) {
            try {
                String gameCommand = inputView.readGameCommand();
                return bridgeGame.retry(gameCommand);
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }
}
