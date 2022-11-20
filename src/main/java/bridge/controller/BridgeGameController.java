package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static String bridgeLength;

    public static void execute() {
        OutputView.printGameStartMessage();
        bridgeLength = InputView.readBridgeSize();
        InputView.validateBridgeLength(bridgeLength);
        InputView.validateBridgeLengthRange(Integer.parseInt(bridgeLength));
    }
}
