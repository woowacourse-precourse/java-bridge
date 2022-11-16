package util;

import response.UserInputException;
import response.ErrorResponse;

public class ValidationUtil {

    public void validateBridgeSizeInput(int sizeInput) {
        if (sizeInput < 3 || sizeInput > 20) {
            throw new UserInputException(ErrorResponse.INPUT_BRIDE_SIZE_RANGE_ERROR);
        }
    }
}
