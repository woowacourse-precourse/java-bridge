package bridge.ui;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final String ERROR_NOT_INTEGER = "[ERROR] 숫자가 아닙니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
    }

    private void validateIsInteger(String input) {
        if(!NUMBER_PATTERN.matcher(input).find()){
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
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
