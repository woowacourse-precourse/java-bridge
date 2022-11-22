package bridge;

public enum BridgeStatus {
    UP(Constant.UP, 1),
    DOWN(Constant.DOWN, 0);

    private final String bridgeCharacter;
    private final Integer bridgeNumber;

    BridgeStatus(String bridgeCharacter, Integer bridgeNumber) {
        this.bridgeCharacter = bridgeCharacter;
        this.bridgeNumber = bridgeNumber;
    }

    public String getBridgeCharacter() {
        return this.bridgeCharacter;
    }

    public Integer getBridgeNumber() {
        return this.bridgeNumber;
    }

}
