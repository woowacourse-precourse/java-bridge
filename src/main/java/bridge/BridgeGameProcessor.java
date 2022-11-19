package bridge;

public class BridgeGameProcessor {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameProcessor(InputView inputView, OutputView outputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void play() {
        outputView.printStartMessage();

        while (oneStage(setBridgeGame(setBridge()))) {
        }

    }

    private boolean oneStage(BridgeGame bridgeGame) {
        if (isMoving(bridgeGame)) {
            return true;
        }

        if (isRetry(bridgeGame)) {
            return true;
        }

        return false;
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        return bridgeGame.retry(inputView.readGameCommand());
    }

    private boolean isMoving(BridgeGame bridgeGame) {
        outputView.printPositionSelectionMessage();
        return bridgeGame.move(inputView.readMoving());
    }

    private BridgeGame setBridgeGame(Bridge bridge) {
        return new BridgeGame(bridge);
    }

    private Bridge setBridge() {
        outputView.printBridgeSizeInputMessage();
        return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }
}
