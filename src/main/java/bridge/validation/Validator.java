package bridge.validation;

import static bridge.constant.BridgeConstant.*;
import static bridge.constant.ErrorMessage.*;
import static bridge.constant.GameCommand.*;

public class Validator {

    public String validateBridgeSize(String bridgeSize) {
        validateBridgeSizeFormat(bridgeSize);
        validateBridgeSizeRange(bridgeSize, BRIDGE_SIZE_START_INCLUSIVE.getValue(), BRIDGE_SIZE_END_INCLUSIVE.getValue());

        return bridgeSize;
    }

    public String validateBridgeSizeFormat(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE.getMessage());
        }

        return bridgeSize;
    }

    public void validateBridgeSizeRange(String bridgeSize, int startInclusive, int endInclusive) {
        int parsedBridgeSize = Integer.parseInt(bridgeSize);
        if (parsedBridgeSize < startInclusive || parsedBridgeSize > endInclusive) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public String validateStep(String step) {
        if (!step.equals(USER_STEP_FOR_UPPER_LAYER.getCommand()) &&
                !step.equals(USER_STEP_FOR_LOWER_LAYER.getCommand())) {
            throw new IllegalArgumentException(ERROR_INVALID_USER_STEP.getMessage());
        }

        return step;
    }

    public String validateRetryCommand(String command) {
        if (!command.equals(COMMAND_FOR_RETRY.getCommand()) &&
                !command.equals(COMMAND_FOR_QUIT.getCommand())) {
            throw new IllegalArgumentException(ERROR_INVALID_RETRY_COMMAND.getMessage());
        }

        return command;
    }
}
