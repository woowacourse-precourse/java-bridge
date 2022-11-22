package bridge.message;

public final class ValidateMessage {

    private static final String MESSAGE_SUFFIX = "[ERROR] ";
    public static final String INVALID_INPUT = MESSAGE_SUFFIX + "올바르지 않은 입력입니다.";
    public static final String OUT_OF_RANGE = MESSAGE_SUFFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private ValidateMessage() {}

}
