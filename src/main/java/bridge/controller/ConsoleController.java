package bridge.controller;

import bridge.domain.BridgeStatus;
import bridge.view.InputView;
import bridge.view.OutputView;


public class ConsoleController {
    private final static InputView INPUT_VIEW = new InputView();
    private final static OutputView OUTPUT_VIEW = new OutputView();


    public int bridgeSizeConsole() {
        OUTPUT_VIEW.printStart();
        OUTPUT_VIEW.printLengthInput();
        return INPUT_VIEW.readBridgeSize();
    }

    public String moveConsole() {
        OUTPUT_VIEW.printLine();
        OUTPUT_VIEW.printMoveInput();
        return INPUT_VIEW.readMoving();
    }

    public void statusConsole(BridgeStatus bridgeStatus) {
        OUTPUT_VIEW.printMap(bridgeStatus);
    }

    public String commandConsole() {
        OUTPUT_VIEW.printRetry();
        return INPUT_VIEW.readGameCommand();
    }

    public void endConsole(
            final BridgeStatus bridgeStatus,
            final int tryCount
    ) {
        OUTPUT_VIEW.printResult();
        OUTPUT_VIEW.printMap(bridgeStatus);
        OUTPUT_VIEW.printComplete(bridgeStatus.getSuccess());
        OUTPUT_VIEW.printTryCount(tryCount);
    }
}