package bridge;

public class BridgeView {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStartMessage() {
        outputView.gameStartMessage();
    }

    public int inputBridgeSizeMessage() {
        outputView.inputBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();
        outputView.printNewLine();
        return bridgeSize;
    }

    public String inputMoveCommandMessage() {
        outputView.inputMoveCommandMessage();
        return inputView.readMoving();
    }

    public String inputRetryCommandMessage() {
        outputView.inputRetryCommandMessage();
        return inputView.readGameCommand();
    }

    public void printMoveResult(BridgeResult bridgeResult) {
        outputView.printMap(bridgeResult);
    }

    public void printGameResult(BridgeResult bridgeResult, ResultSymbol resultSymbol, int gameTryCount) {
        outputView.printResult(bridgeResult, resultSymbol, gameTryCount);

    }
}
