package bridge.validator;

import static bridge.util.BridgeGameConstant.DOWN_SIGN;
import static bridge.util.BridgeGameConstant.UP_SIGN;
import static bridge.validator.ErrorStatus.DIRECTION_SIGN_ERROR;

public class DirectionValidator implements Validator {

    public DirectionValidator() {
    }

    @Override
    public void validate(String direction) {
        if (!UP_SIGN.equals(direction) && !DOWN_SIGN.equals(direction)) {
            throw new IllegalArgumentException(DIRECTION_SIGN_ERROR.getMessage());
        }
    }
}
