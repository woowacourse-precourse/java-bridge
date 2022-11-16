package bridge.exception;

public class InputException {
    private static final String NOT_ONLY_NUMBER = "[ERROR] 숫자만 입력이 가능합니다.";

    public static void printNotOnlyNumberException() {
        throw new IllegalArgumentException(NOT_ONLY_NUMBER);
    }
}
