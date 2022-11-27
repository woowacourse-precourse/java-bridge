package bridge.type;

public enum BridgeType {
    UP("U", 1),
    DOWN("D", 0);

    private final String code;
    private final int numberCode;

    BridgeType(String code, int numberCode) {
        this.code = code;
        this.numberCode = numberCode;
    }

    public String getCode() {
        return code;
    }

    public int getNumberCode() {
        return numberCode;
    }

}
