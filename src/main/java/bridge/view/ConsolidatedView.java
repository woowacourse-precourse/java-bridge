package bridge.view;

import bridge.model.BridgeResult;

public class ConsolidatedView {
    private final InputView inputView;
    private final OutputView outputView;

    public ConsolidatedView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printStartMessage() {
        outputView.printStartMessage();
        System.out.println();
    }

    public int inputBridgeSize() {
        while (true) {
            try {
                outputView.printMessageForBridgeSize();
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public String inputMoving() {
        while (true) {
            try {
                outputView.printMessageForMoving();
                return inputView.readMoving();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public String inputGameCommand() {
        while (true) {
            try {
                outputView.printMessageForGameCommand();
                return inputView.readGameCommand();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public void printMoveMap(BridgeResult bridgeResult) {
        outputView.printMap(bridgeResult);
    }
}
