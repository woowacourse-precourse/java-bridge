package bridge.service.exception;

public class RetryException {

    private static final String START_ERROR_MESSAGE = "[ERROR] ";
    private static final String NOT_CORRECT_FORMAT_ERROR_MESSAGE = "R과 Q중 하나만 선택할 수 있습니다.";
    private static final String COLLECT_FORMAT = "RQ";

    public static void checkRetryIsCorrectFormat(String command) {
        if (!COLLECT_FORMAT.contains(command)) {
            throw new IllegalArgumentException(START_ERROR_MESSAGE + NOT_CORRECT_FORMAT_ERROR_MESSAGE);
        }
    }
}
