package bridge.view;

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
        outputView.printMessageForBridgeSize();
        return inputView.readBridgeSize();
    }

    public String inputMoving() {
        outputView.printMessageForMoving();
        return inputView.readMoving();
    }

    public String inputGameCommand() {
        outputView.printMessageForGameCommand();
        return inputView.readGameCommand();
    }
}
