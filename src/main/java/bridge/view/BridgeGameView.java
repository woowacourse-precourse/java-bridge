package bridge.view;

import bridge.model.Crossing;

public class BridgeGameView {

    private final InputView inputView;
    private final OutputView outputView;
    private final PrintFormatter printFormatter;

    public BridgeGameView(InputView inputView, OutputView outputView, PrintFormatter printFormatter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.printFormatter = printFormatter;
    }

    public int requestNewBridgeSize() {
        outputView.printStartPrompt();

        return inputView.readBridgeSize();
    }

    public String requestDirection() {
        outputView.printInputDirectionPrompt();

        return inputView.readMoving();
    }

    public void printCurrentMap(Crossing crossing) {
        String format = printFormatter.convertToFormat(crossing);

        outputView.printMap(format);
    }
}
