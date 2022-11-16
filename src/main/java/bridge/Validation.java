package bridge;

public class Validation {
    private static final int LENGTH_FLOOR = 3;
    private static final int LENGTH_CEILING = 20;
    private static final String LENGTH_OUT_OF_BOUNDS = "다리의 길이는 3 이상 20 이하여야 합니다.";

    public static void validateLength(int length) throws IllegalArgumentException {
        if (length < LENGTH_FLOOR || length > LENGTH_CEILING) {
            throw new IllegalArgumentException(LENGTH_OUT_OF_BOUNDS);
        }
    }

}
