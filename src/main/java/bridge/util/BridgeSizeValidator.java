package bridge.util;

import bridge.domain.ErrorMessage;

public class BridgeSizeValidator {

    private static final String ERROR_WRONG = "올바른 값을 입력해주세요.";
    private static final String ERROR_NOT_DIGIT = "다리의 길이는 3 이상 20 이하여야 합니다.";

    public void run(String bridgeSize){
        validateDigit(bridgeSize);
        validateRange(bridgeSize);
    }

    public void validateDigit(String bridgeSize){
        if (!bridgeSize.matches("-?\\d+(\\.\\d+)?")){
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
        }
    }

    public void validateRange(String bridgeSize){
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_RANGE.getMessage());
        }
    }
}
