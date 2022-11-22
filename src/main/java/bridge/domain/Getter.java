package bridge.domain;

import bridge.error.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Getter {
    public static int getBridgeSize() {
        try {
            OutputView.printMessageForBridgeSize();
            return Validator.validateBridgeSize(InputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getBridgeSize();
        }
    }

    public static String getMoving() {
        try {
            OutputView.printMessageForMoving();
            return Validator.validateMoving(InputView.readMoving());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getMoving();
        }
    }

    public static String getGameCommand() {
        try {
            OutputView.printMessageForTermination();
            return Validator.validateGameCommand(InputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getGameCommand();
        }
    }
}
