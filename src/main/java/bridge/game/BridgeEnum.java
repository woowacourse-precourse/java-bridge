package bridge.game;

import bridge.resource.ErrorMessage;

public enum BridgeEnum {
    U(1),
    D(0);

    private int value;

    BridgeEnum(int value) {
        this.value = value;
    }

    public static String getDivision(int value) {
        String data = "";
        for (BridgeEnum bridgeEnum : BridgeEnum.values()) {
            if (value == bridgeEnum.value) {
                data = bridgeEnum.name();
            }
        }
        return data;
    }
}
