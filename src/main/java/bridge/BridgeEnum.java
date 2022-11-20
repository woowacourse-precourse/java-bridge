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

    public static BridgeEnum createBridgeNumberType(int locationNumber) {
        return Arrays.stream(values())
                .filter(pointValue -> pointValue.bridgeNumberType == locationNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 정보입니다."));
    }

    public static BridgeEnum createBridgeStringType(String location) {
        return Arrays.stream(values())
                .filter(locationValue -> locationValue.bridgeStringType.equals(location))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력은 대문자 'U', 'D'만 입력가능합니다"));
    }

    public String getStringType() {
        return bridgeStringType;
    }

}
