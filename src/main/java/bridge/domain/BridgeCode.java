package bridge.domain;

import java.util.Arrays;

public enum BridgeCode {
    DOWN("D", 0),
    UP("U", 1);

    private final String code;
    private final int number;

    BridgeCode(String code, int number) {
        this.code = code;
        this.number = number;
    }

    public static String numberToCode(Integer number) {
        return Arrays.stream(BridgeCode.values())
                .filter(bridgeCode -> number.equals(bridgeCode.number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 코드입니다."))
                .getCode();
    }

    public String getCode() {
        return code;
    }
}
