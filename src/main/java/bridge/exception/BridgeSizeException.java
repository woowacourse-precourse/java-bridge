package bridge.exception;

public class BridgeSizeException extends UserException {
    @Override
    public void checkException(String userInput) {
        isEmpty(userInput);
        isBlank(userInput);
        hasBlank(userInput);
    }
}
