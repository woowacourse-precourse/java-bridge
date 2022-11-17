package bridge.utils;

import camp.nextstep.edu.missionutils.Console;

public class BridgeSizeValidator {

    public static void checkBridgeSize(String strBridgeSize) {
        checkBridgeSizeNumber(strBridgeSize);
        checkBridgeSizeRange(Integer.parseInt(strBridgeSize));
    }
    private static void checkBridgeSizeRange(int bridgeSize){
        if (bridgeSize < 3) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상의 숫자여야만 합니다.");
        }
        if(bridgeSize>20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 20이하의 숫자여야만 합니다.");
        }
    }

    private static void checkBridgeSizeNumber(String strBridgeSize){
        try {
            int bridgeSize = Integer.parseInt(strBridgeSize);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력해야 합니다.");
        }
    }
}
