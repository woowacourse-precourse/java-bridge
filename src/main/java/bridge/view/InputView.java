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
        return Integer.parseInt(input);
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
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input.length() >= 9) {
            throw new IllegalArgumentException("[ERROR] 너무 긴 문자열은 입력할 수 없습니다.");
        }
    }
}
