package bridge.vallidation;

import java.util.List;

import static bridge.constant.ErrorConstant.ERROR_NOT_VALID_LOCATION;

public class BridgeValidation {
    public static void isValidUserLocation(int location, int bridgeSize) {
        if (location >= bridgeSize) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_LOCATION);
        }
    }
}
