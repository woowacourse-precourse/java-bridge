package bridge.controller;

import bridge.domain.BridgeStatus;
import bridge.view.InputView;
import bridge.view.OutputView;


public class ConsoleController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int bridgeSizeConsole() {
        outputView.printStart();
        outputView.printLengthInput();
        return inputView.readBridgeSize();
    }

    public String moveConsole() {
        outputView.printLine();
        outputView.printMoveInput();
        return inputView.readMoving();
    }

    public void statusConsole(BridgeStatus bridgeStatus) {
        outputView.printMap(bridgeStatus);
    }

    public String commandConsole() {
        outputView.printRetry();
        return inputView.readGameCommand();
    }

    public void endConsole(
            final BridgeStatus bridgeStatus,
            final int tryCount
    ) {
        outputView.printResult();
        outputView.printMap(bridgeStatus);
        outputView.printComplete(bridgeStatus.getSuccess());
        outputView.printTryCount(tryCount);
    }
}