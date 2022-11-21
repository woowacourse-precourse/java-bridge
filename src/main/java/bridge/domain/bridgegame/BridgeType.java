package bridge.domain.bridgegame;

import java.util.Arrays;

public enum BridgeType {
    UP_VALUE(1, "U"),
    DOWN_VALUE(0, "D");

    private final int bridgeTypeValue;
    private final String bridgeType;

    BridgeType(final int bridgeTypeValue, final String bridgeType) {
        this.bridgeTypeValue = bridgeTypeValue;
        this.bridgeType = bridgeType;
    }

    public static BridgeType getBridgeType(int number) {
        return Arrays.stream(BridgeType.values())
                .filter(bridgeTypeValue -> bridgeTypeValue.isMatch(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] generator() 메서드 문제가 발생했습니다."));
    }

    private boolean isMatch(int number) {
        return this.bridgeTypeValue == number;
    }

    public String getUpOrDown() {
        return bridgeType;
    }
}
