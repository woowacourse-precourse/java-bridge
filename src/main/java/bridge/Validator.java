package bridge;

public class Validator {
    public static final int MINIMUM_SIZE = 3;
    public static final int MAXIMUM_SIZE = 20;

    public static void validateSizeRange(int size) {
        if (size < MINIMUM_SIZE || size > MAXIMUM_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 이상이거나 20 이하여야 합니다.");
        }
    }
}
