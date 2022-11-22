package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static String PATTERN_SIZE = "^\\d*$";
    private final static String PATTERN_MOVE = "^[A-Z]$";
    private final static String PATTERN_RETRY = "^[A-Z]$";
    private final static String INVALID_SIZE_INPUT = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVALID_MOVE_INPUT = "이동할 칸은 U 또는 D 이어야합니다.";

    private static final String INVALID_RETRY_INPUT = "게임 재시도 여부는 R 또는 Q 이어야합니다.";



    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        if (!input.matches(PATTERN_SIZE)) {
            throw new IllegalArgumentException(INVALID_SIZE_INPUT);
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
