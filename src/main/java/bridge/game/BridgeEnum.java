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
        for (BridgeEnum bridgeEnum : BridgeEnum.values()) {
            if (bridgeEnum.value == value) {
                return bridgeEnum.name();
            }
        }
        throw new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR);
    }
}
