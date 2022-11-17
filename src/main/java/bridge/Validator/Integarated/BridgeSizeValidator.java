package bridge.Validator.Integarated;

import bridge.Enum.BridgeSizeInfo;
import bridge.Validator.NumericValidator;
import bridge.Validator.RangeValidator;

public class BridgeSizeValidator implements NumericValidator, RangeValidator {
    int MIN_SIZE = BridgeSizeInfo.MIN_SIZE.getInfo();
    int MAX_SIZE = BridgeSizeInfo.MAX_SIZE.getInfo();

    public void validate(final String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        if (!isValidRange(MIN_SIZE,MAX_SIZE,Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] "+MIN_SIZE+"~"+MAX_SIZE+" 사이의 숫자를 입력해 주세요.");
        }
    }
}
