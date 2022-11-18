package bridge.domain;

import java.util.Arrays;

public enum BridgeUnit {
    DOWN("D", 0),
    UP("U", 1);

    private final String code;
    private final int number;

    BridgeUnit(String code, int number) {
        this.code = code;
        this.number = number;
    }

    public static BridgeUnit from(String code) {
        return Arrays.stream(BridgeUnit.values())
                .filter(bridgeUnit -> code.equals(bridgeUnit.code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 코드입니다."));
    }

    public static String numberToCode(Integer number) {
        return Arrays.stream(BridgeUnit.values())
                .filter(bridgeUnit -> number.equals(bridgeUnit.number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 코드입니다."))
                .getCode();
    }

    public String getCode() {
        return code;
    }
}
