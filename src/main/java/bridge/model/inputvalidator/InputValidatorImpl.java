package bridge.model.inputvalidator;

import static bridge.model.inputvalidator.ErrorMessage.NOT_ALLOWED_DATA_TYPE;
import static bridge.model.inputvalidator.ErrorMessage.OUT_OF_RANGE;

public class InputValidatorImpl implements InputValidator {

    @Override
    public int bridgeSizeDataType(String input) {
        int convertedInput = 0;
        try {
            convertedInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_ALLOWED_DATA_TYPE.getErrorMessage());
        }
        return convertedInput;
    }

    @Override
    public void bridgeSizeRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getErrorMessage());
        }
    }

    @Override
    public void bridgeSize(String input) {
        bridgeSizeRange(bridgeSizeDataType(input));
    }

    @Override
    public void moving(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_MOVING.getErrorMessage());
        }
    }

    @Override
    public void gameCommand(String input) {
        throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_GAME_COMMAND.getErrorMessage());
    }
}
