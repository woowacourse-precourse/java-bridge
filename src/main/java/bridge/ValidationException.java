package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static bridge.constants.ErrorMessage.*;
import static bridge.constants.ConstMessage.*;
import static bridge.model.moving.*;

public class ValidationException {

    public static final int MAXIMUM_LENGTH = 20;
    public static final int MINIMUM_LENGTH = 3;

    public boolean checkValidNumber(String bridgeLength) throws IllegalArgumentException {
        String regExp = "\\d+";
        if (Pattern.matches(regExp, bridgeLength)){
            int length = Integer.parseInt(bridgeLength);
            if (length < MINIMUM_LENGTH || length > MAXIMUM_LENGTH) {
                throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INVALID_NUMBER);
            }
            return true;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INVALID_NUMBER);
    }

    public boolean checkValidMovement(String movement) {
        List<String> validMovement = new ArrayList<>(List.of(up.getUpDown(), down.getUpDown()));
        if (validMovement.contains(movement)) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INVALID_MOVEMENT);
    }

    public boolean checkValidCommand(String command) {
        List<String> validMovement = new ArrayList<>(List.of(QUIT, RETRY));
        if (validMovement.contains(command)) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INVALID_RETRY);
    }
}
