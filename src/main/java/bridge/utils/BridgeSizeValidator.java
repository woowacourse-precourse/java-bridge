package bridge.utils;

public class BridgeSizeValidator {

    public static int checkBridgeSize(String strBridgeSize){
        try {
            int bridgeSize = Integer.parseInt(strBridgeSize);
            if (bridgeSize >= 3 && bridgeSize <= 20) {
                return bridgeSize;
            } else {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력해야 합니다.");
        }
    }
}
