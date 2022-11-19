package bridge;

public class BridgeGameProcessor {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameProcessor(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void play() {
        outputView.printStartMessage();
        BridgeGame bridgeGame = setBridgeGame(setBridge());
        while (oneStage(bridgeGame) && !bridgeGame.isFinished()) {
        }

    }

    private boolean oneStage(BridgeGame bridgeGame) {
        boolean moving = isMoving(bridgeGame);
        outputView.printResult(bridgeGame.getMovementsInUpBridge(), bridgeGame.getMovementsInDownBridge());
        if (moving) {
            return true;
        }

        return isRetry(bridgeGame);
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        outputView.printGameCommandSelectionMessage();
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
