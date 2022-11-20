package bridge.validator;

public class RetryCommandValidator {

    private static final String RETRY_MENU_RETRY = "R";
    private static final String RETRY_MENU_QUIT = "Q";
    private static final int RETRY_MENU_LENGTH = 1;

    private static final String ERROR_RETRY_MENU = "[ERROR] R이나 Q를 입력해야 합니다.";
    private static final String ERROR_RETRY_COMMAND_LENGTH = "[ERROR] 하나의 문자를 입력해야 합니다.";

    public void validate(String retryCommand) {
        validateRetryMenu(retryCommand);
        validateMovingCommandLength(retryCommand);
    }

    private void validateRetryMenu(String retryCommand) {
        if (!retryCommand.equals(RETRY_MENU_RETRY) && !retryCommand.equals(RETRY_MENU_QUIT)) {
            throw new IllegalArgumentException(ERROR_RETRY_MENU);
        }
    }

    private void validateMovingCommandLength(String retryCommand) {
        if (retryCommand.length() != RETRY_MENU_LENGTH) {
            throw new IllegalArgumentException(ERROR_RETRY_COMMAND_LENGTH);
        }
    }
}
