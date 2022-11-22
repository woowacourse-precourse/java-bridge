package bridge.exception;

public class BridgeSizeException extends UserException {
    @Override
    public void checkException(String userInput) {
        isEmpty(userInput);
        isBlank(userInput);
        hasBlank(userInput);
        int bridgeSize = isNotInt(userInput);
        isOutOfRange(bridgeSize);
    }

    private int isNotInt(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionCode.IS_NOT_INT.getMessage());
        }
    }

    private void isOutOfRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ExceptionCode.OUT_OF_RANGE.getMessage());
        }
    }
}
