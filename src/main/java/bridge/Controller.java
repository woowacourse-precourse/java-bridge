package bridge;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public Controller(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void start() {
        outputView.printBridgeGameStart();
        int bridgeSize = inputView.readBridgeSize(outputView::printBridgeSizeInput);

        BridgeGame bridgeGame = new BridgeGame(new Bridge(bridgeMaker.makeBridge(bridgeSize)));

        boolean moveResult = true;
        while (moveResult) {
            String moveDirection = inputView.readMoving(outputView::printBridgeMoveDirectionInput);
            moveResult = bridgeGame.move(moveDirection);
            outputView.printMap(bridgeGame.getMoveHistory());
        }

        if (bridgeGame.isReachedEndOfBridge()) {
            outputView.printResult();
            return;
        }
    }
}
