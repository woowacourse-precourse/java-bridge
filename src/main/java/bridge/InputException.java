package bridge;

public class InputException {
    static final String NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    public static void checkIsBridgeSizeInteger(String bridgeSize) {
        if (!bridgeSize.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }
}