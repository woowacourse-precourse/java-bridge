package bridge;

import java.util.Arrays;

public enum BridgeMapper {

    DOWN(0, "D"),
    UP(1, "U");

    private final int upDownNumber;
    private final String upDownString;

    BridgeMapper(int bridgeNumber, String bridgeString) {
        this.upDownNumber = bridgeNumber;
        this.upDownString = bridgeString;
    }

    public static String convertBridgeNumberToBridgeString(int number) {
        return Arrays.stream(values())
                .filter(bridgeMapper -> bridgeMapper.isSameNumber(number))
                .findAny()
                .map(BridgeMapper::getBridgeString)
                .get();
    }

    private boolean isSameNumber(int number) {
        return this.upDownNumber == number;
    }

    public String getBridgeString() {
        return upDownString;
    }
}
