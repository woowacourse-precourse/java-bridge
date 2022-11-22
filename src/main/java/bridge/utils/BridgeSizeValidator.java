package bridge.utils;

import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.ErrorEnum.*;

public class BridgeSizeValidator {
    private final static int minNum=3;
    private final static int maxNUm=3;

    public static void checkBridgeSize(String strBridgeSize) {
        checkBridgeSizeNumber(strBridgeSize);
        checkBridgeSizeRange(Integer.parseInt(strBridgeSize));
    }
    private static void checkBridgeSizeRange(int bridgeSize){
        if (bridgeSize < minNum) {
            throw new IllegalArgumentException(BRIDGE_SIZE_SMALLER_THAN_THREE.getMessage());
        }
        if(bridgeSize>maxNUm){
            throw new IllegalArgumentException(BRIDGE_SIZE_BIGGER_THAN_TWENTY.getMessage());
        }
    }

    private static void checkBridgeSizeNumber(String strBridgeSize){
        try {
            int bridgeSize = Integer.parseInt(strBridgeSize);
        } catch (Exception e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_NOT_INT.getMessage());
        }
    }
}
