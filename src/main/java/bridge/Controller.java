package bridge;

public class Controller {

    public static final String RETRY_GAME_COMMAND = "R";
    public static final String QUIT_GAME_COMMAND = "Q";

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
        BridgeGame bridgeGame = createBridgeGame(readBridgeSize());

        do {
            moveToEndOfBridge(bridgeGame);
        } while (!bridgeGame.isWin() && doRetryOrNot(readGameCommand(), bridgeGame));

        outputView.printResult(bridgeGame);
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize(outputView::printBridgeSizeInput);
    }

    private BridgeGame createBridgeGame(int bridgeSize) {
        return new BridgeGame(
                new Bridge(this.bridgeMaker.makeBridge(bridgeSize))
        );
    }

    private String readGameCommand() {
        return inputView.readGameCommand(outputView::printGameCommandInput);
    }

    private void moveToEndOfBridge(BridgeGame bridgeGame) {
        boolean moveResult = true;
        while (!bridgeGame.isWin() && moveResult) {
            String moveDirection = inputView.readMoving(outputView::printBridgeMoveDirectionInput);
            moveResult = bridgeGame.move(moveDirection);
            outputView.printMap(bridgeGame.getMoveHistory());
        }
    }

    private boolean doRetryOrNot(String gameCommand, BridgeGame bridgeGame) {
        if (RETRY_GAME_COMMAND.equals(gameCommand)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
