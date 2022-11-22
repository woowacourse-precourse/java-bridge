package bridge.util;

import bridge.response.UserInputException;
import bridge.response.ErrorResponse;

public class ValidationUtil {

    public void validateBridgeSizeInput(String bridgeSize) {
        int sizeInput = Integer.parseInt(bridgeSize);
        if (sizeInput < 3 || sizeInput > 20) {
            throw new UserInputException(ErrorResponse.INPUT_BRIDGE_SIZE_RANGE_ERROR);
        }
    }

    public void validateBridgeSizeDigitInput(String sizeInput) {
        if (!sizeInput.chars().allMatch(Character::isDigit)) {
            throw new UserInputException(ErrorResponse.INPUT_BRIDGE_SIZE_NOT_NUMBER_ERROR);
        }
    }

    public void validateBridgeSizeNullInput(String bridgeSize) {
        if (bridgeSize.equals("")) {
            throw new UserInputException(ErrorResponse.INPUT_BRIDGE_SIZE_NULL_ERROR);
        }
    }

    public void validateUserMovement(String movement) {
        if (!movement.equals("U") && !movement.equals("D")) {
            throw new UserInputException(ErrorResponse.INPUT_MOVEMENT_ERROR);
        }
    }

    public void validateUserMovementIfNull(String movement) {
        if (movement.equals("")) {
            throw new UserInputException(ErrorResponse.INPUT_MOVEMENT_NULL_ERROR);
        }
    }

    public void validateExitCode(String exitCode) {
        if (!exitCode.equals("R") && !exitCode.equals("Q")) {
            throw new UserInputException(ErrorResponse.INPUT_EXITCODE_ERROR);
        }
    }

    public ValidationUtil() {
    }
}
