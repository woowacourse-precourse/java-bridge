package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주새요.";
    private static final String MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_RETRY_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세여. (재시도: R, 종료: Q)";
    private static final int BRIDGE_SIZE_RANGE1 = 3;
    private static final int BRIDGE_SIZE_RANGE2 = 20;
    private static final String USER_MOVE_UP = "U";
    private static final String USER_MOVE_DOWN = "D";
    private static final String USER_RETRY = "R";
    private static final String USER_OVER = "Q";

    private Validation validation = new Validation();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
        int input = Integer.valueOf(Console.readLine());
        if (!(validation.SizeRangeValidate(input, BRIDGE_SIZE_RANGE1, BRIDGE_SIZE_RANGE2))) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_INPUT_MESSAGE);
        String input = Console.readLine();
        if (!validation.CharValidate(input, USER_MOVE_UP, USER_MOVE_DOWN)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n" + GAME_RETRY_INPUT_MESSAGE);
        String input = Console.readLine();
        if (!validation.CharValidate(input, USER_RETRY, USER_OVER)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
