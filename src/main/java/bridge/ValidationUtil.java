package bridge;

import java.util.regex.Pattern;

import static bridge.constant.BridgeConst.*;
import static bridge.constant.message.ExceptionMessage.*;

public class ValidationUtil {

    /**
     * 사용자가 입력한 다리의 길이에 대해 검증을 진행한다.
     *
     * @param input 사용자의 입력값
     * @return 검증된 다리의 길이
     */
    public int validateBridgeLength(String input) {
        checkNumberType(input);
        int bridgeLength = Integer.parseInt(input);
        checkNumberRange(bridgeLength);
        return bridgeLength;
    }

    private void checkNumberType(String input) {
        String regex = "[0-9]+";

        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_TYPE.getMessage());
        }
    }

    private void checkNumberRange(int input) {
        if (input < MIN_LENGTH.getNumber() || input > MAX_LENGTH.getNumber()) {
            throw new IllegalArgumentException(String.format(BRIDGE_LENGTH_RANGE.getMessage(),
                    MIN_LENGTH.getNumber(), MAX_LENGTH.getNumber()));
        }
    }
}
