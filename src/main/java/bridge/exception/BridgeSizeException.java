package bridge.exception;

public class BridgeSizeException extends UserException {
    @Override
    public void checkException(String userInput) {
        isEmpty(userInput);
        isBlank(userInput);
        hasBlank(userInput);
        int bridgeSize = isNotInt(userInput);
    }

    private int isNotInt(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionCode.IS_NOT_INT.getMessage());
        }
    }
}
