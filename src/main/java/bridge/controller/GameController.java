package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.Comparison;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.OutputView.ErrorMessage;
import java.util.List;

public class GameController {
    public static int gameCount = 1;
    public static boolean failOrSuccess = false;

    public void gameStart() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.gameStart();
        int size = InputView.readBridgeSize();
        List<String> bridgeResult = bridgeMaker.makeBridge(size);
        System.out.println(bridgeResult);
        BridgeGame.move(inputView, outputView, bridgeResult);
        outputView.printResult();
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

    public static boolean isValidBridgeAction(String input) {
        try {
            if (!(input.equals("U") || input.equals("D"))) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_UP_DOWN.printMessage());
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isValidBridgeRestart(String input) {
        try {
            if (!(input.equals("R") || input.equals("Q"))) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_RESTART_QUIT.printMessage());
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
        return false;
    }
}
