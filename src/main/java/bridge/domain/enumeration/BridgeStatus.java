package bridge.domain.enumeration;

public enum BridgeStatus {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String name;

    BridgeStatus(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
