package bridge.validator;

import static bridge.util.BridgeGameConstant.VALID_MAX_RANGE;
import static bridge.util.BridgeGameConstant.VALID_MIN_RANGE;
import static bridge.validator.ErrorStatus.BRIDGE_SIZE_RANGE_ERROR;
import static bridge.validator.ErrorStatus.BRIDGE_SIZE_TYPE_ERROR;

public class BridgeSizeValidator implements Validator {

    public BridgeSizeValidator() {
    }

    @Override
    public void validate(String bridgeSize) {
        if (!hasValidType(bridgeSize)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_TYPE_ERROR.getMessage());
        }

        if (!hasValidRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }

    private boolean hasValidType(String bridgeSize) {
        return bridgeSize.chars().allMatch(Character::isDigit);
    }

    private boolean hasValidRange(int bridgeSize) {
        return bridgeSize >= VALID_MIN_RANGE && bridgeSize <= VALID_MAX_RANGE;
    }
}
