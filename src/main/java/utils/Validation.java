package utils;

import static constant.ErrorMessage.*;
import static constant.ErrorMessage.*;

public class Validation {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 20;

    public Validation() {

    }

    public void validBridgeSize(String bridgeSize) throws IllegalArgumentException {
        try {
            validBridgeLengthRange(Long.parseLong(bridgeSize));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(String.format(ASK_INPUT_VALUE, ERROR_HEAD_MESSAGE));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ASK_INPUT_NUMBER, ERROR_HEAD_MESSAGE));
        }
    }

    private void validBridgeLengthRange(long bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < MINIMUM_LENGTH || bridgeSize > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format(WRONG_LENGTH, ERROR_HEAD_MESSAGE));
        }
    }


}
