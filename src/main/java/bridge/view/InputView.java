package bridge.view;

import static bridge.Validator.validateIsDigit;
import static bridge.Validator.validateIsMovingValue;
import static bridge.Validator.validateIsRetryValue;
import static bridge.Validator.validateSizeRange;
import static bridge.view.OutputView.printExceptionMessage;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String length = Console.readLine();
        try {
            int size = validateIsDigit(length);
            validateSizeRange(size);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e.getMessage());
            readBridgeSize();
        }
        return Integer.parseInt(length);
    }

    public String readMoving() {
        String movingValue = Console.readLine();
        try {
            movingValue = validateIsMovingValue(movingValue);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e.getMessage());
            readMoving();
        }
        return movingValue;
    }

    public String readGameCommand() {
        String retryValue = Console.readLine();
        try {
            retryValue = validateIsRetryValue(retryValue);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e.getMessage());
            readGameCommand();
        }
        return retryValue;
    }
}
