package bridge;

import java.util.regex.Pattern;

import static bridge.ValidateDetail.*;

public class Validate {

    public void isBridgeSize(String input) {
        if (!isBridgeSizeRange(input)) {
            throw new IllegalArgumentException(RANGE_ERROR.getErrorMassage());
        }
    }

    public void isMoving(String input) {
        if (!isUpOrDown(input)) {
            throw new IllegalArgumentException(MOVING_ERROR.getErrorMassage());
        }
    }

    public void isGameCommand(String input) {
        if (!isRestartOrQuit(input)) {
            throw new IllegalArgumentException(COMMAND_ERROR.getErrorMassage());
        }
    }

    private boolean isRestartOrQuit(String input) {
        return Pattern.matches(RESTART_OR_QUIT_PATTERN.getPattern(), input);
    }

    private boolean isBridgeSizeRange(String input) {
        if (isNumeric(input)) {
            return (MIN_BRIDGE_SIZE.getSize() <= Integer.parseInt(input)
                    && Integer.parseInt(input) <= MAX_BRIDGE_SIZE.getSize());
        }
        return false;
    }

    private boolean isUpOrDown(String input) {
        return Pattern.matches(UP_OR_DOWN_PATTERN.getPattern(), input);
    }

    private boolean isNumeric(String input) {
        return Pattern.matches(NUMERIC_PATTERN.getPattern(), input);
    }
}
