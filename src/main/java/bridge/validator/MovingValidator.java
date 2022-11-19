package bridge.validator;

import static bridge.utils.command.MoveCommand.DOWN;
import static bridge.utils.command.MoveCommand.UP;
import static bridge.utils.message.ErrorMessage.BLANK_VALUE;
import static bridge.utils.message.ErrorMessage.INVALID_MOVING;

import java.util.Objects;

public class MovingValidator implements Validator {
    @Override
    public void validate(String inputValue) {
        checkInvalidMoving(inputValue);
        checkBlankValue(inputValue);
    }

    private void checkInvalidMoving(String inputValue) {
        if (!isValidMoving(inputValue)) {
            System.out.println(String.format(INVALID_MOVING.getMessage(), UP.getCommand(), DOWN.getCommand()));
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidMoving(String inputValue) {
        return Objects.equals(inputValue, UP.getCommand()) || Objects.equals(inputValue, DOWN.getCommand());
    }

    private void checkBlankValue(String inputValue) {
        if (inputValue.isBlank()) {
            System.out.println(BLANK_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
