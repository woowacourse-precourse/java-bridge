package bridge.view;

import bridge.ValidationException;
import bridge.constants.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.constants.ErrorMessage.ERROR_INVALID_NUMBER;
import static bridge.constants.ErrorMessage.ERROR_MESSAGE;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    ValidationException validationException;

    public InputView(ValidationException validationException) {
        this.validationException = validationException;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        GuideOutputView.printBridgeLength();
        String bridgeLength = Console.readLine();
        validationException.checkValidNumber(bridgeLength);

        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        GuideOutputView.printUpAndDown();
        String movement = Console.readLine();

        return movement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        GuideOutputView.printRetry();
        String retry = Console.readLine();

        return retry;
    }
}
