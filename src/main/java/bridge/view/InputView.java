package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final Pattern BRIDGE_SIZE_PATTERN = Pattern.compile("\\d*");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = receiveInput();
        validateNumber(input);
        int length = Integer.parseInt(input);
        validateLength(length);
        return length;
    }

    private void validateLength(int length) {
        if (length < 3 || length > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateNumber(String input) {
        if (!BRIDGE_SIZE_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
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

    private String receiveInput() {
        return Console.readLine();
    }
}
