package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static String bridgeLength;
    private static int bridgeLengthInt;

    public static void execute() {
        OutputView.printGameStartMessage();
        bridgeLength = InputView.readBridgeSize();
        InputView.validateBridgeLength(bridgeLength);
        bridgeLengthInt = Integer.parseInt(bridgeLength);
        InputView.validateBridgeLengthRange(bridgeLengthInt);
    }
}
