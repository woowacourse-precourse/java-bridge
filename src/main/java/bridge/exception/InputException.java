package bridge.exception;

public class InputException {
    private static final String NOT_ONLY_NUMBER = "[ERROR] 숫자만 입력이 가능합니다.";
    private static final String NOT_MIN_SIZE = "[ERROR] 다리의 길이는 최소 3이상이어야 합니다.";
    private static final String NOT_MAX_SIZE = "[ERROR] 다리의 길이는 최대 20미만이어야 합니다.";
    private static final String NOT_ONLY_ONE_SIZE = "[ERROR] 크기는 1이어야 합니다.";

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
        throw new IllegalArgumentException(NOT_ONLY_ONE_SIZE);
    }

    public static void printNotFormatException() {
        throw new NotInputFormatException();
    }
}
