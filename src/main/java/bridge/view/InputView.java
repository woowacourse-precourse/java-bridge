package bridge.view;

import bridge.constant.ExceptionConstants;
import bridge.constant.ViewConstants;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String input = Console.readLine();
        isNaturalNumber(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void isNaturalNumber(String input) {
        if (!Pattern.matches(ViewConstants.NATURAL_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_NATURAL_NUMBER.getMessage());
        }
    }
}
