package bridge.validator;

import bridge.constant.ErrorConstant;
import bridge.util.TypeConversionUtil;

import java.util.regex.Pattern;

public class InputBridgeSizeValidator {

    private static final String DIGIT_VALIDATE_REGEX = "-?[0-9]+";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public void validate(String bridgeSize) {
        if (isBridgeSizeNotDigit(bridgeSize)) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "다리 길이는 숫자여야합니다.");
        }
        if (isWrongBridgeSizeRange(bridgeSize)) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "다리 길이는 3이상 20이하여야합니다.");
        }
    }

    private boolean isBridgeSizeNotDigit(String bridgeSize) {
        return !Pattern.compile(DIGIT_VALIDATE_REGEX).matcher(bridgeSize).matches();
    }

    private boolean isWrongBridgeSizeRange(String bridgeSize) {
        int convertedBridgeSize = TypeConversionUtil.StringToInt(bridgeSize);
        return convertedBridgeSize < MIN_BRIDGE_SIZE || convertedBridgeSize > MAX_BRIDGE_SIZE;
    }
}
