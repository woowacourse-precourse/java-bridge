package bridge.domain;

import static bridge.domain.util.Message.BRIDGE_SIZE_MESSAGE;
import static bridge.domain.util.Message.MOVE_ERROR_MESSAGE;
import static bridge.domain.util.Message.RETRY_ERROR_MESSAGE;

import bridge.domain.util.Message;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern pattern = Pattern.compile("^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$");

    public void validateBridgeSize(String bridgeSize) {
        if (!pattern.matcher(bridgeSize).find()) {
            throw new IllegalArgumentException(BRIDGE_SIZE_MESSAGE);
        }
    }

    public void validateMoving(String moving) {
        try {
            Direction.from(moving);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MOVE_ERROR_MESSAGE);
        }
    }

    public void validateGameCommand(String gameCommand) {
        try {
            GameCommand.from(gameCommand);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(RETRY_ERROR_MESSAGE);
        }
    }
}
