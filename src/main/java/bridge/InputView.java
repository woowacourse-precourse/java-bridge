package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String RETRY = "R";
    public static final String QUIT = "Q";
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String CHOICE_UP_OR_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String ENTER_NUMBER = "숫자를 입력해주세요.";
    public static final String BRIDGE_SIZE_BETWEEN_3_AND_20 = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String ENTER_U_OR_D = "위(U) 또는 아래(D)만 선택할 수 있습니다.";
    public static final String ENTER_R_OR_Q = "재시작(R) 또는 종료(Q)만 선택할 수 있습니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        int bridgeSize = validateBridgeSize(parseInt(Console.readLine()));
        System.out.println();
        return bridgeSize;
    }

    private int parseInt(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ENTER_NUMBER);
        }
        return result;
    }

    private int validateBridgeSize(int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_SIZE || bridgeSize > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_BETWEEN_3_AND_20);
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(CHOICE_UP_OR_DOWN);
        return validateMoving(Console.readLine());
    }

    private String validateMoving(String moving) {
        if (!moving.equals(UP) && !moving.equals(DOWN)) {
            throw new IllegalArgumentException(ENTER_U_OR_D);
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY_OR_QUIT);
        return validateGameCommand(Console.readLine());
    }

    private String validateGameCommand(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(ENTER_R_OR_Q);
        }
        return input;
    }
}
