package bridge.valid;

public class BridgeValidUtil {

    private static final String ERROR_OUT_RANGE_LENGTH = "[ERROR] 다리의 길이는 3이상 20이하 이어야 합니다.";
    private static final int MINIMUM_LENGTH = 3;
    private static final int MAXIMUM_LENGTH = 20;

    private BridgeValidUtil() {
    }

    public static void validateSize(int size) {
        if (isOutRange(size)) {
            throw new IllegalArgumentException(ERROR_OUT_RANGE_LENGTH);
        }
    }

    private static boolean isOutRange(int size) {
        return (size < MINIMUM_LENGTH) || (size > MAXIMUM_LENGTH);
    }
}
