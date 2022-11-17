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
        String input = receiveInput();
        validateMoveInput(input);
        return input;
    }

    private void validateMoveInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D만 입력해주세요.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = receiveInput();
        validateRestartOrQuitInput(input);
        return input;
    }

    private void validateRestartOrQuitInput(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력해주세요.");
        }
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
