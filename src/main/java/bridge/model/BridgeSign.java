package bridge.model;

import bridge.util.ExceptionMessage;
import java.util.Arrays;

public enum BridgeSign {

    UP("U", 1), DOWN("D", 0);

    private final String sign;
    private final int number;

    BridgeSign(String sign, int number) {
        this.sign = sign;
        this.number = number;
    }

    public static BridgeSign from(int number) {
        return Arrays.stream(BridgeSign.values())
                .filter(sign -> sign.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_BRIDGE_SIGN_NUMBER.getMessage()));
    }

    public String getSign() {
        return sign;
    }
}
