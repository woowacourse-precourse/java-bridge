package bridge.Validator.Integarated;

import bridge.Enum.BridgeInfo;
import bridge.Validator.NumericValidator;
import bridge.Validator.RangeValidator;

import static bridge.Enum.ErrorMessage.BRIDGE_SIZE_ERROR;
import static bridge.Enum.ErrorMessage.NUMERIC_ERROR;

public class BridgeSizeValidator implements NumericValidator, RangeValidator {
    int MIN_SIZE = BridgeInfo.MIN_SIZE.getInfo();
    int MAX_SIZE = BridgeInfo.MAX_SIZE.getInfo();

    public void validate(final String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(NUMERIC_ERROR.getMessage());
        }
        if (!isValidRange(MIN_SIZE,MAX_SIZE,Integer.parseInt(input))) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR.getMessage());
        }
    }
}
