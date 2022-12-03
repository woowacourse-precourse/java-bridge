package bridge.model.bridge;

import bridge.util.ExceptionMessage;
import java.util.Arrays;

public enum BridgeDirection {

    UP("U", 1), DOWN("D", 0);

    private final String sign;
    private final int number;

    BridgeDirection(String sign, int number) {
        this.sign = sign;
        this.number = number;
    }

    public static BridgeDirection from(int number) {
        return Arrays.stream(BridgeDirection.values())
                .filter(element -> element.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_BRIDGE_SIGN_NUMBER.getMessage()));
    }

    public static BridgeDirection from(String sign) {
        return Arrays.stream(BridgeDirection.values())
                .filter(element -> element.sign.equals(sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_BRIDGE_SIGN_SIGN.getMessage()));
    }
    public String getSign() {
        return sign;
    }

    public static boolean isSame(BridgeDirection sign1, BridgeDirection sign2){
        return sign1 == sign2;
    }
}
