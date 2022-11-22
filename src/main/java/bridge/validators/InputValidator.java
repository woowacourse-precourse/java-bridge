package bridge.validators;

import bridge.messages.ErrorMessage;

import java.util.Arrays;

public class InputValidator {

    private static final boolean NUMERIC = true;
    private static final boolean NOT_NUMERIC = false;
    private static final boolean OUT_OF_RANGE = true;
    private static final boolean IN_RANGE = false;

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private static final String[] RETRY = { "R", "r" };
    private static final String[] QUIT = { "Q", "q" };
    private static final String[] UP = { "U", "u" };
    private static final String[] DOWN = { "D", "d" };

    /**
     * 다리 길이에 대한 입력을 받은 후, 입력이 유효한 값인지 검사한다.
     * <p>
     * 유효하지 않으면 IllegalArgumentException 을 발생시킨다.
     * @param bridgeSizeInput
     */
    public static void validateBridgeSize(String bridgeSizeInput) {
        if (!isNumeric(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (isOutOfRange(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    /**
     * 입력 값이 올바른 숫자값 인지 여부를 확인한다.
     * @param input
     * @return 숫자이면 true, 문자가 섞여있다면 false
     */
    static boolean isNumeric(String input) {
        if (input.charAt(0) == '0') {
            return NOT_NUMERIC;
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            return NOT_NUMERIC;
        }
        return NUMERIC;
    }

    /**
     * 입력받은 다리 길이가 범위 내에 있는지 확인한다.
     * @param bridgeSize
     * @return 범위 내에 있으면 true, 없으면 false
     */
    static boolean isOutOfRange(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE || bridgeSize > MAXIMUM_BRIDGE_SIZE) {
            return OUT_OF_RANGE;
        }
        return IN_RANGE;
    }

    /**
     * 진행 방향에 대한 입력을 받은 후, 입력이 유효한지 검색한다.
     * <p>
     * (U, u, D, d) 중에 값이 없다면 IllegalArgumentException 을 발생시킨다.
     * @param moveDirectionInput
     */
    public static void validateMoveDirection(String moveDirectionInput) {
        if (!(Arrays.asList(UP).contains(moveDirectionInput)
                || Arrays.asList(DOWN).contains(moveDirectionInput))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_DIRECTION.getMessage());
        }
    }

    /**
     * 재시도 여부를 입력을 받은 후, 입력이 유효한지 검색한다.
     * <p>
     * (R, r, Q, q) 중에 값이 없다면 IllegalArgumentException 을 발생시킨다.
     * @param retryInput
     */
    public static void validateRetryInput(String retryInput) {
        if (!(Arrays.asList(RETRY).contains(retryInput)
                || Arrays.asList(QUIT).contains(retryInput))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_INPUT.getMessage());
        }
    }
}
