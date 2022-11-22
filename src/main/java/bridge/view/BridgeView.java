package bridge.view;

import bridge.domain.BridgeResult;
import bridge.domain.GameSymbol;
import bridge.domain.ResultSymbol;

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
        while (true) {
            try {
                outputView.inputBridgeSizeMessage();
                int bridgeSize = inputView.readBridgeSize();
                outputView.printNewLine();
                return bridgeSize;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public String inputMoveCommandMessage() {
        while (true) {
            try {
                outputView.inputMoveCommandMessage();
                return inputView.readMoving();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public GameSymbol inputRetryCommandMessage() {
        while (true) {
            try {
                outputView.inputRetryCommandMessage();
                return inputView.readGameCommand();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public void printMoveResult(BridgeResult bridgeResult) {
        outputView.printMap(bridgeResult);
    }

    public void printGameResult(BridgeResult bridgeResult, ResultSymbol resultSymbol, int gameTryCount) {
        outputView.printResult(bridgeResult, resultSymbol, gameTryCount);

    }
}
