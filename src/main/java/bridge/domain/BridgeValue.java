package bridge.domain;

public enum BridgeValue {

    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String value;

    BridgeValue(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public int getNumber() {
        return this.number;
    }
}

