package bridge.exception;

public class GameCommandException extends UserException {
    @Override
    public void checkException(String userInput) {
        isEmpty(userInput);
        isBlank(userInput);
        hasBlank(userInput);
    }
}
