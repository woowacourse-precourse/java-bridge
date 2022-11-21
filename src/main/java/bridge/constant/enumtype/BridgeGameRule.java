package bridge.constant.enumtype;

public enum BridgeGameRule {
    RETRY("R"), QUIT("Q"), MOVE_UP("U"), MOVE_DOWN("D");

    private String value;

    BridgeGameRule(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
