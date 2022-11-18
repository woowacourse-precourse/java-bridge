package bridge;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    public BridgeGameController() {
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
        bridgeGame = new BridgeGame(createBridge());
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
        String direction = inputView.readMoving();
        return bridgeGame.move(direction);
    }

    private int retry() {
        String gameCommand = inputView.readGameCommand();
        return bridgeGame.retry(gameCommand);
    }
}
