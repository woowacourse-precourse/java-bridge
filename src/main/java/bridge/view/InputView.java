package bridge.view;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        try {
            OutputView.requestBridgeSize();
            String input = Console.readLine();
            BridgeSizeValidator.validateBridgeSize(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readBridgeSize();
        }
    }

    public static String readMoving() {
        try {
            OutputView.requestMoving();
            String input = Console.readLine();
            MovingValidator.validateMoving(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readMoving();
        }
    }

    public static String readGameCommand() {
        try {
            OutputView.requestGameCommand();
            String input = Console.readLine();
            GameCommandValidator.validateGameCommand(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readGameCommand();
        }
    }
}
