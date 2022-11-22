package bridge;

public enum BridgeConstant {
    UP_SUCCESS("UU",true),
    DOWN_SUCCESS("DD", true),
    UP_FAIL("UD",false),
    DOWN_FAIL("DU", false);

    String playAndComLocation;
    Boolean successStatus;

    BridgeConstant(String playAndComLocation, Boolean successStatus) {
        this.playAndComLocation = playAndComLocation;
        this.successStatus = successStatus;
    }

    public String getPlayAndComLocation() {
        return playAndComLocation;
    }
}
