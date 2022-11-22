package bridge.view;

import static bridge.Validator.validateIsDigit;
import static bridge.Validator.validateIsMovingValue;
import static bridge.Validator.validateIsRetryValue;
import static bridge.Validator.validateSizeRange;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String length = Console.readLine();
        try {
            int size = validateIsDigit(length);
            validateSizeRange(size);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            readBridgeSize();
        }
        return Integer.parseInt(length);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingValue = Console.readLine();
        try {
            movingValue = validateIsMovingValue(movingValue);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            readMoving();
        }
        return movingValue;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String retryValue = Console.readLine();
        try {
            retryValue = validateIsRetryValue(retryValue);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            readGameCommand();
        }
        return retryValue;
    }
}
