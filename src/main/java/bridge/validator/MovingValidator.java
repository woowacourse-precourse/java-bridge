package bridge.validator;

public class MovingValidator {
    private static final String MOVING_MENU_UP = "U";
    private static final String MOVING_MENU_DOWN = "D";
    private static final int MOVING_MENU_LENGTH = 1;

    private static final String ERROR_MOVING_MENU = "[ERROR] U나 D 를 입력해야 합니다.";
    private static final String ERROR_MOVING_COMMAND_LENGTH = "[ERROR] 하나의 문자를 입력해야 합니다.";

    public void validate(String movingCommand) {
        validateMovingMenu(movingCommand);
        validateMovingCommandLength(movingCommand);
    }

    private void validateMovingMenu(String movingCommand) {
        if (!movingCommand.equals(MOVING_MENU_UP) && !movingCommand.equals(MOVING_MENU_DOWN)) {
            throw new IllegalArgumentException(ERROR_MOVING_MENU);
        }
    }

    private void validateMovingCommandLength(String movingCommand) {
        if (movingCommand.length() != MOVING_MENU_LENGTH) {
            throw new IllegalArgumentException(ERROR_MOVING_COMMAND_LENGTH);
        }
    }
}
