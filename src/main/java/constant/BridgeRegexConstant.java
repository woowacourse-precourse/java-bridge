package constant;

public enum BridgeRegexConstant {
    BRIDGE_SIZE_REGEX("^[0-9]*$");

    public final String bridgeRegexConstant;

    BridgeRegexConstant(final String bridgeRegexConstant) {
        this.bridgeRegexConstant = bridgeRegexConstant;
    }

    public String getConstant() {
        return bridgeRegexConstant;
    }
}
