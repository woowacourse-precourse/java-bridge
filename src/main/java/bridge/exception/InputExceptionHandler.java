package bridge.exception;

import bridge.constant.GameConstant;

public class InputExceptionHandler {

    private static final String NOT_NUMERIC_ERROR = "[ERROR] 숫자로 입력을 해야합니다.";
    private static final String NOT_NUMBER_RANGE = "[ERROR] 다리 길이의 범위는 3 이상 20 이하입니다.";
    private static final String NOT_MOVING_COMMAND ="[ERROR] 이동할 칸의 입력은 U 또는 D으로 입력을 해야합니다.";
    private static final String NOT_RETRY_COMMAND = "[ERROR] 재시도할 경우 R, 종료할 경우 Q로 입력을 해야합니다.";

    public static int checkBridgeSize(String input) {
        int bridgeSize = isNumeric(input);
        isRange(bridgeSize);
        return bridgeSize;
    }

    private static int isNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException ErrorMessage) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }

    private static void isRange(int bridgeSize) {
        if (bridgeSize < GameConstant.MIN_BRIDGE_SIZE || bridgeSize > GameConstant.MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(NOT_NUMBER_RANGE);
        }
    }

    public static String checkMovingCommand(String input) {
        if(!input.equals("U")&&!input.equals("D")){
            throw new IllegalStateException(NOT_MOVING_COMMAND);
        }
        return input;
    }

    public static String checkRetryCommand(String input) {
        if (input.equals(GameConstant.RETRY)) {
            return input;
        }
        if (input.equals(GameConstant.QUIT)) {
            return input;
        }
        throw new IllegalArgumentException(NOT_RETRY_COMMAND);
    }
}