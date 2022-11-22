package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_OUT_OF_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INPUT_NOT_DIGIT = "[ERROR] 입력 값은 숫자가 아닙니다.";
    public static final String NOT_CORRECT_UP_OR_DOWN_INPUT = "[ERROR] 이동할 칸 입력은 위: U, 아래: D 중 하나를 입력해야 합니다.";
    public static final String NOT_CORRECT_RETRY_OR_QUIT_INPUT = "[ERROR] 재시도: R, 종료: Q 중 하나를 입력해야 합니다.";
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String SELECT_GAME_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final int CLIPPED_WORD_LENGTH = 1;
    private static final String U_INPUT_CLIPPED_WORD = "U";
    private static final String D_INPUT_CLIPPED_WORD = "D";
    private static final String R_INPUT_CLIPPED_WORD = "R";
    private static final String Q_INPUT_CLIPPED_WORD = "Q";
    private static final int BRIDGE_SIZE_MIN_VALUE = 3;
    private static final int BRIDGE_SIZE_MAX_VALUE = 20;
    private static final String NEW_LINE = "\n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GAME_START + NEW_LINE);
        System.out.println(INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        validateIsDigit(bridgeSize);
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING);
        String input = Console.readLine();
        validateIsUpOrDown(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(SELECT_GAME_RETRY);
        String input = Console.readLine();
        validateIsRetryOrQuit(input);
        return input;
    }

    private void validateBridgeSize(String bridgeSize) {
        if (isNotInBridgeSizeRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE);
        }
    }

    private boolean isNotInBridgeSizeRange(int bridgeSize) {
        return bridgeSize < BRIDGE_SIZE_MIN_VALUE || bridgeSize > BRIDGE_SIZE_MAX_VALUE;
    }

    private void validateIsDigit(String input) {
        char[] inputs = input.toCharArray();
        for (char character : inputs) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException(INPUT_NOT_DIGIT);
            }
        }
    }

    private void validateIsUpOrDown(String input) {
        if (!isUp(input) && !isDown(input)) {
            throw new IllegalArgumentException(NOT_CORRECT_UP_OR_DOWN_INPUT);
        }
    }

    private boolean isUp(String input) {
        return input.length() == CLIPPED_WORD_LENGTH && input.equals(U_INPUT_CLIPPED_WORD);
    }

    private boolean isDown(String input) {
        return input.length() == CLIPPED_WORD_LENGTH && input.equals(D_INPUT_CLIPPED_WORD);
    }

    private void validateIsRetryOrQuit(String input) {
        if (!isRetry(input) && !isQuit(input)) {
            throw new IllegalArgumentException(NOT_CORRECT_RETRY_OR_QUIT_INPUT);
        }
    }

    private boolean isRetry(String input) {
        return input.length() == CLIPPED_WORD_LENGTH && input.equals(R_INPUT_CLIPPED_WORD);
    }

    private boolean isQuit(String input) {
        return input.length() == CLIPPED_WORD_LENGTH && input.equals(Q_INPUT_CLIPPED_WORD);
    }

}
