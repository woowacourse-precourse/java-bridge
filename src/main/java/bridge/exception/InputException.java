package bridge.exception;

public class InputException {
    private static final String NOT_ONLY_ONE_SIZE = "[ERROR] 크기는 1이어야 합니다.";
    private static final String NOT_INPUT_FORMAT = "[ERROR] 입력 형식이 맞지 않습니다.";

    public static void printNotOnlyOneLengthException() {
        throw new IllegalArgumentException(NOT_ONLY_ONE_SIZE);
    }

    public static void printNotFormatException() {
        throw new NotInputFormatException(NOT_INPUT_FORMAT);
    }
}
