package bridge.validation;

import static bridge.util.Constant.*;

public class Validation {

    public static void checkBridgeLengthConsistOfNum(String bridgeLength){
        if(!bridgeLength.matches(BRIDGE_LENGTH_REGEX)){
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_LENGTH_CONSIST_OF_NUM);
        }
    }

}
