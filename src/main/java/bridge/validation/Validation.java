package bridge.validation;

import static bridge.util.Constant.*;

public class Validation {

    public static void checkBridgeLengthConsistOfNum(String bridgeLength){
        if(!bridgeLength.matches(BRIDGE_LENGTH_REGEX)){
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_LENGTH_CONSIST_OF_NUM);
        }
    }

    // 다리의 길이 입력값이 3이상 20이하인지 검증하는 기능
    public static void checkBridgeLengthRange3To20(String bridgeLengthInput) {
        int bridgeLength = Integer.parseInt(bridgeLengthInput);
        if (!(BRIDGE_LENGTH_MIN <= bridgeLength && bridgeLength <= BRIDGE_LENGTH_MAX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_LENGTH_RANGE_3_TO_20);
        }
    }

}
