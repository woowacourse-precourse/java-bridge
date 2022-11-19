package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class InputController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static int setBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return setBridgeSize();
        }
    }

    public static String setUserSelection() {
        try {
            outputView.printMoveInput();
            return inputView.readMoving();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return setUserSelection();
        }
    }
}
