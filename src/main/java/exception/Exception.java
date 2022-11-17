package exception;

public class Exception {

    private static final String ERROR = "[ERROR]";

    public static boolean bridgeLengthValidation(int bridgeSize) {
        if (!(3 <= bridgeSize && bridgeSize <= 20)) {
            throw new IllegalArgumentException(ERROR + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        return true;
    }
}
