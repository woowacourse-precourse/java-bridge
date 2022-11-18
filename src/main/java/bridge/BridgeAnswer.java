package bridge;

public enum BridgeAnswer {

    UP(1, "U"), DOWN(0, "D");

    private final int value;
    private final String name;

    BridgeAnswer(int value, String name) {
        this.value = value;
        this.name = name;
    }

    int getValue() {
        return value;
    }

    String getName() {
        return name;
    }
}
