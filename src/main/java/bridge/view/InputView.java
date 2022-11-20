package bridge.view;

import bridge.validator.BridgeLengthValidator;
import bridge.validator.RetryInputValidator;
import bridge.validator.SpaceToMoveValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        BridgeLengthValidator.validateNaturalNumber(input);
        BridgeLengthValidator.validateRange(input);

        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = Console.readLine();
        SpaceToMoveValidator.validateSpaceToMove(input);
        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        RetryInputValidator.validateRetryInput(input);
        return input;
    }
}
