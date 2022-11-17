package bridge;

public class Validator {
    public static void validateInputSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INPUT_RANGE.getErrorMessage());
        }
    }
}
