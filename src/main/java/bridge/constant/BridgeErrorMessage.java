package bridge.constant;

public class BridgeErrorMessage {
    public static final String BRIDGE_LENGTH_IS_NOT_DIGIT_ERROR_MESSAGE = "[ERROR] - 다리의 길이가 숫자가 아닙니다.";
    public static final String BRIDGE_LENGTH_IS_NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] - 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String DIRECTION_IS_NOT_VALID_ERROR_MESSAGE = "[ERROR] - U/D의 값으로만 입력해주세요";
    public static final String COMMAND_IS_NOT_VALID_ERROR_MESSAGE = "[ERROR] - R/Q의 값으로만 입력해주세요";

    private BridgeErrorMessage() {
    }
}
