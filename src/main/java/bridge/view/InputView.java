package bridge.view;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        OutputView.requestBridgeSize();
        String input = Console.readLine();
        BridgeSizeValidator.validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    public static String readMoving() {
        OutputView.requestMoving();
        String input = Console.readLine();
        MovingValidator.validateMoving(input);
        return input;
    }

    public static String readGameCommand() {
        OutputView.requestGameCommand();
        String input = Console.readLine();
        GameCommandValidator.validateGameCommand(input);
        return input;
    }
}
