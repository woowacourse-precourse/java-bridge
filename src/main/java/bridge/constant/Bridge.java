package bridge.constant;

import java.util.Arrays;

public enum Bridge {
    LOWER_BRIDGE("D", 0),
    UPPER_BRIDGE("U", 1);

    private final String sign;
    private final int bridgeType;

    Bridge(String sign, int bridgeType) {
        this.sign = sign;
        this.bridgeType = bridgeType;
    }

    public static String toSign(int bridgeType) {
        return Arrays.stream(Bridge.values())
                .filter(bridge -> bridge.bridgeType == bridgeType)
                .map(bridge -> bridge.sign)
                .findFirst()
                .orElse(null);
    }

    public static boolean contains(String sign) {
        return Arrays.stream(Bridge.values())
                .anyMatch(bridge -> bridge.sign.equals(sign));
    }

    public String getSign() {
        return sign;
    }
}
