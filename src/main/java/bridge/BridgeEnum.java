package bridge;

import java.util.Arrays;

public enum BridgeEnum {
    U(1,"U"),
    D(0,"D");

    private final int bridgeNumberType;
    private final String bridgeStringType;
    BridgeEnum(int numberType, String stringType) {
        this.bridgeNumberType = numberType;
        this.bridgeStringType = stringType;
    }


}
