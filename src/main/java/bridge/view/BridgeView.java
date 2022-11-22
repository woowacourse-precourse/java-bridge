package bridge.view;

import java.util.List;

public class BridgeView {
    final private InputView inputView;
    final private OutputView outputView;

    public BridgeView() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int readBridgeSize() {
        return inputView.readBridgeSize();
    }

    public String readMoving() {
        return inputView.readMoving();
    }

    public String readGameCommand() {
        return inputView.readGameCommand();
    }

    public void printStartMassage() {
        outputView.printStartMassage();
    }

    public void printBridgeSizeMessage() {
        outputView.printInputMessageBridgeSize();
    }

    public void printMoveCommandMessage() {
        outputView.printInputMessageMoving();
    }

    public void printRestartMassage() {
        outputView.printInputMessageGameCommand();
    }

    public void printEndMassage() {
        outputView.printMessageResult();
    }

    public void printMap(List<List<String>> map) {
        outputView.printMap(map);
    }

    public void printGameResult(final List<List<String>> map, final boolean result, final int tryCounty) {
        outputView.printResult(map, result, tryCounty);
    }
}
