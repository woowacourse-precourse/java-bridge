package bridge.view;

import bridge.constant.ErrorMessage;
import bridge.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ENTER_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        new OutputView().printMessage(ENTER_BRIDGE_LENGTH);
        String input = Console.readLine();

        InputValidator inputValidator = new InputValidator(input);
        if (inputValidator.isEmptyOrBlank() || !inputValidator.isNumber()
                || inputValidator.isOutOfInt()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.toString());
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
