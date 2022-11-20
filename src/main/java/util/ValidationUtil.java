package util;

import response.UserInputException;
import response.ErrorResponse;

public class ValidationUtil {

    public void validateBridgeSizeInput(int sizeInput) {
        if (sizeInput < 3 || sizeInput > 20) {
            throw new UserInputException(ErrorResponse.INPUT_BRIDGE_SIZE_RANGE_ERROR);
        }
    }

    public void validateBridgeSizeDigitInput(String sizeInput) {
        if (!sizeInput.chars().allMatch(Character::isDigit)) {
            throw new UserInputException(ErrorResponse.INPUT_BRIDGE_NOT_NUMBER_ERROR);
        }
    }

    public void validateUserMovement(String movement) {
        if (!movement.equals("U") && !movement.equals("D")) {
            throw new UserInputException(ErrorResponse.INPUT_MOVEMENT_ERROR);
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
