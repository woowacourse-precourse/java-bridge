package validation;

import static bridge.constant.Validation.*;

public class Validator {

    public void validateBridgeLength(String bridgeLength) {
        if (!bridgeLength.matches(PATTERN)) {
            throw new IllegalArgumentException(INPUT_THREE_TO_TWENTY);
        }
        if (Integer.parseInt(bridgeLength) > LAST_LENGTH || Integer.parseInt(bridgeLength) < FIRST_LENGTH) {
            throw new IllegalArgumentException(INPUT_THREE_TO_TWENTY);
        }
    }
}
