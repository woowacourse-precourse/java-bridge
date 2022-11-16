package bridge.util;

import bridge.constant.BridgeRange;

public class Validator {

    public static void validateNumberInBridgeRange(int number) {
        int minRange = BridgeRange.MIN.getValue();
        int maxRange = BridgeRange.MAX.getValue();

        if (!(minRange <= number && number <= maxRange)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
