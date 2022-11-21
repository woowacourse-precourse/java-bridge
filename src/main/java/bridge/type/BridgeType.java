package bridge.type;

public enum BridgeType {
    UP("U", 1),
    DOWN("D", 0);

    private final String stringCode;
    private final int intCode;

    BridgeType(String stringCode, int intCode) {
        this.stringCode = stringCode;
        this.intCode = intCode;
    }

    public String getStringCode() {
        return stringCode;
    }

    public int getIntCode() {
        return intCode;
    }

}
