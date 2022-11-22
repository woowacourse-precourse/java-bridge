package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Message.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static String PATTERN_SIZE = "^\\d*$";
    private final static String PATTERN_MOVE = "^[A-Z]$";
    private final static String PATTERN_RETRY = "^[A-Z]$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        if (!input.matches(PATTERN_SIZE)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
        }

        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        if (!input.matches(PATTERN_MOVE)) {
            throw new IllegalArgumentException(INVALID_MOVE_INPUT);
        }

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        if (!input.matches(PATTERN_RETRY)) {
            throw new IllegalArgumentException(INVALID_RETRY_INPUT);
        }

        return input;
    }
}
