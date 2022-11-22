package bridge.constant;

public enum BridgeLengthConstant {
    BRIDGE_LENGTH(3,20);

    private final int bridgeLengthStartsFrom;
    private final int bridgeLengthEndsWith;

    BridgeLengthConstant(int bridgeLengthStartsFrom, int bridgeLengthEndsWith) {
        this.bridgeLengthStartsFrom = bridgeLengthStartsFrom;
        this.bridgeLengthEndsWith = bridgeLengthEndsWith;
    }

    public int getBridgeLengthStartsFrom() {
        return this.bridgeLengthStartsFrom;
    }

    public int getBridgeLengthEndsWith() {
        return this.bridgeLengthEndsWith;
    }
}
