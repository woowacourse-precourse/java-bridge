package bridge.exception;

public class InputException {
    private static final String NOT_ONLY_NUMBER = "[ERROR] 숫자만 입력이 가능합니다.";
    private static final String NOT_MIN_SIZE = "[ERROR] 다리의 길이는 최소 3이상이어야 합니다.";
    private static final String NOT_MAX_SIZE = "[ERROR] 다리의 길이는 최대 20이하여야 합니다.";
    private static final String NOT_SPACE_FORMAT = "[ERROR] 입력 형식이 맞지 않습니다.";
    private static final String NOT_ONLY_ONE_LENGTH = "[ERROR] 한 글자로 입력해야 합니다.";

    public static void printNotOnlyNumberException() {
        throw new IllegalArgumentException(NOT_ONLY_NUMBER);
    }

    public static void printNotMinSizeException() {
        throw new IllegalArgumentException(NOT_MIN_SIZE);
    }

    public static void printNotMaxSizeException() {
        throw new IllegalArgumentException(NOT_MAX_SIZE);
    }

    public static void printNotOnlyOneLengthException() {
        throw new IllegalArgumentException(NOT_ONLY_ONE_LENGTH);
    }

    public static void printNotFormatException() {
        throw new IllegalArgumentException(NOT_SPACE_FORMAT);
    }
}
