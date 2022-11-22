package bridge.validator;

import static bridge.utils.command.MoveCommand.DOWN;
import static bridge.utils.command.MoveCommand.UP;
import static bridge.utils.message.ErrorMessage.BLANK_VALUE;
import static bridge.utils.message.ErrorMessage.INVALID_VALUE;
import static bridge.utils.message.ErrorMessage.LOWERCASE_VALUE;

public class MovingValidator implements Validator {
    @Override
    public void validate(String inputValue) {
        checkBlankValue(inputValue);
        checkLowercaseValue(inputValue);
        checkInvalidMoving(inputValue);
    }

    private void checkBlankValue(String inputValue) {
        if (inputValue.isBlank()) {
            System.out.println(BLANK_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkLowercaseValue(String inputValue) {
        if (isLowercaseValue(inputValue)) {
            System.out.println(LOWERCASE_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private boolean isLowercaseValue(String inputValue) {
        return UP.isLowerCaseCommand(inputValue) || DOWN.isLowerCaseCommand(inputValue);
    }

    private void checkInvalidMoving(String inputValue) {
        if (!isValidMoving(inputValue)) {
            System.out.println(INVALID_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidMoving(String inputValue) {
        return UP.equalCommand(inputValue) || DOWN.equalCommand(inputValue);
    }
}
