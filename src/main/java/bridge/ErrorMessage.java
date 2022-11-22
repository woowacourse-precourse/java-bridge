package bridge;

import bridge.Input.InputValidation;

public class ErrorMessage {
    public static final String BASE_ERROR_MESSAGE = "[ERROR] ";
    public static final String BRIDGE_SIZE_ERROR_MESSAGE = BASE_ERROR_MESSAGE
            + "다리 길이는 " + InputValidation.MIN_BRIDGE_SIZE + "부터 "
            + InputValidation.MAX_BRIDGE_SIZE + " 사이의 숫자여야 합니다.";
    public static final String MOVE_COMMAND_ERROR_MESSAGE = BASE_ERROR_MESSAGE
            + "위: " + CommandConstant.UP_COMMAND + ", 아래: " + CommandConstant.DOWN_COMMAND + "를 입력해야 합니다.";
    public static final String RETRY_COMMAND_ERROR_MESSAGE = BASE_ERROR_MESSAGE
            + "재시도: " + CommandConstant.RETRY_COMMAND + ", 종료: " + CommandConstant.QUIT_COMMAND + "를 입력해야 합니다.";
}
