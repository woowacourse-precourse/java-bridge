package bridge.controller;

import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.OutputView.ErrorMessage;
import java.util.List;

public class GameController {
    public void gameStart() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.gameStart();
        int size = inputView.readBridgeSize();
        List<String> bridgeResult = bridgeMaker.makeBridge(size);
        System.out.println(bridgeResult);
    }

    public static boolean isValidBridgeNumber(String input) {
        String compare = input.replaceAll("[0-9]", "");
        try {
            if (compare.length() != 0) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER.printMessage());
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isValidBridgeRange(String input) {
        try {
            if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE.printMessage());
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
        return false;
    }
}
