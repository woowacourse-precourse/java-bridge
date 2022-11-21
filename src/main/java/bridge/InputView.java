package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_LOWER_BOUND = 3;
    private static final int BRIDGE_UPPER_BOUND = 20;
    private static final String MOVE_UP = "U";
    private static final String MOVE_DOWN = "D";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String input = Console.readLine();
        if (StringUtil.isNumber(input)) {
            int size = Integer.parseInt(input);
            if (BRIDGE_LOWER_BOUND <= size && size <= BRIDGE_UPPER_BOUND) {
                return size;
            }
        }
        throw new IllegalArgumentException("다리 길이는 " + BRIDGE_LOWER_BOUND + "부터 " +
                BRIDGE_UPPER_BOUND + " 사이의 숫자여야 합니다.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        if (StringUtil.isString(input) && (input.equals(MOVE_UP) || input.equals(MOVE_DOWN))) {
            return input;
        }
        throw new IllegalArgumentException("다리를 건너기 위한 입력값은 " + MOVE_UP + "또는 " +
                MOVE_DOWN + " 문자여야 합니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
