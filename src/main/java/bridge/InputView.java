package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private static final int MOVING_COMMAND_LENGTH = 1;
    private static final String REGEX_FOR_BRIDEGE_SIZE = "^[0-9]*?";
    private static final String REGEX_FOR_MOVING = "^[UD]*?";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.matches(REGEX_FOR_BRIDEGE_SIZE)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력값에 숫자가 아닌 값이 포함되어 있습니다.");
        }
        if (!(MIN_LENGTH <= Integer.parseInt(bridgeSize) && Integer.parseInt(bridgeSize) <= MAX_LENGTH)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        validateMoving(moving);
        return moving;
    }

    private void validateMoving(String moving) {
        if (!moving.matches(REGEX_FOR_MOVING)) {
            throw new IllegalArgumentException("[ERROR] 입력값에 U 또는 D가 아닌 문자가 포함되어 있습니다.");
        }
        if (moving.length() != MOVING_COMMAND_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 입력한 문자의 길이가 1이 아닙니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

}
