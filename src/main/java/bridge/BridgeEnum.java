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

    public static BridgeEnum createBridgeType(int bridgeNumberType) {
        return Arrays.stream(values())
                .filter(pointValue -> pointValue.bridgeNumberType == bridgeNumberType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 정보입니다."));
    }

    public String getStringType() {
        return bridgeStringType;
    }

}
